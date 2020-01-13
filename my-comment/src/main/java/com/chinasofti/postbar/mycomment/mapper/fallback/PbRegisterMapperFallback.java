package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.RegisterDto;
import com.chinasofti.postbar.mycomment.mapper.PbRegisterMapper;

public class PbRegisterMapperFallback implements PbRegisterMapper {
    @Override
    public RegisterDto selectRegister(String userUUID) {
        return null;
    }
}
