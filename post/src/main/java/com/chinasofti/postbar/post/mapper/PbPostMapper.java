package com.chinasofti.postbar.post.mapper;

import com.chinasofti.postbar.post.dto.PostDto;
import com.chinasofti.postbar.post.mapper.fallback.PbPostMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PbPostMapper", fallback = PbPostMapperFallback.class)
public interface PbPostMapper {

    @PostMapping("/insertPost")
    void insertPost(@RequestBody PostDto postDto);

    @GetMapping("/selectPostAllNum")
    int selectPostAllNum(@RequestParam("postTitle") String postTitle, @RequestParam("userUUID") String userUUID);

    @GetMapping("/selectPostList")
    List<PostDto> selectPostList(@RequestParam("postTitle") String postTitle, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("userUUID") String userUUID);

    @DeleteMapping("/deletePost")
    void deletePost(@RequestParam("postUUID") String[] postUUID);

}
