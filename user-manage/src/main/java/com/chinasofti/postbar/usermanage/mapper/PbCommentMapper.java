package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.mapper.fallback.PbCommentMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbCommentMapper", fallback = PbCommentMapperFallback.class)
public interface PbCommentMapper {

    @DeleteMapping("/deleteCommentByUserUUID")
    void deleteCommentByUserUUID(@RequestParam("userUUID") String[] userUUID);

}
