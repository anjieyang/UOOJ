package com.anjieyang.uooj.service.group.training.impl;

import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.group.training.GroupTrainingManager;
import com.anjieyang.uooj.pojo.dto.TrainingDTO;
import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.vo.TrainingVO;
import com.anjieyang.uooj.service.group.training.GroupTrainingService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupTrainingServiceImpl implements GroupTrainingService {

    @Autowired
    private GroupTrainingManager groupTrainingManager;

    @Override
    public CommonResult<IPage<TrainingVO>> getTrainingList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupTrainingManager.getTrainingList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<IPage<Training>> getAdminTrainingList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupTrainingManager.getAdminTrainingList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<TrainingDTO> getTraining(Long tid) {
        try {
            return CommonResult.successResponse(groupTrainingManager.getTraining(tid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> addTraining(TrainingDTO trainingDto) {
        try {
            groupTrainingManager.addTraining(trainingDto);
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
    public CommonResult<Void> updateTraining(TrainingDTO trainingDto) {
        try {
            groupTrainingManager.updateTraining(trainingDto);
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
    public CommonResult<Void> deleteTraining(Long tid) {
        try {
            groupTrainingManager.deleteTraining(tid);
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
    public CommonResult<Void> changeTrainingStatus(Long tid, Boolean status) {
        try {
            groupTrainingManager.changeTrainingStatus(tid, status);
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
