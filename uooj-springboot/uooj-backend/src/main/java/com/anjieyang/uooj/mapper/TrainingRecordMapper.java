package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.training.TrainingRecord;
import com.anjieyang.uooj.pojo.vo.TrainingRecordVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Mapper
@Repository
public interface TrainingRecordMapper extends BaseMapper<TrainingRecord> {

    public List<TrainingRecordVO> getTrainingRecord(@Param("tid") Long tid);
}