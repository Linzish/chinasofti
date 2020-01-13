package com.chinasofti.postbar.pbusermapper.service;

import com.chinasofti.postbar.pbusermapper.dto.UserDto;
import com.chinasofti.postbar.pbusermapper.mapper.PbUserMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private PbUserMapper pbUserMapper;

    @LcnTransaction
    @Transactional
    public void insertUser(UserDto userDto) {
        pbUserMapper.insertUser(userDto);
    }

    public int selectUserNumByUserName(String userName) {
        return pbUserMapper.selectUserNumByUserName(userName);
    }

    public UserDto selectUserByUserNameAndPassword(String userName, String password) {
        return pbUserMapper.selectUserByUserNameAndPassword(userName, password);
    }

    public void updateLoginTimeByUserName(String userName, Date loginTime) {
        pbUserMapper.updateLoginTimeByUserName(userName, loginTime);
    }

    public UserDto selectUserByUserUUID(String userUUID) {
        return pbUserMapper.selectUserByUserUUID(userUUID);
    }

    @LcnTransaction
    @Transactional
    public void updateUserNameByUserUUID(String userName, String userUUID) {
        pbUserMapper.updateUserNameByUserUUID(userName, userUUID);
    }

    public void updatePasswordByUserName(String userName, String password) {
        pbUserMapper.updatePasswordByUserName(userName, password);
    }

    public int selectUserAllNum(String userName, String userUUID) {
        return pbUserMapper.selectUserAllNum(userName, userUUID);
    }

    @LcnTransaction
    @Transactional
    public void deleteUserByUserUUID(String[] userUUID) {
        pbUserMapper.deleteUserByUserUUID(userUUID);
    }

    @LcnTransaction
    @Transactional
    public void updateUserByUserUUID(UserDto userDto) {
        pbUserMapper.updateUserByUserUUID(userDto);
    }

}
