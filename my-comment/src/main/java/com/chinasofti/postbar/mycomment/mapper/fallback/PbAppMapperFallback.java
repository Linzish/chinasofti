package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.AppDto;
import com.chinasofti.postbar.mycomment.mapper.PbAppMapper;

public class PbAppMapperFallback implements PbAppMapper {
    @Override
    public AppDto selectApp() {
        return null;
    }
}
