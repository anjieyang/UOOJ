package com.anjieyang.uooj.service.oj.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusAccessDeniedException;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.TrainingManager;
import com.anjieyang.uooj.pojo.dto.RegisterTrainingDTO;
import com.anjieyang.uooj.pojo.vo.AccessVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.vo.TrainingRankVO;
import com.anjieyang.uooj.pojo.vo.TrainingVO;
import com.anjieyang.uooj.service.oj.TrainingService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class TrainingServiceImpl implements TrainingService {

    @Resource
    private TrainingManager trainingManager;

    @Override
    public CommonResult<IPage<TrainingVO>> getTrainingList(Integer limit, Integer currentPage,
                                                           String keyword, Long categoryId, String auth) {
        return CommonResult.successResponse(trainingManager.getTrainingList(limit, currentPage, keyword, categoryId, auth));
    }

    @Override
    public CommonResult<TrainingVO> getTraining(Long tid) {
        try {
            return CommonResult.successResponse(trainingManager.getTraining(tid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<List<ProblemVO>> getTrainingProblemList(Long tid) {
        try {
            return CommonResult.successResponse(trainingManager.getTrainingProblemList(tid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> toRegisterTraining(RegisterTrainingDTO registerTrainingDto) {
        try {
            trainingManager.toRegisterTraining(registerTrainingDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<AccessVO> getTrainingAccess(Long tid) {
        try {
            return CommonResult.successResponse(trainingManager.getTrainingAccess(tid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<IPage<TrainingRankVO>> getTrainingRank(Long tid, Integer limit, Integer currentPage, String keyword) {
        try {
            return CommonResult.successResponse(trainingManager.getTrainingRank(tid, limit, currentPage, keyword));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }
}