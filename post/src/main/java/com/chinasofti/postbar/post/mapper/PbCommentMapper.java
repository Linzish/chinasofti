package com.chinasofti.postbar.post.mapper;

import com.chinasofti.postbar.post.mapper.fallback.PbCommentMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbCommentMapper", fallback = PbCommentMapperFallback.class)
public interface PbCommentMapper {

    @DeleteMapping("/deleteCommentByPostUUID")
    void deleteCommentByPostUUID(@RequestParam("postUUID") String[] postUUID);

}
