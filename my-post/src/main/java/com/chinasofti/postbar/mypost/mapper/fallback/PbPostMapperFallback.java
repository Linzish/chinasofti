package com.chinasofti.postbar.mypost.mapper.fallback;

import com.chinasofti.postbar.mypost.dto.PostDto;
import com.chinasofti.postbar.mypost.mapper.PbPostMapper;

import java.util.List;

public class PbPostMapperFallback implements PbPostMapper {

    @Override
    public void insertPost(PostDto postDto) {

    }

    @Override
    public int selectPostAllNum(String postTitle, String userUUID) {
        return 0;
    }

    @Override
    public List<PostDto> selectPostList(String postTitle, Integer pageNo, Integer pageSize, String userUUID) {
        return null;
    }

    @Override
    public void deletePost(String[] postUUID) {

    }
}
