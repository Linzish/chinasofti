package com.chinasofti.postbar.audiosetup.mapper;

import com.chinasofti.postbar.audiosetup.dto.AudioDto;
import com.chinasofti.postbar.audiosetup.mapper.fallback.PbAudioMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PbAudioMapper", fallback = PbAudioMapperFallback.class)
public interface PbAudioMapper {

    @GetMapping("/selectAudioByUserUUID")
    AudioDto selectAudioByUserUUID(@RequestParam("userUUID") String userUUID);

    @PutMapping("/updateAudioByAuSetUUID")
    void updateAudioByAuSetUUID(@RequestBody AudioDto audioDto);

}
