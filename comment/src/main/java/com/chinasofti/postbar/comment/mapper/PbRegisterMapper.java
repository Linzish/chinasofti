package com.chinasofti.postbar.comment.mapper;

import com.chinasofti.postbar.comment.dto.RegisterDto;
import com.chinasofti.postbar.comment.mapper.fallback.PbRegisterMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbRegisterMapper", fallback = PbRegisterMapperFallback.class)
public interface PbRegisterMapper {

    @GetMapping("/selectRegister")
    public RegisterDto selectRegister(@RequestParam("userUUID") String userUUID);

}
