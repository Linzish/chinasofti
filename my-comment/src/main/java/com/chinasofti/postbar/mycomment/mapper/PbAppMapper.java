package com.chinasofti.postbar.mycomment.mapper;

import com.chinasofti.postbar.mycomment.dto.AppDto;
import com.chinasofti.postbar.mycomment.mapper.fallback.PbAppMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PbAppMapper", fallback = PbAppMapperFallback.class)
public interface PbAppMapper {

    @GetMapping("/selectApp")
    AppDto selectApp();

}
