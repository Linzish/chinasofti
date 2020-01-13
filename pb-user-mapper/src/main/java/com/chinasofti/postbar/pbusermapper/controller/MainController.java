package com.chinasofti.postbar.pbusermapper.controller;

import com.chinasofti.postbar.pbusermapper.dto.UserDto;
import com.chinasofti.postbar.pbusermapper.mapper.PbUserMapper;
import com.chinasofti.postbar.pbusermapper.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody UserDto userDto) {
        logger.info("PbUserMapper [insertUser] was called");
        userService.insertUser(userDto);
    }

    @GetMapping("/selectUserNumByUserName")
    public int selectUserNumByUserName(@RequestParam("userName") String userName) {
        logger.info("PbUserMapper [selectUserNumByUserName] was called");
        return userService.selectUserNumByUserName(userName);
    }

    @GetMapping("/selectUserByUserNameAndPassword")
    public UserDto selectUserByUserNameAndPassword(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        logger.info("PbUserMapper [selectUserByUserNameAndPassword] was called");
        return userService.selectUserByUserNameAndPassword(userName, password);
    }

    @PutMapping("/updateLoginTimeByUserName")
    public void updateLoginTimeByUserName(@RequestParam("userName") String userName, @RequestParam("loginTime") Date loginTime) {
        logger.info("PbUserMapper [updateLoginTimeByUserName] was called");
        userService.updateLoginTimeByUserName(userName, loginTime);
    }

    @GetMapping("/selectUserByUserUUID")
    public UserDto selectUserByUserUUID(@RequestParam("userUUID") String userUUID) {
        logger.info("PbUserMapper [selectUserByUserUUID] was called");
        return userService.selectUserByUserUUID(userUUID);
    }

    @PutMapping("/updateUserNameByUserUUID")
    public void updateUserNameByUserUUID(@RequestParam("userName") String userName, @RequestParam("userUUID") String userUUID) {
        logger.info("PbUserMapper [updateUserNameByUserUUID] was called");
        userService.updateUserNameByUserUUID(userName, userUUID);
    }

    @PutMapping("/updatePasswordByUserName")
    public void updatePasswordByUserName(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        logger.info("PbUserMapper [updatePasswordByUserName] was called");
        userService.updatePasswordByUserName(userName, password);
    }

    @GetMapping("/selectUserAllNum")
    public int selectUserAllNum(@RequestParam("userName") String userName, @RequestParam("userUUID") String userUUID) {
        logger.info("PbUserMapper [selectUserAllNum] was called");
        return userService.selectUserAllNum(userName, userUUID);
    }

    @DeleteMapping("/deleteUserByUserUUID")
    public void deleteUserByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbUserMapper [deleteUserByUserUUID] was called");
        userService.deleteUserByUserUUID(userUUID);
    }

    @PutMapping("/updateUserByUserUUID")
    public void updateUserByUserUUID(@RequestBody UserDto userDto) {
        logger.info("PbUserMapper [updateUserByUserUUID] was called");
        userService.updateUserByUserUUID(userDto);
    }

}
