package com.whut.idea.freefancy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whut.idea.freefancy.entity.Article;
import com.whut.idea.freefancy.mapper.ArticleMapper;
import com.whut.idea.freefancy.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * ArticleServiceImpl
 *
 * @author LiMing
 * @date 2021/11/9 15:40
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
