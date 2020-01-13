package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.CommentPraiseDto;
import com.chinasofti.postbar.mycomment.mapper.PbCommentPraiseMapper;

public class PbCommentPraiseMapperFallback implements PbCommentPraiseMapper {
    @Override
    public void deleteCommentPraiseByPostUUID(String[] postUUID) {

    }

    @Override
    public int selectCommentNumByParameter(String postUUID, String cmUUID, String userUUID) {
        return 0;
    }

    @Override
    public void insertPraise(CommentPraiseDto commentPraiseDto) {

    }

    @Override
    public void deleteCommentPraiseByCmUUID(String[] cmUUID) {

    }
}
