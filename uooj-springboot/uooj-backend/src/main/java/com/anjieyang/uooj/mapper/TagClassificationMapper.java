package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.problem.TagClassification;

/**
 * @Author Anjie Yang
 * @Date 2022/8/3
 */
@Mapper
@Repository
public interface TagClassificationMapper extends BaseMapper<TagClassification> {
}
