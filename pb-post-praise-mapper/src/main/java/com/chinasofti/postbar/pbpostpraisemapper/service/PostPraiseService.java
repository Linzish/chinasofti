package com.chinasofti.postbar.pbpostpraisemapper.service;

import com.chinasofti.postbar.pbpostpraisemapper.dto.PostPraiseDto;
import com.chinasofti.postbar.pbpostpraisemapper.mapper.PbPostPraiseMapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostPraiseService {

    @Autowired
    private PbPostPraiseMapper pbPostPraiseMapper;

    @LcnTransaction
    @Transactional
    public void deletePostPraise(String[] postUUID) {
        pbPostPraiseMapper.deletePostPraise(postUUID);
    }

    @LcnTransaction
    @Transactional
    public void deletePostPraiseByUserUUID(String[] userUUID) {
        pbPostPraiseMapper.deletePostPraiseByUserUUID(userUUID);
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

}
