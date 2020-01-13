package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.mapper.fallback.PbCommentPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbCommentPraiseMapper", fallback = PbCommentPraiseMapperFallback.class)
public interface PbCommentPraiseMapper {

    @DeleteMapping("/deleteCommentPraiseByUserUUID")
    void deleteCommentPraiseByUserUUID(@RequestParam("userUUID") String[] userUUID);

}
