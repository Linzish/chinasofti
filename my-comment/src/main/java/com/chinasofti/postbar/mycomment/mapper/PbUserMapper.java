package com.chinasofti.postbar.mycomment.mapper;

import com.chinasofti.postbar.mycomment.dto.UserDto;
import com.chinasofti.postbar.mycomment.mapper.fallback.PbUserMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbUserMapper", fallback = PbUserMapperFallback.class)
public interface PbUserMapper {

    @GetMapping("/selectUserByUserUUID")
    UserDto selectUserByUserUUID(@RequestParam("userUUID") String userUUID);

}
