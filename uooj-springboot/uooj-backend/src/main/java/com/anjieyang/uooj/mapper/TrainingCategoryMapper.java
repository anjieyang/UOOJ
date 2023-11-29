package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;

@Mapper
@Repository
public interface TrainingCategoryMapper extends BaseMapper<TrainingCategory> {

    public TrainingCategory getTrainingCategoryByTrainingId(@Param("tid") Long tid);
}
