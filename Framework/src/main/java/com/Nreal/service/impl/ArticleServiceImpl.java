package com.Nreal.service.impl;

import com.Nreal.domain.entity.Article;
import com.Nreal.mapper.ArticleMapper;
import com.Nreal.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2023-12-17 22:10:56
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
