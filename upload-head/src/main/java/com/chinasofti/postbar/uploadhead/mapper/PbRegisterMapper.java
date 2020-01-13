package com.chinasofti.postbar.uploadhead.mapper;

import com.chinasofti.postbar.uploadhead.dto.RegisterDto;
import com.chinasofti.postbar.uploadhead.mapper.fallback.PbRegisterMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbRegisterMapper", fallback = PbRegisterMapperFallback.class)
public interface PbRegisterMapper {

    @GetMapping("/selectRegPhotoByUserUUID")
    String selectRegPhotoByUserUUID(@RequestParam("userUUID") String userUUID);

    @PutMapping("/upDateRegPhotoByRegUUID")
    void upDateRegPhotoByRegUUID(@RequestBody RegisterDto registerDto);

}
