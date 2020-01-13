package com.chinasofti.postbar.comment.mapper.fallback;

import com.chinasofti.postbar.comment.dto.PostPraiseDto;
import com.chinasofti.postbar.comment.mapper.PbPostPraiseMapper;

import java.util.List;

public class PbPostPraiseMapperFallback implements PbPostPraiseMapper {
    @Override
    public void deletePostPraise(String[] postUUID) {

    }

    @Override
    public List<PostPraiseDto> selectPraiseByPostUUID(String postUUID) {
        return null;
    }

    @Override
    public void insertPraise(PostPraiseDto pbPostPraiseDto) {

    }

    @Override
    public int selectPraiseNum(String postUUID) {
        return 0;
    }
}
