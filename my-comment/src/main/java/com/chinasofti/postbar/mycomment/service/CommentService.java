package com.chinasofti.postbar.mycomment.service;

import com.chinasofti.postbar.mycomment.dto.*;
import com.chinasofti.postbar.mycomment.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

//    @Autowired
//    private PbPostMapper pbPostMapper;
//    @Autowired
//    private PbUserMapper pbUserMapper;
//    @Autowired
//    private PbRegisterMapper pbRegisterMapper;
//    @Autowired
//    private PbPostPraiseMapper pbPostPraiseMapper;
    @Autowired
    private PbCommentMapper pbCommentMapper;
//    @Autowired
//    private PbCommentPraiseMapper pbCommentPraiseMapper;

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
