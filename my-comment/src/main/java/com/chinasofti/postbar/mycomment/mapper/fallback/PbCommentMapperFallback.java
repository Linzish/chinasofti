package com.chinasofti.postbar.mycomment.mapper.fallback;

import com.chinasofti.postbar.mycomment.dto.CommentDto;
import com.chinasofti.postbar.mycomment.mapper.PbCommentMapper;

import java.util.List;

public class PbCommentMapperFallback implements PbCommentMapper {
    @Override
    public void deleteCommentByPostUUID(String[] postUUID) {

    }

    @Override
    public void insertComment(CommentDto commentDto) {

    }

    @Override
    public List<CommentDto> selectAllCommentByPostUUID(String postUUID) {
        return null;
    }

    @Override
    public List<CommentDto> selectCommentHotsByPostUUID(String postUUID) {
        return null;
    }

    @Override
    public void deleteCommentByCmUUID(String[] cmUUID) {

    }

    @Override
    public List<CommentDto> selectMyCommentByUserUUID(String userUUID, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int selectMyCommentNumByUserUUID(String userUUID) {
        return 0;
    }

    @Override
    public String selectCmTextByCmUUID(String cmUUID) {
        return null;
    }

    @Override
    public void updateCmByCmUUID(CommentDto commentDto) {

    }
}
