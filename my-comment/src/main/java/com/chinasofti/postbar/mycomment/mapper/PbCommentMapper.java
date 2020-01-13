package com.chinasofti.postbar.mycomment.mapper;

import com.chinasofti.postbar.mycomment.dto.CommentDto;
import com.chinasofti.postbar.mycomment.mapper.fallback.PbCommentMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PbCommentMapper", fallback = PbCommentMapperFallback.class)
public interface PbCommentMapper {

    @DeleteMapping("/deleteCommentByPostUUID")
    void deleteCommentByPostUUID(@RequestParam("postUUID") String[] postUUID);

    @PostMapping("/insertComment")
    void insertComment(@RequestBody CommentDto commentDto);

    @GetMapping("/selectAllCommentByPostUUID")
    List<CommentDto> selectAllCommentByPostUUID(@RequestParam("postUUID") String postUUID);

    @GetMapping("/selectCommentHotsByPostUUID")
    List<CommentDto> selectCommentHotsByPostUUID(@RequestParam("postUUID") String postUUID);

    @DeleteMapping("/deleteCommentByCmUUID")
    void deleteCommentByCmUUID(@RequestParam("cmUUID") String[] cmUUID);

    @GetMapping("/selectMyCommentByUserUUID")
    List<CommentDto> selectMyCommentByUserUUID(@RequestParam("userUUID") String userUUID, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    @GetMapping("/selectMyCommentNumByUserUUID")
    int selectMyCommentNumByUserUUID(@RequestParam("userUUID") String userUUID);

    @GetMapping("/selectCmTextByCmUUID")
    String selectCmTextByCmUUID(@RequestParam("cmUUID") String cmUUID);

    @PutMapping("/updateCmByCmUUID")
    void updateCmByCmUUID(@RequestBody CommentDto commentDto);

}
