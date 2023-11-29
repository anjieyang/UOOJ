package com.anjieyang.uooj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.problem.Problem;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Mapper
@Repository
public interface ProblemMapper extends BaseMapper<Problem> {

}
