package com.chinasofti.postbar.usermanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.postbar.usermanage.basic.BasicController;
import com.chinasofti.postbar.usermanage.dto.RegisterDto;
import com.chinasofti.postbar.usermanage.dto.UserDto;
import com.chinasofti.postbar.usermanage.service.LoginService;
import com.chinasofti.postbar.usermanage.service.UserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping(value="/userManageController")
//用户管理
public class UserManageController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(UserManageController.class);

    @Autowired
    private UserManageService userManageService;
    @Autowired
    private LoginService loginService;

    @ModelAttribute
    @RequestMapping(value="/editUser")
    public void editUser(HttpServletResponse response, HttpServletRequest request, String userUUID, String userName, String regsex, int regAge, String regEmial, String admin, String password, String oldName){
        logger.info("calling UserManageController [editUser]");
        JSONObject json=new JSONObject();
        json.put("message", "");
        json.put("error", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{

            if((!oldName.equals(userName)) &&loginService.getUserNumByUserName(userName)!=0){
                json.put("error", "用户名已存在");
            }else{
                UserDto userDto=new UserDto();
                if(!password.trim().equals("")){
                    userDto.setPassword(this.md5(password));
                }
                userDto.setUserName(userName);
                userDto.setAdmin(admin);
                userDto.setUserUUID(userUUID);

                RegisterDto registerDto=new RegisterDto();
                registerDto.setUserUUID(userUUID);
                registerDto.setRegAge(regAge);
                registerDto.setRegEmial(regEmial);
                registerDto.setRegSex(regsex);
                userManageService.updateUser(userDto, registerDto);
            }


        }
        this.writeJson(json.toString(), response);
    }


    @ModelAttribute
    @RequestMapping(value="/deleteUser")
    public void deleteUser(HttpServletResponse response,HttpServletRequest request,@RequestParam(value = "userUUID[]") String[] userUUID){
        logger.info("calling UserManageController [deleteUser]");
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            userManageService.deleteUser(userUUID);
        }
        this.writeJson(json.toString(), response);
    }

    @ModelAttribute
    @RequestMapping(value="/getUserList")
    public void getUserList(HttpServletResponse response,HttpServletRequest request,String userName,int pageIndex,int everyPageDataCount){
        logger.info("calling UserManageController [getUserList]");
        HttpSession session=request.getSession();
        JSONObject json=new JSONObject();
        json.put("message", "");
        if(sessionTimeout(request)){
            json.put("message", "页面过期，请重新登录");
        }else{
            String userUUID =(String)session.getAttribute("id");
            json.put("userAllNum", 0);
            json.put("allPage", 0);
            json.put("pageIndex", 0);
            json.put("registerList", "");


            int userAllNum=userManageService.getUserAllNum(userName,userUUID);
            json.put("userAllNum", userAllNum);

            if (userAllNum > 0) {
//				// 总页数变量
                int allPage = 1;
                // 计算总页数
                if ((userAllNum % everyPageDataCount) == 0) {
                    allPage = userAllNum / everyPageDataCount;
                } else {
                    allPage = userAllNum / everyPageDataCount + 1;
                }
                // 防止页码越界
                if (pageIndex < 0) {
                    pageIndex = 0;
                } else if (pageIndex >= allPage) {
                    pageIndex = allPage - 1;
                }


                json.put("allPage", allPage);
                json.put("pageIndex", pageIndex);


                List<RegisterDto> list=userManageService.selectRegList(userName, pageIndex*everyPageDataCount, everyPageDataCount, userUUID);



                json.put("registerList", list);
            }

        }

        this.writeJson(json.toString(), response);
    }

}
