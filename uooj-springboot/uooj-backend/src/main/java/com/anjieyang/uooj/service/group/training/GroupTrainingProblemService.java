package com.anjieyang.uooj.service.group.training;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.TrainingProblemDTO;
import com.anjieyang.uooj.pojo.entity.training.TrainingProblem;

import java.util.HashMap;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupTrainingProblemService {

    public CommonResult<HashMap<String, Object>> getTrainingProblemList(Integer limit, Integer currentPage, String keyword, Boolean queryExisted, Long tid);

    public CommonResult<Void> updateTrainingProblem(TrainingProblem trainingProblem);

    public CommonResult<Void> deleteTrainingProblem(Long pid, Long tid);

    public CommonResult<Void> addProblemFromPublic(TrainingProblemDTO trainingProblemDto);

    public CommonResult<Void> addProblemFromGroup(String problemId, Long tid);

}
