package com.chinasofti.postbar.persetup.service;

import com.chinasofti.postbar.persetup.dto.*;
import com.chinasofti.postbar.persetup.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class LoginService {

//    @Autowired
//    private PbRegisterMapper pbRegisterMapper;
    @Autowired
    private PbUserMapper pbUserMapper;
//    @Autowired
//    private PbAudioMapper pbAudioMapper;

    public int getUserNumByUserName(String userName) {
        return pbUserMapper.selectUserNumByUserName(userName);
    }

}
