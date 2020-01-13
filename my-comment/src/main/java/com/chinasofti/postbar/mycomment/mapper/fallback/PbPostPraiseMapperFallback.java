package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.PostPraiseDto;
import com.chinasofti.postbar.mycomment.mapper.PbPostPraiseMapper;

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
