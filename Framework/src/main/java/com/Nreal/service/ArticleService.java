package com.Nreal.service;

import com.Nreal.domain.entity.Article;
import com.Nreal.utils.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2023-12-17 22:10:56
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);
}
