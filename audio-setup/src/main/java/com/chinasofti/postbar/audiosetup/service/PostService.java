package com.chinasofti.postbar.audiosetup.service;

import com.chinasofti.postbar.audiosetup.dto.AppDto;
import com.chinasofti.postbar.audiosetup.dto.AudioDto;
import com.chinasofti.postbar.audiosetup.dto.PostDto;
import com.chinasofti.postbar.audiosetup.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
//    @Autowired
//	private PbPostMapper pbPostMapper;
//	@Autowired
//	private PbPostPraiseMapper pbPostPraiseMapper;
//	@Autowired
//	private PbCommentMapper pbCommentMapper;
	@Autowired
	private PbAudioMapper pbAudioMapper;

//	@Autowired
//	private PbCommentPraiseMapper pbCommentPraiseMapper;
//	@Autowired
//	private PbAppMapper pbAppMapper;

    public AudioDto selectAudioByUserUUID(String userUUID) {
        return pbAudioMapper.selectAudioByUserUUID(userUUID);
    }


}
