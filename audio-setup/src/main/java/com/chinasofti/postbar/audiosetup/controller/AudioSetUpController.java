package com.chinasofti.postbar.audiosetup.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.postbar.audiosetup.basic.BasicController;
import com.chinasofti.postbar.audiosetup.dto.AudioDto;
import com.chinasofti.postbar.audiosetup.service.AudioSetUpService;
import com.chinasofti.postbar.audiosetup.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping(value="/audioSetUpController")
public class AudioSetUpController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(AudioSetUpController.class);

    @Autowired
    private PostService postService;
    @Autowired
    private AudioSetUpService audioSetUpService;

    @ModelAttribute
    @RequestMapping(value="/selectAudioSetUp")
    public void selectAudioSetUp(HttpServletResponse response, HttpServletRequest request){
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userUUID=(String)session.getAttribute("id");
            AudioDto auidoDto=postService.selectAudioByUserUUID(userUUID);
            json.put("auidoDto", auidoDto);
        }
        logger.info("calling AudioSetUpController [selectAudioSetUp]");
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/updateAudioSetUp")
    public void updateAudioSetUp(HttpServletResponse response,HttpServletRequest request,String auSetUUID,int auSetVoiPer,int auSetSpd,int auSetPit,int auSetVol){

        JSONObject json=new JSONObject();
        json.put("message", "");
        if(this.sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            AudioDto audioDto=new AudioDto();
            audioDto.setAuSetPit(auSetPit);
            audioDto.setAuSetSpd(auSetSpd);
            audioDto.setAuSetUUID(auSetUUID);
            audioDto.setAuSetVoiPer(auSetVoiPer);
            audioDto.setAuSetVol(auSetVol);
            audioSetUpService.updateAudioByAuSetUUID(audioDto);
        }
        logger.info("calling AudioSetUpController [updateAudioSetUp]");
        this.writeJson(json.toString(), response);
    }

}
