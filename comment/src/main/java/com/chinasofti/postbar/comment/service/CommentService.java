package com.chinasofti.postbar.comment.service;

import com.chinasofti.postbar.comment.dto.*;
import com.chinasofti.postbar.comment.mapper.*;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private PbPostMapper pbPostMapper;
    @Autowired
    private PbUserMapper pbUserMapper;
    @Autowired
    private PbRegisterMapper pbRegisterMapper;
    @Autowired
    private PbPostPraiseMapper pbPostPraiseMapper;
    @Autowired
    private PbCommentMapper pbCommentMapper;
    @Autowired
    private PbCommentPraiseMapper pbCommentPraiseMapper;

    public PostDto selectPostByPostUUID(String postUUID) {
        return pbPostMapper.selectPostByPostUUID(postUUID);
    }

    public UserDto selectUserByUserUUID(String userUUID) {
        return pbUserMapper.selectUserByUserUUID(userUUID);
    }

    public void updatePostPageviews(String postUUID, int postPageviews) {
        pbPostMapper.updatePostPageviews(postUUID, postPageviews);
    }

    public RegisterDto selectRegister(String userUUID) {
        return pbRegisterMapper.selectRegister(userUUID);
    }

    public List<PostPraiseDto> selectPraiseByPostUUID(String postUUID) {
        return pbPostPraiseMapper.selectPraiseByPostUUID(postUUID);
    }

    public void insertPraise(PostPraiseDto pbPostPraiseDto) {
        pbPostPraiseMapper.insertPraise(pbPostPraiseDto);
    }

    public int selectPraiseNum(String postUUID) {
        return pbPostPraiseMapper.selectPraiseNum(postUUID);
    }

    public void insertComment(CommentDto commentDto) {
        pbCommentMapper.insertComment(commentDto);
    }

    public List<CommentDto> selectCommentHotsByPostUUID(String postUUID) {
        return pbCommentMapper.selectCommentHotsByPostUUID(postUUID);
    }

    public List<CommentDto> selectAllCommentByPostUUID(String postUUID) {
        return pbCommentMapper.selectAllCommentByPostUUID(postUUID);
    }

    public int selectCommentNumByParameter(String postUUID, String cmUUID, String userUUID) {
        return pbCommentPraiseMapper.selectCommentNumByParameter(postUUID, cmUUID, userUUID);
    }

    public void insertPraise(CommentPraiseDto CommentPraiseDto) {
        pbCommentPraiseMapper.insertPraise(CommentPraiseDto);
    }

    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor={RuntimeException.class, Exception.class})
    public void deleteComment(String[] cmUUID) {
        pbCommentPraiseMapper.deleteCommentPraiseByCmUUID(cmUUID);
        pbCommentMapper.deleteCommentByCmUUID(cmUUID);
    }

}
