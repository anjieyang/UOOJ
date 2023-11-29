package com.anjieyang.uooj.service.group.training;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.TrainingDTO;
import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.vo.TrainingVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupTrainingService {

    public CommonResult<IPage<TrainingVO>> getTrainingList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<IPage<Training>> getAdminTrainingList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<TrainingDTO> getTraining(Long tid);

    public CommonResult<Void> addTraining(TrainingDTO trainingDto);

    public CommonResult<Void> updateTraining(TrainingDTO trainingDto);

    public CommonResult<Void> deleteTraining(Long tid);

    public CommonResult<Void> changeTrainingStatus(Long tid, Boolean status);

}
