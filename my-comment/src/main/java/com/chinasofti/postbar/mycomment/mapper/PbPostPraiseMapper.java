package com.chinasofti.postbar.mycomment.mapper;

import com.chinasofti.postbar.mycomment.dto.PostPraiseDto;
import com.chinasofti.postbar.mycomment.mapper.fallback.PbPostPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PbPostPraiseMapper", fallback = PbPostPraiseMapperFallback.class)
public interface PbPostPraiseMapper {

    @DeleteMapping("/deletePostPraise")
    void deletePostPraise(@RequestParam("postUUID") String[] postUUID);

    @GetMapping("/selectPraiseByPostUUID")
    List<PostPraiseDto> selectPraiseByPostUUID(@RequestParam("postUUID") String postUUID);

    @PostMapping("/insertPraise")
    void insertPraise(@RequestBody PostPraiseDto pbPostPraiseDto);

    @GetMapping("/selectPraiseNum")
    int selectPraiseNum(@RequestParam("postUUID") String postUUID);

}
