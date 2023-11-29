package com.anjieyang.uooj.service.admin.training.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.training.AdminTrainingProblemManager;
import com.anjieyang.uooj.pojo.dto.TrainingProblemDTO;
import com.anjieyang.uooj.pojo.entity.training.TrainingProblem;
import com.anjieyang.uooj.service.admin.training.AdminTrainingProblemService;

import java.util.HashMap;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class AdminTrainingProblemServiceImpl implements AdminTrainingProblemService {

    @Autowired
    private AdminTrainingProblemManager adminTrainingProblemManager;

    @Override
    public CommonResult<HashMap<String, Object>> getProblemList(Integer limit, Integer currentPage, String keyword, Boolean queryExisted, Long tid) {
        HashMap<String, Object> problemMap = adminTrainingProblemManager.getProblemList(limit, currentPage, keyword, queryExisted, tid);
        return CommonResult.successResponse(problemMap);
    }

    @Override
    public CommonResult<Void> updateProblem(TrainingProblem trainingProblem) {
        try {
            adminTrainingProblemManager.updateProblem(trainingProblem);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> deleteProblem(Long pid, Long tid) {
        try {
            adminTrainingProblemManager.deleteProblem(pid, tid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> addProblemFromPublic(TrainingProblemDTO trainingProblemDto) {
        try {
            adminTrainingProblemManager.addProblemFromPublic(trainingProblemDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> importTrainingRemoteOJProblem(String name, String problemId, Long tid) {
        try {
            adminTrainingProblemManager.importTrainingRemoteOJProblem(name, problemId, tid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}