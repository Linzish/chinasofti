package com.chinasofti.postbar.pbappmapper.controller;

import com.chinasofti.postbar.pbappmapper.dto.AppDto;
import com.chinasofti.postbar.pbappmapper.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private AppService appService;

    @GetMapping("/selectApp")
    public AppDto selectApp() {
        logger.info("PbAppMapper [selectApp] was called");
        return appService.selectApp();
    }

}
