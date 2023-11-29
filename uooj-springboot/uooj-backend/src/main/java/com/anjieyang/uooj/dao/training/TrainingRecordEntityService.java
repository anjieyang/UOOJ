package com.anjieyang.uooj.dao.training;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.training.TrainingRecord;
import com.anjieyang.uooj.pojo.vo.TrainingRecordVO;

import java.util.List;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface TrainingRecordEntityService extends IService<TrainingRecord> {

    public List<TrainingRecordVO> getTrainingRecord(Long tid);

}