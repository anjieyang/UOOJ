package com.anjieyang.uooj.dao.training;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;

public interface TrainingCategoryEntityService extends IService<TrainingCategory> {

    public TrainingCategory getTrainingCategoryByTrainingId(Long tid);
}
