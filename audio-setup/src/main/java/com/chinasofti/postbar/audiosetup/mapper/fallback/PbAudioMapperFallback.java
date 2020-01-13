package com.chinasofti.postbar.audiosetup.mapper.fallback;

import com.chinasofti.postbar.audiosetup.dto.AudioDto;
import com.chinasofti.postbar.audiosetup.mapper.PbAudioMapper;

public class PbAudioMapperFallback implements PbAudioMapper {
    @Override
    public AudioDto selectAudioByUserUUID(String userUUID) {
        return null;
    }

    @Override
    public void updateAudioByAuSetUUID(AudioDto audioDto) {

    }
}
