package com.chinasofti.postbar.post.mapper.fallback;

import com.chinasofti.postbar.post.dto.AppDto;
import com.chinasofti.postbar.post.mapper.PbAppMapper;

public class PbAppMapperFallback implements PbAppMapper {
    @Override
    public AppDto selectApp() {
        return null;
    }
}
