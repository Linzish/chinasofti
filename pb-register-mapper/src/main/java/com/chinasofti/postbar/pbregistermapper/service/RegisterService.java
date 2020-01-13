package com.chinasofti.postbar.pbregistermapper.service;

import com.chinasofti.postbar.pbregistermapper.dto.RegisterDto;
import com.chinasofti.postbar.pbregistermapper.mapper.PbRegisterMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private PbRegisterMapper pbRegisterMapper;

    @LcnTransaction
    @Transactional
    public void insertRegister(RegisterDto registerDto) {
        pbRegisterMapper.insertRegister(registerDto);
    }

    public RegisterDto selectRegister(String userUUID) {
        return pbRegisterMapper.selectRegister(userUUID);
    }

    public RegisterDto selectRegisterAndUserName(String userUUID) {
        return pbRegisterMapper.selectRegisterAndUserName(userUUID);
    }

    @LcnTransaction
    @Transactional
    public void upDateRegisterByRegUUID(RegisterDto registerDto) {
        pbRegisterMapper.upDateRegisterByRegUUID(registerDto);
    }

    public String selectRegPhotoByUserUUID(String userUUID) {
        return pbRegisterMapper.selectRegPhotoByUserUUID(userUUID);
    }

    public void upDateRegPhotoByRegUUID(RegisterDto registerDto) {
        pbRegisterMapper.upDateRegPhotoByRegUUID(registerDto);
    }

    public List<RegisterDto> selectRegList(String userName, Integer pageNo, Integer pageSize, String userUUID) {
        return pbRegisterMapper.selectRegList(userName, pageNo, pageSize, userUUID);
    }

    @LcnTransaction
    @Transactional
    public void deleteRegByUserUUID(String[] userUUID) {
        pbRegisterMapper.deleteRegByUserUUID(userUUID);
    }

    @LcnTransaction
    @Transactional
    public void updateRegByUserUUID(RegisterDto registerDto) {
        pbRegisterMapper.updateRegByUserUUID(registerDto);
    }

}
