package com.chinasofti.postbar.comment.mapper.fallback;

import com.chinasofti.postbar.comment.dto.RegisterDto;
import com.chinasofti.postbar.comment.mapper.PbRegisterMapper;

public class PbRegisterMapperFallback implements PbRegisterMapper {
    @Override
    public RegisterDto selectRegister(String userUUID) {
        return null;
    }
}
