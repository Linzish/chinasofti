package com.chinasofti.postbar.usermanage.mapper;

import com.chinasofti.postbar.usermanage.dto.UserDto;
import com.chinasofti.postbar.usermanage.mapper.fallback.PbUserMapperFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@FeignClient(name = "PbUserMapper", fallback = PbUserMapperFallback.class)
public interface PbUserMapper {

    @PostMapping("/insertUser")
    void insertUser(@RequestBody UserDto userDto);

    @GetMapping("/selectUserNumByUserName")
    int selectUserNumByUserName(@RequestParam("userName") String userName);

    @PutMapping("/updateLoginTimeByUserName")
    void updateLoginTimeByUserName(@RequestParam("userName") String userName, @RequestParam("loginTime") Date loginTime);

    @GetMapping("/selectUserByUserNameAndPassword")
    UserDto selectUserByUserNameAndPassword(@RequestParam("userName") String userName, @RequestParam("password") String password);

    @PutMapping("/updatePasswordByUserName")
    void updatePasswordByUserName(@RequestParam("userName") String userName, @RequestParam("password") String password);

    @PutMapping("/updateUserNameByUserUUID")
    void updateUserNameByUserUUID(@RequestParam("userName") String userName, @RequestParam("userUUID") String userUUID);


    @GetMapping("/selectUserAllNum")
    int selectUserAllNum(@RequestParam("userName") String userName, @RequestParam("userUUID") String userUUID);

    @DeleteMapping("/deleteUserByUserUUID")
    void deleteUserByUserUUID(@RequestParam("userUUID") String[] userUUID);

    @PutMapping("/updateUserByUserUUID")
    void updateUserByUserUUID(@RequestBody UserDto userDto);

}
