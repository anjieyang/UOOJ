package com.anjieyang.uooj.service.admin.training.impl;

import com.anjieyang.uooj.service.admin.training.AdminTrainingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.training.AdminTrainingCategoryManager;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Service
public class AdminTrainingCategoryServiceImpl implements AdminTrainingCategoryService {

    @Autowired
    private AdminTrainingCategoryManager adminTrainingCategoryManager;

    @Override
    public CommonResult<TrainingCategory> addTrainingCategory(TrainingCategory trainingCategory) {
        try {
            return CommonResult.successResponse(adminTrainingCategoryManager.addTrainingCategory(trainingCategory));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateTrainingCategory(TrainingCategory trainingCategory) {
        try {
            adminTrainingCategoryManager.updateTrainingCategory(trainingCategory);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> deleteTrainingCategory(Long cid) {
        try {
            adminTrainingCategoryManager.deleteTrainingCategory(cid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}