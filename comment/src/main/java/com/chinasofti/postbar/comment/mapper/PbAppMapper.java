package com.chinasofti.postbar.comment.mapper;

import com.chinasofti.postbar.comment.dto.AppDto;
import com.chinasofti.postbar.comment.mapper.fallback.PbAppMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PbAppMapper", fallback = PbAppMapperFallback.class)
public interface PbAppMapper {

    @GetMapping("/selectApp")
    AppDto selectApp();

}
