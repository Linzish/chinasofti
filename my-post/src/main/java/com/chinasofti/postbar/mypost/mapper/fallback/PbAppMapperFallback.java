package com.chinasofti.postbar.mypost.mapper.fallback;

import com.chinasofti.postbar.mypost.dto.AppDto;
import com.chinasofti.postbar.mypost.mapper.PbAppMapper;

public class PbAppMapperFallback implements PbAppMapper {
    @Override
    public AppDto selectApp() {
        return null;
    }
}
