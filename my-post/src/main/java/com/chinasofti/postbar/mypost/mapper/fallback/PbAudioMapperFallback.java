package com.chinasofti.postbar.mypost.mapper.fallback;

import com.chinasofti.postbar.mypost.dto.AudioDto;
import com.chinasofti.postbar.mypost.mapper.PbAudioMapper;

public class PbAudioMapperFallback implements PbAudioMapper {
    @Override
    public AudioDto selectAudioByUserUUID(String userUUID) {
        return null;
    }
}
