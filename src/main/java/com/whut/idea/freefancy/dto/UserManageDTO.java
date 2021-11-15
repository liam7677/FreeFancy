package com.whut.idea.freefancy.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author LiMing
 * @date 2021/11/13 21:11
 */
@Data
public class UserManageDTO {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
