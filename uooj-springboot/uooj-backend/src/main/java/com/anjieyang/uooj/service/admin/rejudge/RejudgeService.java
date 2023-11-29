package com.anjieyang.uooj.service.admin.rejudge;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.judge.Judge;

public interface RejudgeService {

    CommonResult<Judge> rejudge(Long submitId);

    CommonResult<Void> rejudgeContestProblem(Long cid, Long pid);

    CommonResult<Judge> manualJudge(Long submitId, Integer status, Integer score);

    CommonResult<Judge> cancelJudge(Long submitId);
}
