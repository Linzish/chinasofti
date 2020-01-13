package com.chinasofti.postbar.usermanage.mapper.fallback;

import com.chinasofti.postbar.usermanage.dto.RegisterDto;
import com.chinasofti.postbar.usermanage.mapper.PbRegisterMapper;

import java.util.List;

public class PbRegisterMapperFallback implements PbRegisterMapper {
    @Override
    public void insertRegister(RegisterDto registerDto) {

    }

    @Override
    public RegisterDto selectRegisterAndUserName(String userUUID) {
        return null;
    }

    @Override
    public void upDateRegisterByRegUUID(RegisterDto registerDto) {

    }

    @Override
    public List<RegisterDto> selectRegList(String userName, Integer pageNo, Integer pageSize, String userUUID) {
        return null;
    }

    @Override
    public void deleteRegByUserUUID(String[] userUUID) {

    }

    @Override
    public void updateRegByUserUUID(RegisterDto registerDto) {

    }
}
