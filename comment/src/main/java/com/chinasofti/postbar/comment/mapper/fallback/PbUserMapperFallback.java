package com.chinasofti.postbar.comment.mapper.fallback;

import com.chinasofti.postbar.comment.dto.UserDto;
import com.chinasofti.postbar.comment.mapper.PbUserMapper;

public class PbUserMapperFallback implements PbUserMapper {
    @Override
    public UserDto selectUserByUserUUID(String userUUID) {
        return null;
    }
}
