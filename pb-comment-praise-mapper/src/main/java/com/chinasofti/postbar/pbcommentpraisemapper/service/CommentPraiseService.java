package com.chinasofti.postbar.pbcommentpraisemapper.service;

import com.chinasofti.postbar.pbcommentpraisemapper.dto.CommentPraiseDto;
import com.chinasofti.postbar.pbcommentpraisemapper.mapper.PbCommentPraiseMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentPraiseService {

    @Autowired
    private PbCommentPraiseMapper pbCommentPraiseMapper;

    @LcnTransaction
    @Transactional
    public void deleteCommentPraiseByPostUUID(String[] postUUID) {
        pbCommentPraiseMapper.deleteCommentPraiseByPostUUID(postUUID);
    }

    @LcnTransaction
    @Transactional
    public void deleteCommentPraiseByUserUUID(String[] userUUID) {
        pbCommentPraiseMapper.deleteCommentPraiseByUserUUID(userUUID);
    }

    @LcnTransaction
    @Transactional
    public void deleteCommentPraiseByCmUUID(String[] cmUUID) {
        pbCommentPraiseMapper.deleteCommentPraiseByCmUUID(cmUUID);
    }

    public int selectCommentNumByParameter(String postUUID, String cmUUID, String userUUID) {
        return pbCommentPraiseMapper.selectCommentNumByParameter(postUUID, cmUUID, userUUID);
    }

    public void insertPraise(CommentPraiseDto commentPraiseDto) {
        pbCommentPraiseMapper.insertPraise(commentPraiseDto);
    }

}
