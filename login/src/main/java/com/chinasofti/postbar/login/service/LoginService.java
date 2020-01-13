package com.chinasofti.postbar.login.service;

import com.chinasofti.postbar.login.dto.*;
import com.chinasofti.postbar.login.mapper.*;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class LoginService {

    @Autowired
    private PbRegisterMapper pbRegisterMapper;
    @Autowired
    private PbUserMapper pbUserMapper;
    @Autowired
    private PbAudioMapper pbAudioMapper;

    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor={RuntimeException.class, Exception.class})
    public void addUserRegister(RegisterDto registerDto, UserDto userDto, AudioDto audioDto) {
        pbUserMapper.insertUser(userDto);
        pbRegisterMapper.insertRegister(registerDto);
        pbAudioMapper.insertAudio(audioDto);
    }

    public int getUserNumByUserName(String userName) {
        return pbUserMapper.selectUserNumByUserName(userName);
    }

    public void changeLoginTimeByUserName(String userName, Date loginTime) {
        pbUserMapper.updateLoginTimeByUserName(userName, loginTime);
    }

    public UserDto getUserByUserNameAndPassword(String userName, String password) {
        return pbUserMapper.selectUserByUserNameAndPassword(userName, password);
    }

    public void updatePasswordByUserName(String userName, String password) {
        pbUserMapper.updatePasswordByUserName(userName, password);
    }

}
