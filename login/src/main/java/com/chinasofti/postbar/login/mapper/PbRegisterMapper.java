package com.chinasofti.postbar.login.mapper;

import com.chinasofti.postbar.login.dto.RegisterDto;
import com.chinasofti.postbar.login.mapper.fallback.PbRegisterMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PbRegisterMapper", fallback = PbRegisterMapperFallback.class)
public interface PbRegisterMapper {

    @PostMapping("/insertRegister")
    void insertRegister(@RequestBody RegisterDto registerDto);

}
