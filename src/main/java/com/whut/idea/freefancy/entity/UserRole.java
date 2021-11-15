package com.whut.idea.freefancy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * UserRole
 *
 * @author LiMing
 * @date 2021/11/9 15:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user_role_security")
public class UserRole {
    @TableId(value = "id")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date gmtModified;

    private Long userId;

    private Byte roleId;

    private String roleName;
}
