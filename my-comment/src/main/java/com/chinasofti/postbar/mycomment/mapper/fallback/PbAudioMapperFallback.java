package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.AudioDto;
import com.chinasofti.postbar.mycomment.mapper.PbAudioMapper;

public class PbAudioMapperFallback implements PbAudioMapper {
    @Override
    public AudioDto selectAudioByUserUUID(String userUUID) {
        return null;
    }
}
