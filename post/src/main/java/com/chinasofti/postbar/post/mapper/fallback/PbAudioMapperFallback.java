package com.chinasofti.postbar.post.mapper.fallback;

import com.chinasofti.postbar.post.dto.AudioDto;
import com.chinasofti.postbar.post.mapper.PbAudioMapper;

public class PbAudioMapperFallback implements PbAudioMapper {
    @Override
    public AudioDto selectAudioByUserUUID(String userUUID) {
        return null;
    }
}
