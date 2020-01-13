package com.chinasofti.postbar.post.mapper;

import com.chinasofti.postbar.post.mapper.fallback.PbCommentPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbCommentPraiseMapper", fallback = PbCommentPraiseMapperFallback.class)
public interface PbCommentPraiseMapper {

    @DeleteMapping("/deleteCommentPraiseByPostUUID")
    void deleteCommentPraiseByPostUUID(@RequestParam("postUUID") String[] postUUID);

}
