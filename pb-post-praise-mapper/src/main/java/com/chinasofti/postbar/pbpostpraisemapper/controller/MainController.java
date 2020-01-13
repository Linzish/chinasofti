package com.chinasofti.postbar.pbpostpraisemapper.controller;

import com.chinasofti.postbar.pbpostpraisemapper.dto.PostPraiseDto;
import com.chinasofti.postbar.pbpostpraisemapper.service.PostPraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private PostPraiseService postPraiseService;

    @DeleteMapping("/deletePostPraise")
    public void deletePostPraise(@RequestParam("postUUID") String[] postUUID) {
        logger.info("PbPostPraiseMapper [deletePostPraise] was called");
        postPraiseService.deletePostPraise(postUUID);
    }

    @DeleteMapping("/deletePostPraiseByUserUUID")
    public void deletePostPraiseByUserUUID(@RequestParam("userUUID") String[] userUUID) {
        logger.info("PbPostPraiseMapper [deletePostPraiseByUserUUID] was called");
        postPraiseService.deletePostPraiseByUserUUID(userUUID);
    }

    @GetMapping("/selectPraiseByPostUUID")
    public List<PostPraiseDto> selectPraiseByPostUUID(@RequestParam("postUUID") String postUUID) {
        logger.info("PbPostPraiseMapper [selectPraiseByPostUUID] was called");
        return postPraiseService.selectPraiseByPostUUID(postUUID);
    }

    @PostMapping("/insertPraise")
    public void insertPraise(@RequestBody PostPraiseDto pbPostPraiseDto) {
        logger.info("PbPostPraiseMapper [insertPraise] was called");
        postPraiseService.insertPraise(pbPostPraiseDto);
    }

    @GetMapping("/selectPraiseNum")
    public int selectPraiseNum(@RequestParam("postUUID") String postUUID) {
        logger.info("PbPostPraiseMapper [selectPraiseNum] was called");
        return postPraiseService.selectPraiseNum(postUUID);
    }

}
