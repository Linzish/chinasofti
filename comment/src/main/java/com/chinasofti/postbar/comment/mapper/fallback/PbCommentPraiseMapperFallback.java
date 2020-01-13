package com.chinasofti.postbar.comment.mapper.fallback;

import com.chinasofti.postbar.comment.dto.CommentPraiseDto;
import com.chinasofti.postbar.comment.mapper.PbCommentPraiseMapper;

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
