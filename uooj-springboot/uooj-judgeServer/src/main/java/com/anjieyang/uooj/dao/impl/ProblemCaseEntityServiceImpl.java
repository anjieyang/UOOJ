package com.anjieyang.uooj.dao.impl;

import com.anjieyang.uooj.mapper.ProblemCaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.problem.ProblemCase;
import com.anjieyang.uooj.dao.ProblemCaseEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ProblemCaseEntityServiceImpl extends ServiceImpl<ProblemCaseMapper, ProblemCase> implements ProblemCaseEntityService {
}