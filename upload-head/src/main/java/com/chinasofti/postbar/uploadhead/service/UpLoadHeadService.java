package com.chinasofti.postbar.uploadhead.service;

import com.chinasofti.postbar.uploadhead.dto.RegisterDto;
import com.chinasofti.postbar.uploadhead.mapper.PbRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpLoadHeadService {

    @Autowired
    private PbRegisterMapper pbRegisterMapper;

    public String selectRegPhotoByUserUUID(String userUUID) {
        return pbRegisterMapper.selectRegPhotoByUserUUID(userUUID);
    }

    public void upDateRegPhotoByRegUUID(RegisterDto registerDto) {
        pbRegisterMapper.upDateRegPhotoByRegUUID(registerDto);
    }

}
