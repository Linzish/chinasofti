package com.chinasofti.postbar.mycomment.controller;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.speech.TtsResponse;
import com.chinasofti.postbar.mycomment.basic.BasicController;
import com.chinasofti.postbar.mycomment.dto.*;
import com.chinasofti.postbar.mycomment.service.*;
import com.chinasofti.postbar.mycomment.util.AudioSynthesis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping(value="/myCommentController")
//我的评论控制器
public class MyCommentController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(MyCommentController.class);

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @Value("${audio}")
    private String HTML_PATH;

    @ModelAttribute
    @RequestMapping(value="/selectMyCommentByUserUUID")
    public void selectMyCommentByUserUUID(HttpServletResponse response, HttpServletRequest request, int pageIndex, int everyPageDataCount){
        logger.info("calling MyCommentController [selectMyCommentByUserUUID]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            json.put("postAllNum", 0);
            json.put("allPage", 0);
            json.put("pageIndex", 0);
            json.put("myCommentlist", "");

            String userUUID=(String)session.getAttribute("id");

            int postAllNum=commentService.selectMyCommentNumByUserUUID(userUUID);
            json.put("postAllNum", postAllNum);
            if (postAllNum > 0){
                // 总页数变量
                int allPage = 1;
                // 计算总页数
                if ((postAllNum % everyPageDataCount) == 0) {
                    allPage = postAllNum / everyPageDataCount;
                } else {
                    allPage = postAllNum / everyPageDataCount + 1;
                }
                // 防止页码越界
                if (pageIndex < 0) {
                    pageIndex = 0;
                } else if (pageIndex >= allPage) {
                    pageIndex = allPage - 1;
                }


                json.put("allPage", allPage);
                json.put("pageIndex", pageIndex);

                List<CommentDto> myCommentlist=commentService.selectMyCommentByUserUUID(userUUID, pageIndex*everyPageDataCount , everyPageDataCount);
                json.put("myCommentlist", myCommentlist);
            }

        }
        this.writeJson(json.toString(), response);
    }

    @ModelAttribute
    @RequestMapping(value="/getCommentByCmUUID")
    public void getCommentByCmUUID(HttpServletResponse response,HttpServletRequest request,String cmUUID){
        logger.info("calling MyCommentController [getCommentByCmUUID]");
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String cmText=commentService.selectCmTextByCmUUID(cmUUID);
            json.put("cmText",cmText);
        }
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/editCom")
    public void editCom(HttpServletResponse response,HttpServletRequest request,String cmUUID,String cmText){
        logger.info("calling MyCommentController [editCom]");
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            HttpSession session=request.getSession();
            CommentDto commentDto=new CommentDto();
            commentDto.setCmUUID(cmUUID);
            commentDto.setCmText(cmText);
            commentDto.setCmTime(this.getStringDate(new Date()));
            commentService.updateCmByCmUUID(commentDto);

            String userUUID=(String)session.getAttribute("id");
            String text=this.removeHtmlTag(cmText);
            if(text.length()>1024){
                text=text.substring(0,1024);
            }
            AudioDto audioDto =postService.selectAudioByUserUUID(userUUID);
            int spd=audioDto.getAuSetSpd();
            int pit=audioDto.getAuSetPit();
            int vol=audioDto.getAuSetVol();
            int per=audioDto.getAuSetVoiPer();

            AppDto appDto=postService.selectApp();
            String APP_ID=appDto.getAppID();
            String API_KEY=appDto.getApiKey();
            String SECRET_KEY=appDto.getSecretKey();
            AudioSynthesis audioSynthesis=AudioSynthesis.getInstance(APP_ID, API_KEY, SECRET_KEY);
            TtsResponse res=audioSynthesis.synthesis(text, spd, pit, vol, per);
            byte[] data = res.getData();

            //String path=HTML_PATH+"audio\\" ;
            String path=HTML_PATH;


            File uploadDir = new File(path);
            if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
                logger.info("[test] Directory is not exist");
                uploadDir.mkdirs();
                logger.info("[test] mkdir");
            }

            path+=cmUUID+".mp3";
            logger.info("comment_urlpath:"+path);
            OutputStream out = null;
            InputStream is = null;
            try {
                out = new FileOutputStream(path);
                is = new ByteArrayInputStream(data);
                byte[] buff = new byte[1024];
                int len = 0;
                while((len=is.read(buff))!=-1){
                    out.write(buff, 0, len);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.warn("[test] audio file store false");
                e.printStackTrace();
            }finally{
                if(is!=null){
                    try {
                        is.close();

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }


        }
        this.writeJson(json.toString(), response);
    }

}
