package com.chinasofti.postbar.pbaudiomapper.service;

import com.chinasofti.postbar.pbaudiomapper.dto.AudioDto;
import com.chinasofti.postbar.pbaudiomapper.mapper.PbAudioMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AudioService {

    @Autowired
    private PbAudioMapper pbAudioMapper;

    @LcnTransaction
    @Transactional
    public void insertAudio(AudioDto audioDto) {
        pbAudioMapper.insertAudio(audioDto);
    }

    public AudioDto selectAudioByUserUUID(String userUUID) {
        return pbAudioMapper.selectAudioByUserUUID(userUUID);
    }

    public void updateAudioByAuSetUUID(AudioDto audioDto) {
        pbAudioMapper.updateAudioByAuSetUUID(audioDto);
    }

    @LcnTransaction
    @Transactional
    public void deleteAudioByUserUUID(String[] userUUID) {
        pbAudioMapper.deleteAudioByUserUUID(userUUID);
    }

}
