package com.Nreal.service;

import com.Nreal.domain.entity.User;
import com.Nreal.utils.ResponseResult;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
