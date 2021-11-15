package com.whut.idea.freefancy.service.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whut.idea.freefancy.entity.*;
import com.whut.idea.freefancy.mapper.RoleMapper;
import com.whut.idea.freefancy.mapper.UserAuthorityMapper;
import com.whut.idea.freefancy.mapper.UserManageMapper;
import com.whut.idea.freefancy.mapper.UserRoleMapper;
import com.whut.idea.freefancy.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiMing
 * @date 2021/11/11 23:14
 */
public class UserManageSecurityService implements UserDetailsService {

    @Autowired
    private UserManageMapper userManageMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserAuthorityMapper userAuthorityMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<UserManage> userManageQueryWrapper = new QueryWrapper<>();
        userManageQueryWrapper.eq("username", s).ne("is_deleted", 1);
        UserManage userManage = userManageMapper.selectOne(userManageQueryWrapper);
        if (userManage == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> grantedAuthorityList= new ArrayList<>();

        QueryWrapper<UserRole> roleQueryWrapperrapper = new QueryWrapper<>();
        roleQueryWrapperrapper.eq("user_id", userManage.getId());
        List<UserRole> userRoles = userRoleMapper.selectList(roleQueryWrapperrapper);

        QueryWrapper<UserAuthority> authorityQueryWrapper = new QueryWrapper<>();
        authorityQueryWrapper.eq("user_id", userManage.getId());
        List<UserAuthority> userAuthorities = userAuthorityMapper.selectList(authorityQueryWrapper);

        for (UserRole userRole : userRoles) {
            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRoleName()));
        }

        for (UserAuthority userAuthority : userAuthorities) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(userAuthority.getAuthorityContent()));
        }
        return new User(userManage.getUsername(), userManage.getPassword(), grantedAuthorityList);
    }

}
