package com.chinasofti.postbar.post.controller;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.speech.TtsResponse;
import com.chinasofti.postbar.post.basic.BasicController;
import com.chinasofti.postbar.post.dto.AppDto;
import com.chinasofti.postbar.post.dto.AudioDto;
import com.chinasofti.postbar.post.dto.PostDto;
import com.chinasofti.postbar.post.service.PostService;
import com.chinasofti.postbar.post.util.AudioSynthesis;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
//@RequestMapping(value="/postController")
public class PostController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @ModelAttribute
    @RequestMapping(value="/getPostList")
    public void getPostList(HttpServletResponse response, HttpServletRequest request, String postTitle, int pageIndex, int everyPageDataCount){
        logger.info("calling PostController [getPostList]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            json.put("postAllNum", 0);
            json.put("allPage", 0);
            json.put("pageIndex", 0);
            json.put("postList", "");
            json.put("admin", ((String)session.getAttribute("admin")));


            int postAllNum=postService.getPostAllNum(postTitle,null);
            json.put("postAllNum", postAllNum);

            if (postAllNum > 0) {
//				// 总页数变量
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
                List<PostDto> list=postService.selectPostList(postTitle, pageIndex*everyPageDataCount , everyPageDataCount,null);



                json.put("postList", list);
            }

        }

//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//		JSONObject jsonObject = JSONObject.fromObject(json,jsonConfig);

        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/deletePost")
    public void deletePost(HttpServletResponse response,HttpServletRequest request,@RequestParam(value = "postUUID[]") String[] postUUID){
        logger.info("calling PostController [deletePost]");
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            postService.deletePost(postUUID);
        }
        this.writeJson(json.toString(), response);
    }
    @Value("${audio}")
    private String HTML_PATH;
    @ModelAttribute
    @RequestMapping(value="/addPost")
    public void addPost(HttpServletResponse response,HttpServletRequest request,String postTitle,String postText){
        logger.info("calling PostController [addPost]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String postUUID=this.getUUID();
            String userUUID=(String) session.getAttribute("id");
//			Date postTime=this.getDate();
            String postTime=this.getStringDate(new Date());
            int postPageviews=0;

            PostDto postDto=new PostDto();
            postDto.setPostPageviews(postPageviews);
            postDto.setPostText(postText);
            postDto.setPostTime(postTime);
            postDto.setPostTitle(postTitle);
            postDto.setPostUUID(postUUID);
            postDto.setUserUUID(userUUID);


            //------------------------------

            String text=this.removeHtmlTag(postText);
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

            String urlPath=request.getContextPath() + "/audio/"+postUUID+".mp3";

            File uploadDir = new File(path);
            if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
                uploadDir.mkdirs();
            }
            path+=postUUID+".mp3";

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
                e.printStackTrace();
            }finally{
                if(is!=null){
                    try {
                        is.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            postDto.setPostAudio(urlPath);
            postService.addPost(postDto);

        }

        this.writeJson(json.toString(), response);
    }

    @Value("${kindeditorImage}")
    private String kindeditorImage;
    @ModelAttribute
    @RequestMapping(value="/kindEditorImgInput")
    public void kindEditorImgInput(HttpServletResponse response, HttpServletRequest request, String dir, String localUrl, MultipartFile imgFile) {
        logger.info("calling PostController [kindEditorImgInput]");
        JSONObject json = new JSONObject();

        boolean strError = true;

        // 文件保存目录路径
        //String savePath = HTML_PATH + "kindeditorImage/";
        String savePath = kindeditorImage;
        // 文件保存目录URL
        String saveUrl = request.getContextPath() + "/kindeditorImage/";

        // 定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        //extMap.put("flash", "swf,flv");
        //extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        //extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
        // 最大文件大小
        long maxSize = 2000000;
        File uploadDir = new File(savePath);
        String dirName = dir;
        if (dirName == null) {
            dirName = "image";
        }
        if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
            uploadDir.mkdirs();
        }

        if (!ServletFileUpload.isMultipartContent(request)) {
            json.put("error", 1);
            json.put("message", "请选择文件。");
        } else if (!uploadDir.canWrite()) {// 检查目录写权限
            json.put("error", 1);
            json.put("message", "上传目录没有写权限。");

        } else if (!extMap.containsKey(dirName)) {
            json.put("error", 1);
            json.put("message", "目录名不正确。");
        } else {

            // 创建文件夹
            savePath += dirName + "/";
            saveUrl += dirName + "/";
            File saveDirFile = new File(savePath);
            if (!saveDirFile.exists()) {
                saveDirFile.mkdirs();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            savePath += ymd + "/";
            saveUrl += ymd + "/";
            File dirFile = new File(savePath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            if (imgFile != null && !imgFile.toString().equals("")) {
                long fileSize = imgFile.getSize();
                if (fileSize > maxSize) {
                    json.put("error", 1);
                    json.put("message", "上传文件大小超过限制。");
                } else {
                    //检查扩展名
                    String fileExt = localUrl.substring(localUrl.lastIndexOf(".") + 1).toLowerCase();
                    if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
                        json.put("error", 1);
                        json.put("message", "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
                    } else {
                        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                        String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;

                        File uploadedFile = new File(savePath, newFileName);
                        //获取文件输出流
                        FileOutputStream fos = null;
                        //获取内存中当前文件输入流
                        InputStream in = null;
                        byte[] buffer = new byte[1024];
                        try {
                            //获取文件输出流
                            fos = new FileOutputStream(uploadedFile);
                            //获取内存中当前文件输入流
//				              in = new FileInputStream(imgFile);
                            in = imgFile.getInputStream();
                            int num = 0;
                            while ((num = in.read(buffer)) > 0) {
                                fos.write(buffer, 0, num);
                            }
                        } catch (Exception e) {
                            strError = false;
                            json.put("error", 1);
                            json.put("message", "上传文件失败。");
                        } finally {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (strError) {
                            json.put("error", 0);
                            json.put("url", saveUrl + newFileName);
                        }
                    }
                }
            } else {
                strError = false;
                json.put("error", 1);
                json.put("message", "上传文件的文件不存在。");
            }
        }
        this.writeJson(json.toString(), response);
    }

}
