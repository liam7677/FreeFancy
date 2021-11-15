package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.UserRole;
import com.whut.idea.freefancy.mapper.UserRoleMapper;
import com.whut.idea.freefancy.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * UserRoleServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:46
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
