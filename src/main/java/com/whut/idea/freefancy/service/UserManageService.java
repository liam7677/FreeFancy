package com.whut.idea.freefancy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whut.idea.freefancy.entity.UserManage;

/**
 * UserManageService
 *
 * @author LiMing
 * @date 2021/11/9 15:34
 */
public interface UserManageService extends IService<UserManage> {
    /**
     * 根据用户名查询该用户是否存在
     * @param username
     * @return
     */
    UserManage getOneByUsername(String username);
}
