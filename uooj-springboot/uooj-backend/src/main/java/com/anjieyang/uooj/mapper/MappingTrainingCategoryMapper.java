package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.training.MappingTrainingCategory;

@Mapper
@Repository
public interface MappingTrainingCategoryMapper extends BaseMapper<MappingTrainingCategory> {
}
