package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.Authority;
import com.whut.idea.freefancy.mapper.AuthorityMapper;
import com.whut.idea.freefancy.service.AuthorityService;
import org.springframework.stereotype.Service;

/**
 * AuthorityServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:41
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {
}
