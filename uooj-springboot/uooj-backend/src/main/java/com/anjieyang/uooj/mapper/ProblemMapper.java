package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

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
    List<ProblemVO> getProblemList(IPage page,
                                   @Param("pid") Long pid,
                                   @Param("keyword") String keyword,
                                   @Param("difficulty") Integer difficulty,
                                   @Param("tid") List<Long> tid,
                                   @Param("tagListSize") Integer tagListSize,
                                   @Param("oj") String oj);
}
