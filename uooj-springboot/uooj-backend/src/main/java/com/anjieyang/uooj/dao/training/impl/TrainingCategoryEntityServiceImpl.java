package com.anjieyang.uooj.dao.training.impl;

import com.anjieyang.uooj.mapper.TrainingCategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;
import com.anjieyang.uooj.dao.training.TrainingCategoryEntityService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class TrainingCategoryEntityServiceImpl extends ServiceImpl<TrainingCategoryMapper, TrainingCategory> implements TrainingCategoryEntityService {

    @Resource
    private TrainingCategoryMapper trainingCategoryMapper;

    @Override
    public TrainingCategory getTrainingCategoryByTrainingId(Long tid) {
        return trainingCategoryMapper.getTrainingCategoryByTrainingId(tid);
    }
}