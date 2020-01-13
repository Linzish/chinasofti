package com.chinasofti.postbar.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.postbar.login.basic.BasicController;
import com.chinasofti.postbar.login.dto.*;
import com.chinasofti.postbar.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
//@RequestMapping(value="/loginController")
public class LoginController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    private LoginService loginService;

    @ModelAttribute
    @RequestMapping(value="/login")
    public void login(HttpServletResponse response, HttpServletRequest request, String userName, String password){
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        String md5Password=this.md5(password);
        UserDto userDto=loginService.getUserByUserNameAndPassword(userName, md5Password);
        if(userDto==null){
            json.put("message", "用户名或密码错误");
        }else{
            session.setAttribute("username", userDto.getUserName());
            session.setAttribute("admin", userDto.getAdmin());
            session.setAttribute("id", userDto.getUserUUID());
            Date datetime=this.getDate();
            if(userDto.getLoginTime()==null){
                session.setAttribute("dateTiem", datetime);
            }else{
                session.setAttribute("dateTime", userDto.getLoginTime());
            }

            loginService.changeLoginTimeByUserName(userName, datetime);
            json.put("admin", userDto.getAdmin());
        }
        logger.info("LoginController [login] was called");
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/getAdmin")
    public void getAdmin(HttpServletResponse response,HttpServletRequest request){

        HttpSession session=request.getSession();

        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            json.put("admin", (String)session.getAttribute("admin"));
        }
        logger.info("LoginController [getAdmin] was called, JSON=[" + json.toString() + "]");
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/addRegister")
    public void addRegister(HttpServletResponse response,HttpServletRequest request,String userName,String password,String regSex,int regAge,String regEmial){
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(loginService.getUserNumByUserName(userName)!=0){
            json.put("message", "用户名已存在");
        }else{

            String userUUID=this.getUUID();
            String md5Password=this.md5(password);
            String regTime=this.getStringDate(new Date());
            String regUUID=this.getUUID();
            String admin="0";
            String photoAir="/postbar/headPhoto/default/default.jpg";
            String auSetUUID=this.getUUID();
            int auSetPit=5;
            int auSetSpd=5;
            int auSetVol=5;
            int auSetVoiPer=0;
            RegisterDto registerDto=new RegisterDto();
            registerDto.setRegAge(regAge);
            registerDto.setRegEmial(regEmial);
            registerDto.setRegSex(regSex);
            registerDto.setRegTime(regTime);
            registerDto.setRegUUID(regUUID);
            registerDto.setUserUUID(userUUID);
            registerDto.setRegPhoto(photoAir);
            UserDto userDto=new UserDto();
            userDto.setPassword(md5Password);
            userDto.setUserName(userName);
            userDto.setUserUUID(userUUID);
            userDto.setAdmin(admin);

            AudioDto audioDto=new AudioDto();
            audioDto.setAuSetPit(auSetPit);
            audioDto.setAuSetSpd(auSetSpd);
            audioDto.setAuSetUUID(auSetUUID);
            audioDto.setAuSetVoiPer(auSetVoiPer);
            audioDto.setAuSetVol(auSetVol);
            audioDto.setUserUUID(userUUID);
            loginService.addUserRegister(registerDto, userDto,audioDto);
        }
        logger.info("LoginController [addRegister] was called");
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/loginOut")
    public void loginOut(HttpServletResponse response,HttpServletRequest request){
        JSONObject json=new JSONObject();
        HttpSession session=request.getSession();
        session.invalidate();
        logger.info("LoginController [loginOut] was called");
        this.writeJson(json.toString(), response);
    }
    @ModelAttribute
    @RequestMapping(value="/editPassword")
    public void editPassword(HttpServletResponse response,HttpServletRequest request,String oldPassword,String newPassword){
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        json.put("error", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userName=(String)session.getAttribute("username");
            oldPassword=this.md5(oldPassword);
            newPassword=this.md5(newPassword);
            UserDto userDto=loginService.getUserByUserNameAndPassword(userName, oldPassword);
            if(userDto==null){
                json.put("error", "当前密码输入错误");
            }else{
                loginService.updatePasswordByUserName(userName, newPassword);
            }
        }
        logger.info("LoginController [editPassword] was called");
        this.writeJson(json.toString(), response);
    }

}
