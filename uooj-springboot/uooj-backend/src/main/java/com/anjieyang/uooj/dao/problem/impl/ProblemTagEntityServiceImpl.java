package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.mapper.ProblemTagMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.problem.ProblemTag;
import com.anjieyang.uooj.dao.problem.ProblemTagEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ProblemTagEntityServiceImpl extends ServiceImpl<ProblemTagMapper, ProblemTag> implements ProblemTagEntityService {
}