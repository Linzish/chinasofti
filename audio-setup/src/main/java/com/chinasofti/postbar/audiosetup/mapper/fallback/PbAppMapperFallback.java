package com.chinasofti.postbar.audiosetup.mapper.fallback;

import com.chinasofti.postbar.audiosetup.dto.AppDto;
import com.chinasofti.postbar.audiosetup.mapper.PbAppMapper;

public class PbAppMapperFallback implements PbAppMapper {
    @Override
    public AppDto selectApp() {
        return null;
    }
}
