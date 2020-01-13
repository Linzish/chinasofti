package com.chinasofti.postbar.usermanage.service;

import com.chinasofti.postbar.usermanage.dto.*;
import com.chinasofti.postbar.usermanage.mapper.PbAudioMapper;
import com.chinasofti.postbar.usermanage.mapper.PbRegisterMapper;
import com.chinasofti.postbar.usermanage.mapper.PbUserMapper;
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
