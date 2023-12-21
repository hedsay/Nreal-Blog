package com.Nreal.controller;

import com.Nreal.domain.entity.Article;
import com.Nreal.service.ArticleService;
import com.Nreal.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/articleList/{pageNum}/{pageSize}/{categoryId}")
    @ApiOperation(value = "文章分页展示")
    public ResponseResult articleList(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable("categoryId") Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "文章详情")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }

    @PutMapping("/updateViewCount/{id}")
    @ApiOperation(value = "文章浏览数")
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }

}
