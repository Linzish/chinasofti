package com.chinasofti.postbar.login.mapper.fallback;

import com.chinasofti.postbar.login.dto.UserDto;
import com.chinasofti.postbar.login.mapper.PbUserMapper;

import java.util.Date;

public class PbUserMapperFallback implements PbUserMapper {
    @Override
    public void insertUser(UserDto userDto) {

    }

    @Override
    public int selectUserNumByUserName(String userName) {
        return 0;
    }

    @Override
    public void updateLoginTimeByUserName(String userName, Date loginTime) {

    }

    @Override
    public UserDto selectUserByUserNameAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public void updatePasswordByUserName(String userName, String password) {

    }
}
