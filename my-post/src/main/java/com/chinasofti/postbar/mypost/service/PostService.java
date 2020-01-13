package com.chinasofti.postbar.mypost.service;

import com.chinasofti.postbar.mypost.dto.*;
import com.chinasofti.postbar.mypost.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PbPostMapper pbPostMapper;
//    @Autowired
//    private PbPostPraiseMapper pbPostPraiseMapper;
//    @Autowired
//    private PbCommentMapper pbCommentMapper;
//    @Autowired
//    private PbAudioMapper pbAudioMapper;
//    @Autowired
//    private PbCommentPraiseMapper pbCommentPraiseMapper;
//    @Autowired
//    private PbAppMapper pbAppMapper;

    public int getPostAllNum(String postTitle,String userUUID) {
        return pbPostMapper.selectPostAllNum(postTitle,userUUID);
    }

    public List<PostDto> selectPostList(String postTitle, Integer pageNo, Integer pageSize, String userUUID) {
        return pbPostMapper.selectPostList(postTitle, pageNo, pageSize,userUUID);
    }

}
