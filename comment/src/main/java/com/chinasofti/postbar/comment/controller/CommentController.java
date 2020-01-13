package com.chinasofti.postbar.comment.controller;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.speech.TtsResponse;
import com.chinasofti.postbar.comment.basic.BasicController;
import com.chinasofti.postbar.comment.dto.*;
import com.chinasofti.postbar.comment.service.CommentService;
import com.chinasofti.postbar.comment.service.PostService;
import com.chinasofti.postbar.comment.util.AudioSynthesis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping(value="/commentController")
public class CommentController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @ModelAttribute
    @RequestMapping(value="/getInit")
    public void getInit(HttpServletResponse response, HttpServletRequest request, String postUUID){
        logger.info("calling CommentController [getInit]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            PostDto postDto=commentService.selectPostByPostUUID(postUUID);
            json.put("post", postDto);
            UserDto userDto=commentService.selectUserByUserUUID(postDto.getUserUUID());
            json.put("user", userDto);

            RegisterDto registerDto=commentService.selectRegister(postDto.getUserUUID());
            json.put("register", registerDto);

            List<PostPraiseDto> list= commentService.selectPraiseByPostUUID(postUUID);
            json.put("postPraise", list);


            commentService.updatePostPageviews(postUUID, postDto.getPostPageviews()+1);

            String myUserUUID=(String) session.getAttribute("id");
            json.put("myUserUUID", myUserUUID);

            String myAdmin=(String) session.getAttribute("admin");
            json.put("myAdmin", myAdmin);

            List<CommentDto> hotsCommentlist=commentService.selectCommentHotsByPostUUID(postUUID);
            json.put("hotsCommentlist", hotsCommentlist);

            List<CommentDto> allCommentlist=commentService.selectAllCommentByPostUUID(postUUID);
            json.put("allCommentlist", allCommentlist);
        }
        this.writeJson(json.toString(), response);
    }

    @Value("${audio}")
    private String HTML_PATH;
    @ModelAttribute
    @RequestMapping(value="/addCom")
    public void addCom(HttpServletResponse response,HttpServletRequest request,String cmText,String postUUID){
        logger.info("calling CommentController [addCom]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userUUID=(String) session.getAttribute("id");
            String cmUUID=this.getUUID();
            String cmTime=this.getStringDate(new Date());
            CommentDto commentDto=new CommentDto();
            commentDto.setCmText(cmText);
            commentDto.setCmTime(cmTime);
            commentDto.setCmUUID(cmUUID);
            commentDto.setPostUUID(postUUID);
            commentDto.setUserUUID(userUUID);


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

//			String path=HTML_PATH+"audio\\" ;
            String path=HTML_PATH;

            String urlPath=request.getContextPath() + "/audio/"+cmUUID+".mp3";
            File uploadDir = new File(path);
            if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
                uploadDir.mkdirs();
            }
            path+=cmUUID+".mp3";

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
                logger.warn("[test] load audio false");
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
            commentDto.setCmAudio(urlPath);
            commentService.insertComment(commentDto);
        }
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/deleteComment")
    public void deleteComment(HttpServletResponse response,HttpServletRequest request,@RequestParam(value = "cmUUID[]") String[] cmUUID){
        logger.info("calling CommentController [deleteComment]");
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            commentService.deleteComment(cmUUID);
        }
        this.writeJson(json.toString(), response);
    }

    @ModelAttribute
    @RequestMapping(value="/commentPraise")
    public void commentPraise(HttpServletResponse response,HttpServletRequest request,String postUUID,String cmUUID){
        logger.info("calling CommentController [commentPraise]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        json.put("praiseMessage", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String myUserUUID=(String) session.getAttribute("id");

            int p=commentService.selectCommentNumByParameter(postUUID, cmUUID, myUserUUID);

            if(p!=0){

                json.put("praiseMessage", "您已经对此评论点过赞了！");
            }else{

                CommentPraiseDto commentPraiseDto=new CommentPraiseDto();
                String cmPrUUID=this.getUUID();
                commentPraiseDto.setCmPrUUID(cmPrUUID);
                commentPraiseDto.setCmUUID(cmUUID);
                commentPraiseDto.setPostUUID(postUUID);
                commentPraiseDto.setUserUUID(myUserUUID);
                commentService.insertPraise(commentPraiseDto);

                String myAdmin=(String) session.getAttribute("admin");
                json.put("myAdmin", myAdmin);



                List<CommentDto> hotsCommentlist=commentService.selectCommentHotsByPostUUID(postUUID);
                json.put("hotsCommentlist", hotsCommentlist);

                List<CommentDto> allCommentlist=commentService.selectAllCommentByPostUUID(postUUID);
                json.put("allCommentlist", allCommentlist);

            }


        }
        this.writeJson(json.toString(), response);
    }

    @ModelAttribute
    @RequestMapping(value="/commentPostPraise")
    public void commentPostPraise(HttpServletResponse response,HttpServletRequest request,String postUUID){
        logger.info("calling CommentController [commentPostPraise]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String myUserUUID=(String) session.getAttribute("id");

            String poPrUUID=this.getUUID();
            PostPraiseDto pbPostPraiseDto=new PostPraiseDto();
            pbPostPraiseDto.setPoPrUUID(poPrUUID);
            pbPostPraiseDto.setPostUUID(postUUID);
            pbPostPraiseDto.setUserUUID(myUserUUID);
            commentService.insertPraise(pbPostPraiseDto);

            int praiseNum=commentService.selectPraiseNum(postUUID);
            json.put("praiseNum", praiseNum);
        }
        this.writeJson(json.toString(), response);
    }

}
