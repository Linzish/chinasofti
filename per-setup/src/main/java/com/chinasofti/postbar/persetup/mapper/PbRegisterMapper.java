package com.chinasofti.postbar.persetup.mapper;

import com.chinasofti.postbar.persetup.dto.RegisterDto;
import com.chinasofti.postbar.persetup.mapper.fallback.PbRegisterMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PbRegisterMapper", fallback = PbRegisterMapperFallback.class)
public interface PbRegisterMapper {

    @PostMapping("/insertRegister")
    void insertRegister(@RequestBody RegisterDto registerDto);

    @GetMapping("/selectRegisterAndUserName")
    RegisterDto selectRegisterAndUserName(@RequestParam("userUUID") String userUUID);

    @PutMapping("/upDateRegisterByRegUUID")
    void upDateRegisterByRegUUID(@RequestBody RegisterDto registerDto);

}
