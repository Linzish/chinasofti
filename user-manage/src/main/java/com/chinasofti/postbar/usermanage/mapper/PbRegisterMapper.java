package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.dto.RegisterDto;
import com.chinasofti.postbar.usermanage.mapper.fallback.PbRegisterMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PbRegisterMapper", fallback = PbRegisterMapperFallback.class)
public interface PbRegisterMapper {

    @PostMapping("/insertRegister")
    void insertRegister(@RequestBody RegisterDto registerDto);

    @GetMapping("/selectRegisterAndUserName")
    RegisterDto selectRegisterAndUserName(@RequestParam("userUUID") String userUUID);

    @PutMapping("/upDateRegisterByRegUUID")
    void upDateRegisterByRegUUID(@RequestBody RegisterDto registerDto);

    @GetMapping("/selectRegList")
    List<RegisterDto> selectRegList(@RequestParam("userName") String userName, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam("userUUID") String userUUID);


    @DeleteMapping("/deleteRegByUserUUID")
    void deleteRegByUserUUID(@RequestParam("userUUID") String[] userUUID);

    @PutMapping("/updateRegByUserUUID")
    void updateRegByUserUUID(@RequestBody RegisterDto registerDto);

}
