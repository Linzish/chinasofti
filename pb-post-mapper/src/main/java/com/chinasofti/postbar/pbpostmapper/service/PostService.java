package com.chinasofti.postbar.pbpostmapper.service;

import com.chinasofti.postbar.pbpostmapper.dto.PostDto;
import com.chinasofti.postbar.pbpostmapper.mapper.PbPostMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PbPostMapper pbPostMapper;

    public void insertPost(PostDto postDto) {
        pbPostMapper.insertPost(postDto);
    }

    public int selectPostAllNum(String postTitle, String userUUID) {
        return pbPostMapper.selectPostAllNum(postTitle, userUUID);
    }

    public List<PostDto> selectPostList(String postTitle, Integer pageNo, Integer pageSize, String userUUID) {
        return pbPostMapper.selectPostList(postTitle, pageNo, pageSize, userUUID);
    }

    @LcnTransaction
    @Transactional
    public void deletePost(String[] postUUID) {
        pbPostMapper.deletePost(postUUID);
    }

    @LcnTransaction
    @Transactional
    public void deletePostByUserUUID(String[] userUUID) {
        pbPostMapper.deletePostByUserUUID(userUUID);
    }

    public PostDto selectPostByPostUUID(String postUUID) {
        return pbPostMapper.selectPostByPostUUID(postUUID);
    }

    public void updatePostPageviews(String postUUID, int postPageviews) {
        pbPostMapper.updatePostPageviews(postUUID, postPageviews);
    }

}
