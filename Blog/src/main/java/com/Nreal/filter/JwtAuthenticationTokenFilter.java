package com.Nreal.filter;

import com.Nreal.domain.entity.LoginUser;
import com.Nreal.enums.AppHttpCodeEnum;
import com.Nreal.utils.JwtUtil;
import com.Nreal.utils.RedisCache;
import com.Nreal.utils.ResponseResult;
import com.Nreal.utils.WebUtils;
import io.jsonwebtoken.Claims;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)) {
            // 不需要token，直接放行
            filterChain.doFilter(request,response);
            return ;
        }
        // 解析token获取userId
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            // token超时
            ResponseResult responseResult = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(responseResult));
            return ;
        }
        String userId = claims.getSubject();
        // redis获取用户信息
        LoginUser loginUser = redisCache.getCacheObject("blogLogin:"+userId);
        // 无缓存重新登录
        if(Objects.isNull(loginUser)){
            ResponseResult responseResult = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(responseResult));
            return ;
        }
        // 存入ContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}