package com.anjieyang.uooj.dao.training.impl;

import com.anjieyang.uooj.mapper.TrainingRecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.training.TrainingRecord;
import com.anjieyang.uooj.pojo.vo.TrainingRecordVO;
import com.anjieyang.uooj.dao.training.TrainingRecordEntityService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class TrainingRecordEntityServiceImpl extends ServiceImpl<TrainingRecordMapper, TrainingRecord> implements TrainingRecordEntityService {

    @Resource
    private TrainingRecordMapper trainingRecordMapper;

    @Override
    public List<TrainingRecordVO> getTrainingRecord(Long tid){
        return trainingRecordMapper.getTrainingRecord(tid);
    }

}