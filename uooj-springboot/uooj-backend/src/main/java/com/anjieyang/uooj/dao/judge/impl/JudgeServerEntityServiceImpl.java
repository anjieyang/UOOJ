package com.anjieyang.uooj.dao.judge.impl;

import com.anjieyang.uooj.mapper.JudgeServerMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.anjieyang.uooj.pojo.entity.judge.JudgeServer;
import com.anjieyang.uooj.dao.judge.JudgeServerEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class JudgeServerEntityServiceImpl extends ServiceImpl<JudgeServerMapper, JudgeServer> implements JudgeServerEntityService {

}