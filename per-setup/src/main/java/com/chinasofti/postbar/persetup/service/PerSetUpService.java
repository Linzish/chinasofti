package com.chinasofti.postbar.persetup.service;

import com.chinasofti.postbar.persetup.dto.RegisterDto;
import com.chinasofti.postbar.persetup.mapper.PbRegisterMapper;
import com.chinasofti.postbar.persetup.mapper.PbUserMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerSetUpService {

    @Autowired
    private PbRegisterMapper pbRegisterMapper;
    @Autowired
    private PbUserMapper pbUserMapper;

    public RegisterDto selectRegisterAndUserName(String userUUID) {
        return pbRegisterMapper.selectRegisterAndUserName(userUUID);
    }

    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor={RuntimeException.class, Exception.class})
    public void upDateUser(RegisterDto registerDto) {
        pbRegisterMapper.upDateRegisterByRegUUID(registerDto);
        pbUserMapper.updateUserNameByUserUUID(registerDto.getUserName(),registerDto.getUserUUID());
    }

}
