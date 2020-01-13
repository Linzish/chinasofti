package com.chinasofti.postbar.usermanage.service;

import com.chinasofti.postbar.usermanage.dto.RegisterDto;
import com.chinasofti.postbar.usermanage.dto.UserDto;
import com.chinasofti.postbar.usermanage.mapper.*;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManageService {

    @Autowired
    private PbUserMapper pbUserMapper;
    @Autowired
    private PbRegisterMapper pbRegisterMapper;
    @Autowired
    private PbAudioMapper pbAudioMapper;
    @Autowired
    private PbCommentMapper pbCommentMapper;
    @Autowired
    private PbCommentPraiseMapper pbCommentPraiseMapper;
    @Autowired
    private PbPostMapper pbPostMapper;
    @Autowired
    private PbPostPraiseMapper pbPostPraiseMapper;

    public int getUserAllNum(String userName, String userUUID) {
        return pbUserMapper.selectUserAllNum(userName, userUUID);
    }

    public List<RegisterDto> selectRegList(String userName, Integer pageNo, Integer pageSize, String userUUID) {
        return pbRegisterMapper.selectRegList(userName, pageNo, pageSize, userUUID);
    }

    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor={RuntimeException.class, Exception.class})
    public void deleteUser(String[] userUUID) {
        pbAudioMapper.deleteAudioByUserUUID(userUUID);
        pbCommentMapper.deleteCommentByUserUUID(userUUID);
        pbCommentPraiseMapper.deleteCommentPraiseByUserUUID(userUUID);
        pbPostMapper.deletePostByUserUUID(userUUID);
        pbPostPraiseMapper.deletePostPraiseByUserUUID(userUUID);
        pbRegisterMapper.deleteRegByUserUUID(userUUID);
        pbUserMapper.deleteUserByUserUUID(userUUID);
    }

    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor={RuntimeException.class, Exception.class})
    public void updateUser(UserDto userDto, RegisterDto registerDto) {
        pbUserMapper.updateUserByUserUUID(userDto);
        pbRegisterMapper.updateRegByUserUUID(registerDto);
    }


}
