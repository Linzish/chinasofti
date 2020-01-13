package com.chinasofti.postbar.comment.mapper.fallback;

import com.chinasofti.postbar.comment.dto.AudioDto;
import com.chinasofti.postbar.comment.mapper.PbAudioMapper;

public class PbAudioMapperFallback implements PbAudioMapper {
    @Override
    public AudioDto selectAudioByUserUUID(String userUUID) {
        return null;
    }
}
