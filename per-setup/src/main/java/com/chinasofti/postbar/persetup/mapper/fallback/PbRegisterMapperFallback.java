package com.chinasofti.postbar.persetup.mapper.fallback;

import com.chinasofti.postbar.persetup.dto.RegisterDto;
import com.chinasofti.postbar.persetup.mapper.PbRegisterMapper;

public class PbRegisterMapperFallback implements PbRegisterMapper {
    @Override
    public void insertRegister(RegisterDto registerDto) {

    }

    @Override
    public RegisterDto selectRegisterAndUserName(String userUUID) {
        return null;
    }

    @Override
    public void upDateRegisterByRegUUID(RegisterDto registerDto) {

    }
}
