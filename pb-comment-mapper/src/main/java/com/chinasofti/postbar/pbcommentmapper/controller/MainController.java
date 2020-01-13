package com.chinasofti.postbar.pbcommentmapper.controller;

import com.chinasofti.postbar.pbcommentmapper.dto.CommentDto;
import com.chinasofti.postbar.pbcommentmapper.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CommentService commentService;

    @DeleteMapping("/deleteCommentByPostUUID")
    public void deleteCommentByPostUUID(@RequestParam("postUUID") String[] postUUID) {
        logger.info("PbCommentMapper [deleteCommentByPostUUID] was called");
        commentService.deleteCommentByPostUUID(postUUID);
    }

    @DeleteMapping("/deleteCommentByCmUUID")
    public void deleteCommentByCmUUID(@RequestParam("cmUUID") String[] cmUUID) {
        logger.info("PbCommentMapper [deleteCommentByCmUUID] was called");
        commentService.deleteCommentByCmUUID(cmUUID);
    }

    @DeleteMapping("/deleteCommentByUserUUID")
    public void deleteCommentByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbCommentMapper [deleteCommentByUserUUID] was called");
        commentService.deleteCommentByUserUUID(userUUID);
    }

    @PostMapping("/insertComment")
    public void insertComment(@RequestBody CommentDto commentDto) {
        logger.info("PbCommentMapper [insertComment] was called");
        commentService.insertComment(commentDto);
    }

    @GetMapping("/selectCommentHotsByPostUUID")
    public List<CommentDto> selectCommentHotsByPostUUID(@RequestParam("postUUID") String postUUID) {
        logger.info("PbCommentMapper [selectCommentHotsByPostUUID] was called");
        return commentService.selectCommentHotsByPostUUID(postUUID);
    }

    @GetMapping("/selectAllCommentByPostUUID")
    public List<CommentDto> selectAllCommentByPostUUID(@RequestParam("postUUID") String postUUID) {
        logger.info("PbCommentMapper [selectAllCommentByPostUUID] was called");
        return commentService.selectAllCommentByPostUUID(postUUID);
    }

    @GetMapping("/selectMyCommentByUserUUID")
    public List<CommentDto> selectMyCommentByUserUUID(@RequestParam("userUUID") String userUUID, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        logger.info("PbCommentMapper [selectMyCommentByUserUUID] was called");
        return commentService.selectMyCommentByUserUUID(userUUID, pageNo, pageSize);
    }

    @GetMapping("/selectMyCommentNumByUserUUID")
    public int selectMyCommentNumByUserUUID(@RequestParam("userUUID") String userUUID) {
        logger.info("PbCommentMapper [selectMyCommentNumByUserUUID] was called");
        return commentService.selectMyCommentNumByUserUUID(userUUID);
    }

    @GetMapping("/selectCmTextByCmUUID")
    public String selectCmTextByCmUUID(@RequestParam("cmUUID") String cmUUID) {
        logger.info("PbCommentMapper [selectCmTextByCmUUID] was called");
        return commentService.selectCmTextByCmUUID(cmUUID);
    }

    @PutMapping("/updateCmByCmUUID")
    public void updateCmByCmUUID(@RequestBody CommentDto commentDto) {
        logger.info("PbCommentMapper [updateCmByCmUUID] was called");
        commentService.updateCmByCmUUID(commentDto);
    }

}
