package com.chinasofti.postbar.uploadhead.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.postbar.uploadhead.basic.BasicController;
import com.chinasofti.postbar.uploadhead.dto.RegisterDto;
import com.chinasofti.postbar.uploadhead.service.UpLoadHeadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
//@RequestMapping(value="/upLoadHeadController")
//上传头像
public class UpLoadHeadController extends BasicController {

    private static Logger log = LoggerFactory.getLogger(UpLoadHeadController.class);

    @Autowired
    private UpLoadHeadService upLoadHeadService;

    @Value("${headphoto}")
    private String HTML_PATH;

    @ModelAttribute
    @RequestMapping(value="/editHead")
    public void editHead(HttpServletResponse response, HttpServletRequest request, @RequestParam("file") String file){
        log.info("calling UpLoadHeadController [editHead]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userUUID=(String)session.getAttribute("id");

//			String path=HTML_PATH+"headPhoto\\" ;
            String path=HTML_PATH;
            String urlPath=request.getContextPath() + "/headPhoto/"+userUUID+".jpg";
            log.info("pic_urlpath:"+urlPath);
            File uploadDir = new File(path);
            if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
                uploadDir.mkdirs();
            }
            path+=userUUID+".jpg";
            OutputStream out = null;
            InputStream is = null;
            System.out.println("aaaaa=="+path);
            try {
                byte[] imgByte  = new BASE64Decoder().decodeBuffer(file);
                for (int i = 0; i < imgByte.length; ++i) {
                    if (imgByte[i] < 0) {// 调整异常数据
                        imgByte[i] += 256;
                    }
                }
                out = new FileOutputStream(path);
                is = new ByteArrayInputStream(imgByte);
                byte[] buff = new byte[1024];
                int len = 0;
                while((len=is.read(buff))!=-1){
                    out.write(buff, 0, len);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
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

            RegisterDto registerDto=new RegisterDto();
            registerDto.setRegPhoto(urlPath);
            registerDto.setUserUUID(userUUID);
            upLoadHeadService.upDateRegPhotoByRegUUID(registerDto);
        }
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/selectHeadURL")
    public void selectHeadURL(HttpServletResponse response,HttpServletRequest request){
        log.info("calling UpLoadHeadController [selectHeadURL]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userUUID=(String)session.getAttribute("id");
            String headURL=upLoadHeadService.selectRegPhotoByUserUUID(userUUID);
            json.put("headURL", headURL);
        }
        this.writeJson(json.toString(), response);
    }

}
