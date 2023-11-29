package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.problem.Category;

@Mapper
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
}
