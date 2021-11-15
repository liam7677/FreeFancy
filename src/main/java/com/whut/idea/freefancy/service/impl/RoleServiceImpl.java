package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.Role;
import com.whut.idea.freefancy.mapper.RoleMapper;
import com.whut.idea.freefancy.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * RoleServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:42
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
