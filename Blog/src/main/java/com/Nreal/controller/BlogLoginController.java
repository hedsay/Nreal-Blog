package com.Nreal.controller;

import com.Nreal.domain.entity.User;
import com.Nreal.enums.AppHttpCodeEnum;
import com.Nreal.exception.SystemException;
import com.Nreal.service.BlogLoginService;
import com.Nreal.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录接口")
@RestController
public class BlogLoginController {

    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "退出登录")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }

}
