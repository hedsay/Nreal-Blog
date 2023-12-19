package com.Nreal.service;

import com.Nreal.domain.entity.Category;
import com.Nreal.utils.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-12-18 21:43:14
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
