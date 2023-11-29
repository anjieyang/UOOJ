package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.vo.TrainingVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Mapper
@Repository
public interface TrainingMapper extends BaseMapper<Training> {

    List<TrainingVO> getTrainingList(IPage page,
                                     @Param("categoryId") Long categoryId,
                                     @Param("auth") String auth,
                                     @Param("keyword") String keyword);
}