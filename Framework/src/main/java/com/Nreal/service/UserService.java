package com.Nreal.service;

import com.Nreal.domain.entity.User;
import com.Nreal.utils.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-12-20 19:58:12
 */
public interface UserService extends IService<User> {

    ResponseResult register(User user);
}
