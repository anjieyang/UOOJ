package com.anjieyang.uooj.service.admin.rejudge.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.rejudge.RejudgeManager;
import com.anjieyang.uooj.pojo.entity.judge.Judge;

import com.anjieyang.uooj.service.admin.rejudge.RejudgeService;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class RejudgeServiceImpl implements RejudgeService {

    @Autowired
    private RejudgeManager rejudgeManager;

    @Override
    public CommonResult<Judge> rejudge(Long submitId) {
        try {
            Judge judge = rejudgeManager.rejudge(submitId);
            return CommonResult.successResponse(judge, "重判成功！该提交已进入判题队列！");
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> rejudgeContestProblem(Long cid, Long pid) {
        try {
            rejudgeManager.rejudgeContestProblem(cid, pid);
            return CommonResult.successResponse("重判成功！该题目对应的全部提交已进入判题队列！");
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Judge> manualJudge(Long submitId, Integer status, Integer score) {
        try {
            return CommonResult.successResponse(rejudgeManager.manualJudge(submitId, status, score));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Judge> cancelJudge(Long submitId) {
        try {
            return CommonResult.successResponse(rejudgeManager.cancelJudge(submitId));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}