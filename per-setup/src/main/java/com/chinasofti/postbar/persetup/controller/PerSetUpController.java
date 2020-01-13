package com.chinasofti.postbar.persetup.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.postbar.persetup.basic.BasicController;
import com.chinasofti.postbar.persetup.dto.RegisterDto;
import com.chinasofti.postbar.persetup.service.*;
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
//@RequestMapping(value="/perSetUpController")
//个人设置
public class PerSetUpController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(PerSetUpController.class);

    @Autowired
    private PerSetUpService perSetUpService;
    @Autowired
    private LoginService loginService;

    @ModelAttribute
    @RequestMapping(value="/selectPerSetUp")
    public void selectPerSetUp(HttpServletResponse response, HttpServletRequest request){
        logger.info("calling PerSetUpController [selectPerSetUp]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userUUID=(String)session.getAttribute("id");
            RegisterDto registerDto=perSetUpService.selectRegisterAndUserName(userUUID);

            json.put("registerDto", registerDto);
        }
        this.writeJson(json.toString(), response);
    }

    @ModelAttribute
    @RequestMapping(value="/updatePerSetUp")
    public void updatePerSetUp(HttpServletResponse response,HttpServletRequest request,String regUUID,String userName,String regSex,int regAge,String regEmial,String oldName){
        logger.info("calling PerSetUpController [updatePerSetUp]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        json.put("error", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            if((!oldName.equals(userName)) && loginService.getUserNumByUserName(userName)!=0){
                json.put("error", "用户名已存在");
            }else{
                String userUUID=(String)session.getAttribute("id");
                RegisterDto registerDto=new RegisterDto();
                registerDto.setRegAge(regAge);
                registerDto.setRegEmial(regEmial);
                registerDto.setRegSex(regSex);
                registerDto.setUserName(userName);
                registerDto.setUserUUID(userUUID);
                registerDto.setRegUUID(regUUID);
                perSetUpService.upDateUser(registerDto);
                //audioSetUpService.updateAudioByAuSetUUID(audioDto);
                session.invalidate();
            }
        }
        this.writeJson(json.toString(), response);
    }

}
