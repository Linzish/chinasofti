package com.chinasofti.postbar.audiosetup.service;

import com.chinasofti.postbar.audiosetup.dto.AudioDto;
import com.chinasofti.postbar.audiosetup.mapper.PbAudioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioSetUpService {

    @Autowired
	private PbAudioMapper pbAudioMapper;

    public void updateAudioByAuSetUUID(AudioDto audioDto) {
        pbAudioMapper.updateAudioByAuSetUUID(audioDto);
    }

}
