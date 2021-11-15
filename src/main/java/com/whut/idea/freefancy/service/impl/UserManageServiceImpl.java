package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.UserManage;
import com.whut.idea.freefancy.mapper.UserManageMapper;
import com.whut.idea.freefancy.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserManageServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:45
 */
@Service
public class UserManageServiceImpl extends ServiceImpl<UserManageMapper, UserManage> implements UserManageService {

    @Autowired
    UserManageMapper userManageMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    private final Integer INSERT_SUCCESS = 1;

    @Override
    public boolean save(UserManage entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userManageMapper.insert(entity) == INSERT_SUCCESS;

    }

    @Override
    public UserManage getOneByUsername(String username) {
        QueryWrapper<UserManage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserManage userManage = userManageMapper.selectOne(queryWrapper);
        return userManage;
    }
}
