package com.anjieyang.uooj.mapper;

import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Mapper
@Repository
public interface GroupProblemMapper extends BaseMapper<Problem> {

    List<ProblemVO> getProblemList(IPage iPage, @Param("gid") Long gid);

    List<Problem> getAdminProblemList(IPage iPage, @Param("gid") Long gid);
}
