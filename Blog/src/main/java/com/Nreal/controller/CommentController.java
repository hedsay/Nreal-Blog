package com.Nreal.controller;

import com.Nreal.constant.SystemConstants;
import com.Nreal.domain.entity.Comment;
import com.Nreal.service.CommentService;
import com.Nreal.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "评论接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList/{articleId}/{pageNum}/{pageSize}")
    @ApiOperation(value = "评论列表")
    public ResponseResult commentList(@PathVariable Long articleId,@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }

    @PostMapping
    @ApiOperation(value = "发表评论")
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

}