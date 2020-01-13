package com.chinasofti.postbar.pbaudiomapper.controller;

import com.chinasofti.postbar.pbaudiomapper.dto.AudioDto;
import com.chinasofti.postbar.pbaudiomapper.service.AudioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private AudioService audioService;

    @PostMapping("/insertAudio")
    public void insertAudio(@RequestBody AudioDto audioDto) {
        logger.info("PbAudioMapper [insertAudio] was called");
        audioService.insertAudio(audioDto);
    }

    @GetMapping("/selectAudioByUserUUID")
    public AudioDto selectAudioByUserUUID(@RequestParam("userUUID") String userUUID) {
        logger.info("PbAudioMapper [selectAudioByUserUUID] was called");
        return audioService.selectAudioByUserUUID(userUUID);
    }

    @PutMapping("/updateAudioByAuSetUUID")
    public void updateAudioByAuSetUUID(@RequestBody AudioDto audioDto) {
        logger.info("PbAudioMapper [updateAudioByAuSetUUID] was called");
        audioService.updateAudioByAuSetUUID(audioDto);
    }

    @DeleteMapping("/deleteAudioByUserUUID")
    public void deleteAudioByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbAudioMapper [deleteAudioByUserUUID] was called");
        audioService.deleteAudioByUserUUID(userUUID);
    }

}
