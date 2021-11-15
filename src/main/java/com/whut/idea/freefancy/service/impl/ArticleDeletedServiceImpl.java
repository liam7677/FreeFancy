package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.ArticleDeleted;
import com.whut.idea.freefancy.mapper.ArticleDeletedMapper;
import com.whut.idea.freefancy.service.ArticleDeletedService;
import org.springframework.stereotype.Service;

/**
 * ArticleDeletedServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:37
 */
@Service
public class ArticleDeletedServiceImpl extends ServiceImpl<ArticleDeletedMapper, ArticleDeleted> implements ArticleDeletedService {
}
