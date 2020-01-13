package com.chinasofti.postbar.mypost.mapper;

import com.chinasofti.postbar.mypost.dto.AppDto;
import com.chinasofti.postbar.mypost.mapper.fallback.PbAppMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PbAppMapper", fallback = PbAppMapperFallback.class)
public interface PbAppMapper {

    @GetMapping("/selectApp")
    AppDto selectApp();

}
