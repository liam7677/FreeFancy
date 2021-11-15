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
 * ArticleDeleted
 *
 * @author LiMing
 * @date 2021/11/9 15:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("article_deleted")
public class ArticleDeleted {
    @TableId(value = "id")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date gmtDelete;

    private String articleContent;

    private Long creatorId;

    private String picturePath;
}
