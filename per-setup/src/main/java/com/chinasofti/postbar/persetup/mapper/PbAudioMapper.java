package com.chinasofti.postbar.persetup.mapper;

import com.chinasofti.postbar.persetup.dto.AudioDto;
import com.chinasofti.postbar.persetup.mapper.fallback.PbAudioMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PbAudioMapper", fallback = PbAudioMapperFallback.class)
public interface PbAudioMapper {

    @PostMapping("/insertAudio")
    void insertAudio(@RequestBody AudioDto audioDto);

}
