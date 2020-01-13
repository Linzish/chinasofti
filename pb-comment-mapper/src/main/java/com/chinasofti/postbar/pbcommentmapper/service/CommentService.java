package com.chinasofti.postbar.pbcommentmapper.service;

import com.chinasofti.postbar.pbcommentmapper.dto.CommentDto;
import com.chinasofti.postbar.pbcommentmapper.mapper.PbCommentMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private PbCommentMapper pbCommentMapper;

    @LcnTransaction
    @Transactional
    public void deleteCommentByPostUUID(String[] postUUID) {
        pbCommentMapper.deleteCommentByPostUUID(postUUID);
    }

    @LcnTransaction
    @Transactional
    public void deleteCommentByCmUUID(String[] cmUUID) {
        pbCommentMapper.deleteCommentByCmUUID(cmUUID);
    }

    @LcnTransaction
    @Transactional
    public void deleteCommentByUserUUID(String[] userUUID) {
        pbCommentMapper.deleteCommentByUserUUID(userUUID);
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

    public List<CommentDto> selectMyCommentByUserUUID(String userUUID, Integer pageNo, Integer pageSize) {
        return pbCommentMapper.selectMyCommentByUserUUID(userUUID, pageNo, pageSize);
    }

    public int selectMyCommentNumByUserUUID(String userUUID) {
        return pbCommentMapper.selectMyCommentNumByUserUUID(userUUID);
    }

    public String selectCmTextByCmUUID(String cmUUID) {
        return pbCommentMapper.selectCmTextByCmUUID(cmUUID);
    }

    public void updateCmByCmUUID(CommentDto commentDto) {
        pbCommentMapper.updateCmByCmUUID(commentDto);
    }

}
