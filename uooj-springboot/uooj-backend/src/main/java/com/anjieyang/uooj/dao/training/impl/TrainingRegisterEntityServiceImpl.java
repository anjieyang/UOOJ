package com.anjieyang.uooj.dao.training.impl;

import com.anjieyang.uooj.mapper.TrainingRegisterMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.training.TrainingRegister;
import com.anjieyang.uooj.dao.training.TrainingRegisterEntityService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class TrainingRegisterEntityServiceImpl extends ServiceImpl<TrainingRegisterMapper, TrainingRegister> implements TrainingRegisterEntityService {

    @Resource
    private TrainingRegisterMapper trainingRegisterMapper;


    @Override
    public List<String> getAlreadyRegisterUidList(Long tid){
        QueryWrapper<TrainingRegister> trainingRegisterQueryWrapper = new QueryWrapper<>();
        trainingRegisterQueryWrapper.eq("tid", tid);
        return trainingRegisterMapper.selectList(trainingRegisterQueryWrapper).stream().map(TrainingRegister::getUid).collect(Collectors.toList());
    }

}