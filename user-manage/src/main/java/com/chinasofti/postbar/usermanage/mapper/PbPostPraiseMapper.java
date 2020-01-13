package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.mapper.fallback.PbPostPraiseMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbPostPraiseMapper", fallback = PbPostPraiseMapperFallback.class)
public interface PbPostPraiseMapper {

    @DeleteMapping("/deletePostPraiseByUserUUID")
    void deletePostPraiseByUserUUID(@RequestParam("userUUID") String[] userUUID);

}
