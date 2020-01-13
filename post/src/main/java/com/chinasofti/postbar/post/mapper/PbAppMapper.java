package com.chinasofti.postbar.post.mapper;

import com.chinasofti.postbar.post.dto.AppDto;
import com.chinasofti.postbar.post.mapper.fallback.PbAppMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PbAppMapper", fallback = PbAppMapperFallback.class)
public interface PbAppMapper {

    @GetMapping("/selectApp")
    AppDto selectApp();

}
