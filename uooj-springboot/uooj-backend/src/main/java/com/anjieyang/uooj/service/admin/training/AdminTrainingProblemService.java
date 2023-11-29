package com.anjieyang.uooj.service.admin.training;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.TrainingProblemDTO;
import com.anjieyang.uooj.pojo.entity.training.TrainingProblem;

import java.util.HashMap;

public interface AdminTrainingProblemService {

    public CommonResult<HashMap<String, Object>> getProblemList(Integer limit, Integer currentPage, String keyword, Boolean queryExisted, Long tid);

    public CommonResult<Void> updateProblem(TrainingProblem trainingProblem);

    public CommonResult<Void> deleteProblem(Long pid,Long tid);

    public CommonResult<Void> addProblemFromPublic(TrainingProblemDTO trainingProblemDto);

    public CommonResult<Void> importTrainingRemoteOJProblem(String name, String problemId, Long tid);
}
