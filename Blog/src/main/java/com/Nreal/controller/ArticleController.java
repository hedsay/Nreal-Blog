package com.Nreal.controller;

import com.Nreal.domain.entity.Article;
import com.Nreal.service.ArticleService;
import com.Nreal.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文章接口")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    @ApiOperation(value = "测试")
    public List<Article> test(){
        return articleService.list();
    }

    @GetMapping("/hotArticleList")
    @ApiOperation(value = "热门文章")
    public ResponseResult hotArticleList(){
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

}
