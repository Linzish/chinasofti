package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.dto.AudioDto;
import com.chinasofti.postbar.usermanage.mapper.fallback.PbAudioMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbAudioMapper", fallback = PbAudioMapperFallback.class)
public interface PbAudioMapper {

    @PostMapping("/insertAudio")
    void insertAudio(@RequestBody AudioDto audioDto);

    @DeleteMapping("/deleteAudioByUserUUID")
    void deleteAudioByUserUUID(@RequestParam("userUUID") String[] userUUID);

}
