package com.anjieyang.uooj.dao.group;

import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.vo.TrainingVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupTrainingEntityService extends IService<Training> {

    IPage<TrainingVO> getTrainingList(int limit, int currentPage, Long gid);

    IPage<Training> getAdminTrainingList(int limit, int currentPage, Long gid);

}
