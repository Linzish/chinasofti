package com.chinasofti.postbar.mycomment.mapper;

import com.chinasofti.postbar.mycomment.dto.CommentPraiseDto;
import com.chinasofti.postbar.mycomment.mapper.fallback.PbCommentPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PbCommentPraiseMapper", fallback = PbCommentPraiseMapperFallback.class)
public interface PbCommentPraiseMapper {

    @DeleteMapping("/deleteCommentPraiseByPostUUID")
    void deleteCommentPraiseByPostUUID(@RequestParam("postUUID") String[] postUUID);

    @GetMapping("/selectCommentNumByParameter")
    int selectCommentNumByParameter(@RequestParam("postUUID") String postUUID, @RequestParam("cmUUID") String cmUUID, @RequestParam("userUUID") String userUUID);

    @PostMapping("/insertPraise")
    void insertPraise(@RequestBody CommentPraiseDto commentPraiseDto);

    @DeleteMapping("/deleteCommentPraiseByCmUUID")
    void deleteCommentPraiseByCmUUID(@RequestParam("cmUUID") String[] cmUUID);



}
