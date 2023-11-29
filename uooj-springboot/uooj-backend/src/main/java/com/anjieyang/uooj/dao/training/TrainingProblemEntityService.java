package com.anjieyang.uooj.dao.training;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.training.TrainingProblem;
import com.anjieyang.uooj.pojo.vo.ProblemFullScreenListVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface TrainingProblemEntityService extends IService<TrainingProblem> {
    public List<Long> getTrainingProblemIdList(Long tid);

    public List<ProblemVO> getTrainingProblemList(Long tid);

    public Integer getUserTrainingACProblemCount(String uid, Long gid, List<Long> pidList);

    public List<TrainingProblem> getPrivateTrainingProblemListByPid(Long pid, String uid);

    public List<TrainingProblem> getTrainingListAcceptedCountByUid(List<Long> tidList, String uid);

    public List<TrainingProblem> getGroupTrainingListAcceptedCountByUid(List<Long> tidList, Long gid, String uid);

    public List<ProblemFullScreenListVO> getTrainingFullScreenProblemList(Long tid);
}