package com.anjieyang.uooj.mapper;

import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.vo.TrainingVO;
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
public interface GroupTrainingMapper extends BaseMapper<Training> {

    List<TrainingVO> getTrainingList(IPage iPage, @Param("gid") Long gid);

    List<Training> getAdminTrainingList(IPage iPage, @Param("gid") Long gid);

}
