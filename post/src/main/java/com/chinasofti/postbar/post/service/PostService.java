package com.chinasofti.postbar.post.service;

import com.chinasofti.postbar.post.dto.AppDto;
import com.chinasofti.postbar.post.dto.AudioDto;
import com.chinasofti.postbar.post.dto.PostDto;
import com.chinasofti.postbar.post.mapper.*;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PbPostMapper pbPostMapper;
    @Autowired
    private PbPostPraiseMapper pbPostPraiseMapper;
    @Autowired
    private PbCommentMapper pbCommentMapper;
    @Autowired
    private PbAudioMapper pbAudioMapper;
    @Autowired
    private PbCommentPraiseMapper pbCommentPraiseMapper;
    @Autowired
    private PbAppMapper pbAppMapper;

    public void addPost(PostDto postDto) {
        pbPostMapper.insertPost(postDto);
    }

    public int getPostAllNum(String postTitle,String userUUID) {
        return pbPostMapper.selectPostAllNum(postTitle,userUUID);
    }

    public List<PostDto> selectPostList(String postTitle, Integer pageNo, Integer pageSize, String userUUID) {
        return pbPostMapper.selectPostList(postTitle, pageNo, pageSize,userUUID);
    }

    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor={RuntimeException.class, Exception.class})
    public void deletePost(String[] postUUID) {
        pbCommentPraiseMapper.deleteCommentPraiseByPostUUID(postUUID);
        pbPostPraiseMapper.deletePostPraise(postUUID);
        pbCommentMapper.deleteCommentByPostUUID(postUUID);
        pbPostMapper.deletePost(postUUID);
    }

    public AudioDto selectAudioByUserUUID(String userUUID) {
        return pbAudioMapper.selectAudioByUserUUID(userUUID);
    }

    public AppDto selectApp() {
        return pbAppMapper.selectApp();
    }


}
