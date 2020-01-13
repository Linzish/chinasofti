package com.chinasofti.postbar.pbappmapper.service;

import com.chinasofti.postbar.pbappmapper.dto.AppDto;
import com.chinasofti.postbar.pbappmapper.mapper.PbAppMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    //private static Logger logger = LoggerFactory.getLogger(AppService.class);

    @Autowired
    private PbAppMapper pbAppMapper;

    public AppDto selectApp() {
        return pbAppMapper.selectApp();
    }

}
