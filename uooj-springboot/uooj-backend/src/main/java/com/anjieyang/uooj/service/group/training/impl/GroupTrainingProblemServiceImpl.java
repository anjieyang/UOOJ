package com.anjieyang.uooj.service.group.training.impl;

import com.anjieyang.uooj.service.group.training.GroupTrainingProblemService;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.group.training.GroupTrainingProblemManager;
import com.anjieyang.uooj.pojo.dto.TrainingProblemDTO;
import com.anjieyang.uooj.pojo.entity.training.TrainingProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupTrainingProblemServiceImpl implements GroupTrainingProblemService {

    @Autowired
    private GroupTrainingProblemManager groupTrainingProblemManager;

    @Override
    public CommonResult<HashMap<String, Object>> getTrainingProblemList(Integer limit, Integer currentPage, String keyword, Boolean queryExisted, Long tid) {
        try {
            return CommonResult.successResponse(groupTrainingProblemManager.getTrainingProblemList(limit, currentPage, keyword, queryExisted, tid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> updateTrainingProblem(TrainingProblem trainingProblem) {
        try {
            groupTrainingProblemManager.updateTrainingProblem(trainingProblem);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> deleteTrainingProblem(Long pid, Long tid) {
        try {
            groupTrainingProblemManager.deleteTrainingProblem(pid, tid);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> addProblemFromPublic(TrainingProblemDTO trainingProblemDto) {
        try {
            groupTrainingProblemManager.addProblemFromPublic(trainingProblemDto);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> addProblemFromGroup(String problemId, Long tid) {
        try {
            groupTrainingProblemManager.addProblemFromGroup(problemId, tid);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }
}
