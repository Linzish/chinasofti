package com.chinasofti.postbar.uploadhead.mapper.fallback;

import com.chinasofti.postbar.uploadhead.dto.RegisterDto;
import com.chinasofti.postbar.uploadhead.mapper.PbRegisterMapper;

public class PbRegisterMapperFallback implements PbRegisterMapper {
    @Override
    public String selectRegPhotoByUserUUID(String userUUID) {
        return null;
    }

    @Override
    public void upDateRegPhotoByRegUUID(RegisterDto registerDto) {

    }
}
