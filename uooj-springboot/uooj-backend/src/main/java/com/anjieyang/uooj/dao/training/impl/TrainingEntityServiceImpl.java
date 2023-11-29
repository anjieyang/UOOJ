package com.anjieyang.uooj.dao.training.impl;

import com.anjieyang.uooj.mapper.TrainingMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.anjieyang.uooj.dao.training.TrainingEntityService;
import com.anjieyang.uooj.dao.training.TrainingProblemEntityService;
import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.entity.training.TrainingProblem;
import com.anjieyang.uooj.pojo.vo.TrainingVO;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class TrainingEntityServiceImpl extends ServiceImpl<TrainingMapper, Training> implements TrainingEntityService {

    @Resource
    private TrainingMapper trainingMapper;

    @Resource
    private TrainingProblemEntityService trainingProblemEntityService;


    @Override
    public Page<TrainingVO> getTrainingList(int limit,
                                            int currentPage,
                                            Long categoryId,
                                            String auth,
                                            String keyword,
                                            String currentUid) {

        //新建分页
        Page<TrainingVO> page = new Page<>(currentPage, limit);

        List<TrainingVO> trainingList = trainingMapper.getTrainingList(page, categoryId, auth, keyword);

        // 当前用户有登录，且训练列表不为空，则查询用户对于每个训练的做题进度
        if (!StringUtils.isEmpty(currentUid) && trainingList.size() > 0) {
            List<Long> tidList = trainingList.stream().map(TrainingVO::getId).collect(Collectors.toList());
            List<TrainingProblem> trainingProblemList = trainingProblemEntityService.getTrainingListAcceptedCountByUid(tidList, currentUid);

            HashMap<Long, Integer> tidMapCount = new HashMap<>(trainingList.size());
            for (TrainingProblem trainingProblem : trainingProblemList) {
                int count = tidMapCount.getOrDefault(trainingProblem.getTid(), 0);
                count++;
                tidMapCount.put(trainingProblem.getTid(), count);
            }

            for (TrainingVO trainingVo : trainingList) {
                Integer count = tidMapCount.getOrDefault(trainingVo.getId(), 0);
                trainingVo.setAcCount(count);
            }
        }

        page.setRecords(trainingList);
        return page;
    }


}