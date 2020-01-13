package com.chinasofti.postbar.usermanage.mapper.fallback;

import com.chinasofti.postbar.usermanage.dto.UserDto;
import com.chinasofti.postbar.usermanage.mapper.PbUserMapper;

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

    @Override
    public void updateUserNameByUserUUID(String userName, String userUUID) {

    }

    @Override
    public int selectUserAllNum(String userName, String userUUID) {
        return 0;
    }

    @Override
    public void deleteUserByUserUUID(String[] userUUID) {

    }

    @Override
    public void updateUserByUserUUID(UserDto userDto) {

    }
}
