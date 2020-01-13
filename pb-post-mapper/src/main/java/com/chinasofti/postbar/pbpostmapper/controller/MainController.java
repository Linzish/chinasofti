package com.chinasofti.postbar.pbpostmapper.controller;

import com.chinasofti.postbar.pbpostmapper.dto.PostDto;
import com.chinasofti.postbar.pbpostmapper.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private PostService postService;

    @PostMapping("/insertPost")
    public void insertPost(@RequestBody PostDto postDto) {
        logger.info("PbPostMapper [insertPost] was called");
        postService.insertPost(postDto);
    }

    @GetMapping("/selectPostAllNum")
    public int selectPostAllNum(@RequestParam("postTitle") String postTitle, @RequestParam(value = "userUUID", required = false) String userUUID) {
        logger.info("PbPostMapper [selectPostAllNum] was called");
        return postService.selectPostAllNum(postTitle, userUUID);
    }

    @GetMapping("/selectPostList")
    public List<PostDto> selectPostList(@RequestParam("postTitle") String postTitle, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "userUUID",required = false) String userUUID) {
        logger.info("PbPostMapper [selectPostList] was called");
        return postService.selectPostList(postTitle, pageNo, pageSize, userUUID);
    }

    @DeleteMapping("/deletePost")
    public void deletePost(@RequestParam("postUUID") String[] postUUID) {
        logger.info("PbPostMapper [deletePost] was called");
        postService.deletePost(postUUID);
    }

    @DeleteMapping("/deletePostByUserUUID")
    public void deletePostByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbPostMapper [deletePostByUserUUID] was called");
        postService.deletePostByUserUUID(userUUID);
    }

    @GetMapping("/selectPostByPostUUID")
    public PostDto selectPostByPostUUID(@RequestParam("postUUID") String postUUID) {
        logger.info("PbPostMapper [selectPostByPostUUID] was called");
        return postService.selectPostByPostUUID(postUUID);
    }

    @PutMapping("/updatePostPageviews")
    public void updatePostPageviews(@RequestParam("postUUID") String postUUID, @RequestParam("postPageviews") int postPageviews) {
        logger.info("PbPostMapper [updatePostPageviews] was called");
        postService.updatePostPageviews(postUUID, postPageviews);
    }

}
