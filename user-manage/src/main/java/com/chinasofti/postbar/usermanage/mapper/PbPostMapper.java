package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.mapper.fallback.PbPostMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PbPostMapper", fallback = PbPostMapperFallback.class)
public interface PbPostMapper {

    @DeleteMapping("/deletePostByUserUUID")
    void deletePostByUserUUID(@RequestParam("userUUID") String[] userUUID);

}
