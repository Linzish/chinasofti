package com.chinasofti.postbar.comment.mapper.fallback;

import com.chinasofti.postbar.comment.dto.AppDto;
import com.chinasofti.postbar.comment.mapper.PbAppMapper;

public class PbAppMapperFallback implements PbAppMapper {
    @Override
    public AppDto selectApp() {
        return null;
    }
}
