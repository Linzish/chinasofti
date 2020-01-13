package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.UserDto;
import com.chinasofti.postbar.mycomment.mapper.PbUserMapper;

public class PbUserMapperFallback implements PbUserMapper {
    @Override
    public UserDto selectUserByUserUUID(String userUUID) {
        return null;
    }
}
