package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.UserAuthority;
import com.whut.idea.freefancy.mapper.UserAuthorityMapper;
import com.whut.idea.freefancy.service.UserAuthorityService;
import org.springframework.stereotype.Service;

/**
 * UserAuthorityServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:44
 */
@Service
public class UserAuthorityServiceImpl extends ServiceImpl<UserAuthorityMapper, UserAuthority> implements UserAuthorityService {
}
