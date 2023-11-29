package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.dao.problem.CategoryEntityService;
import com.anjieyang.uooj.mapper.CategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.problem.Category;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class CategoryEntityServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryEntityService {
}