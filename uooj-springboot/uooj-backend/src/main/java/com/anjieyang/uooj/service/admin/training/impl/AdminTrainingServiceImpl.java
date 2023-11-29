package com.anjieyang.uooj.service.admin.training.impl;

import com.anjieyang.uooj.service.admin.training.AdminTrainingService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.admin.training.AdminTrainingManager;
import com.anjieyang.uooj.pojo.dto.TrainingDTO;
import com.anjieyang.uooj.pojo.entity.training.Training;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class AdminTrainingServiceImpl implements AdminTrainingService {

    @Autowired
    private AdminTrainingManager adminTrainingManager;

    @Override
    public CommonResult<IPage<Training>> getTrainingList(Integer limit, Integer currentPage, String keyword) {
        return CommonResult.successResponse(adminTrainingManager.getTrainingList(limit, currentPage, keyword));
    }

    @Override
    public CommonResult<TrainingDTO> getTraining(Long tid) {
        try {
            TrainingDTO training = adminTrainingManager.getTraining(tid);
            return CommonResult.successResponse(training);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> deleteTraining(Long tid) {
        try {
            adminTrainingManager.deleteTraining(tid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> addTraining(TrainingDTO trainingDto) {
        try {
            adminTrainingManager.addTraining(trainingDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateTraining(TrainingDTO trainingDto) {
        try {
            adminTrainingManager.updateTraining(trainingDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> changeTrainingStatus(Long tid, String author, Boolean status) {
        try {
            adminTrainingManager.changeTrainingStatus(tid, author, status);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }
}