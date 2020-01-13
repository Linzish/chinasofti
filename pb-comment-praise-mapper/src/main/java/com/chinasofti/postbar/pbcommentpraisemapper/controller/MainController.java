package com.chinasofti.postbar.pbcommentpraisemapper.controller;

import com.chinasofti.postbar.pbcommentpraisemapper.dto.CommentPraiseDto;
import com.chinasofti.postbar.pbcommentpraisemapper.service.CommentPraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CommentPraiseService commentPraiseService;

    @DeleteMapping("/deleteCommentPraiseByPostUUID")
    public void deleteCommentPraiseByPostUUID(@RequestParam("postUUID") String[] postUUID) {
        logger.info("PbCommentPraiseMapper [deleteCommentPraiseByPostUUID] was called");
        commentPraiseService.deleteCommentPraiseByPostUUID(postUUID);
    }

    @DeleteMapping("/deleteCommentPraiseByUserUUID")
    public void deleteCommentPraiseByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbCommentPraiseMapper [deleteCommentPraiseByUserUUID] was called");
        commentPraiseService.deleteCommentPraiseByUserUUID(userUUID);
    }

    @DeleteMapping("/deleteCommentPraiseByCmUUID")
    public void deleteCommentPraiseByCmUUID(@RequestParam("cmUUID") String[] cmUUID) {
        logger.info("PbCommentPraiseMapper [deleteCommentPraiseByCmUUID] was called");
        commentPraiseService.deleteCommentPraiseByCmUUID(cmUUID);
    }

    @GetMapping("/selectCommentNumByParameter")
    public int selectCommentNumByParameter(@RequestParam("postUUID") String postUUID, @RequestParam("cmUUID") String cmUUID, @RequestParam("userUUID") String userUUID) {
        logger.info("PbCommentPraiseMapper [selectCommentNumByParameter] was called");
        return commentPraiseService.selectCommentNumByParameter(postUUID, cmUUID, userUUID);
    }

    @PostMapping("/insertPraise")
    public void insertPraise(@RequestBody CommentPraiseDto commentPraiseDto) {
        logger.info("PbCommentPraiseMapper [insertPraise] was called");
        commentPraiseService.insertPraise(commentPraiseDto);
    }

}
