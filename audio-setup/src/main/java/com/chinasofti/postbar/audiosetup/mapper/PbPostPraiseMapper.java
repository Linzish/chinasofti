package com.chinasofti.postbar.audiosetup.mapper;

import com.chinasofti.postbar.audiosetup.mapper.fallback.PbPostPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;

@FeignClient(name = "PbPostPraiseMapper", fallback = PbPostPraiseMapperFallback.class)
public interface PbPostPraiseMapper {

    @DeleteMapping("/deletePostPraise")
    void deletePostPraise(String[] postUUID);

}
