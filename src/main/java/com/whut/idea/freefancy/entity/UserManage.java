package com.whut.idea.freefancy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.whut.idea.freefancy.dto.UserManageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Date;

/**
 * UserManage
 *
 * @author LiMing
 * @date 2021/11/9 14:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user_manage")
public class UserManage {

    @TableId(value = "id")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date gmtModified;

    private String username;

    private String password;

    private Byte roleId;

    private Byte isDeleted;

    public UserManage(UserManageDTO userManageDTO){
        this.setUsername(userManageDTO.getUsername());
        this.setPassword(userManageDTO.getUsername());
    }
}
