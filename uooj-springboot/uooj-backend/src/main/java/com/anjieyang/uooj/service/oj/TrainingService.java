package com.anjieyang.uooj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.RegisterTrainingDTO;
import com.anjieyang.uooj.pojo.vo.AccessVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.vo.TrainingRankVO;
import com.anjieyang.uooj.pojo.vo.TrainingVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface TrainingService {

    public CommonResult<IPage<TrainingVO>> getTrainingList(Integer limit, Integer currentPage,
                                                           String keyword, Long categoryId, String auth);

    public CommonResult<TrainingVO> getTraining(Long tid);

    public CommonResult<List<ProblemVO>> getTrainingProblemList(Long tid);

    public CommonResult<Void> toRegisterTraining(RegisterTrainingDTO registerTrainingDto);

    public CommonResult<AccessVO> getTrainingAccess(Long tid);

    public CommonResult<IPage<TrainingRankVO>> getTrainingRank(Long tid, Integer limit, Integer currentPage,String keyword);
}