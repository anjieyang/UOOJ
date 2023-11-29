package com.anjieyang.uooj.dao.training;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.vo.TrainingVO;

public interface TrainingEntityService extends IService<Training> {

    public Page<TrainingVO> getTrainingList(int limit,
                                            int currentPage,
                                            Long categoryId,
                                            String auth,
                                            String keyword,
                                            String currentUid);

}
