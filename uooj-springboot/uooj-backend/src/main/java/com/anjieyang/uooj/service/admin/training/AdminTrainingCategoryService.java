package com.anjieyang.uooj.service.admin.training;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface AdminTrainingCategoryService {

    public CommonResult<TrainingCategory> addTrainingCategory(TrainingCategory trainingCategory);

    public CommonResult<Void> updateTrainingCategory(TrainingCategory trainingCategory);

    public CommonResult<Void> deleteTrainingCategory(Long cid);
}