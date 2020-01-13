package com.chinasofti.postbar.pbregistermapper.controller;

import com.chinasofti.postbar.pbregistermapper.dto.RegisterDto;
import com.chinasofti.postbar.pbregistermapper.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RegisterService registerService;

    @PostMapping("/insertRegister")
    public void insertRegister(@RequestBody RegisterDto registerDto) {
        logger.info("PbRegisterMapper [insertRegister] was called");
        registerService.insertRegister(registerDto);
    }

    @GetMapping("/selectRegister")
    public RegisterDto selectRegister(@RequestParam("userUUID") String userUUID) {
        logger.info("PbRegisterMapper [selectRegister] was called");
        return registerService.selectRegister(userUUID);
    }

    @GetMapping("/selectRegisterAndUserName")
    public RegisterDto selectRegisterAndUserName(@RequestParam("userUUID") String userUUID) {
        logger.info("PbRegisterMapper [selectRegisterAndUserName] was called");
        return registerService.selectRegisterAndUserName(userUUID);
    }

    @PutMapping("/upDateRegisterByRegUUID")
    public void upDateRegisterByRegUUID(@RequestBody RegisterDto registerDto) {
        logger.info("PbRegisterMapper [upDateRegisterByRegUUID] was called");
        registerService.upDateRegisterByRegUUID(registerDto);
    }

    @GetMapping("/selectRegPhotoByUserUUID")
    public String selectRegPhotoByUserUUID(@RequestParam("userUUID") String userUUID) {
        logger.info("PbRegisterMapper [selectRegPhotoByUserUUID] was called");
        return registerService.selectRegPhotoByUserUUID(userUUID);
    }

    @PutMapping("/upDateRegPhotoByRegUUID")
    public void upDateRegPhotoByRegUUID(@RequestBody RegisterDto registerDto) {
        logger.info("PbRegisterMapper [upDateRegPhotoByRegUUID] was called");
        registerService.upDateRegPhotoByRegUUID(registerDto);
    }

    @GetMapping("/selectRegList")
    public List<RegisterDto> selectRegList(@RequestParam("userName") String userName, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("userUUID") String userUUID) {
        logger.info("PbRegisterMapper [selectRegList] was called");
        return registerService.selectRegList(userName, pageNo, pageSize, userUUID);
    }

    @DeleteMapping("/deleteRegByUserUUID")
    public void deleteRegByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbRegisterMapper [deleteRegByUserUUID] was called");
        registerService.deleteRegByUserUUID(userUUID);
    }

    @PutMapping("/updateRegByUserUUID")
    public void updateRegByUserUUID(@RequestBody RegisterDto registerDto) {
        logger.info("PbRegisterMapper [updateRegByUserUUID] was called");
        registerService.updateRegByUserUUID(registerDto);
    }

}
