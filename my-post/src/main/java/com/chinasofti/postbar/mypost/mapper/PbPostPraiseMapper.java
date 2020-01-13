package com.chinasofti.postbar.mypost.mapper;

import com.chinasofti.postbar.mypost.mapper.fallback.PbPostPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbPostPraiseMapper", fallback = PbPostPraiseMapperFallback.class)
public interface PbPostPraiseMapper {

    @DeleteMapping("/deletePostPraise")
    void deletePostPraise(@RequestParam("postUUID") String[] postUUID);

}
