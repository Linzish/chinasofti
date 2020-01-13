package com.chinasofti.postbar.mycomment.mapper;

import com.chinasofti.postbar.mycomment.dto.AudioDto;
import com.chinasofti.postbar.mycomment.mapper.fallback.PbAudioMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbAudioMapper", fallback = PbAudioMapperFallback.class)
public interface PbAudioMapper {

    @GetMapping("/selectAudioByUserUUID")
    AudioDto selectAudioByUserUUID(@RequestParam("userUUID") String userUUID);

}
