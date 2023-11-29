package com.anjieyang.uooj.dao.impl;


import com.anjieyang.uooj.mapper.ProblemMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.dao.ProblemEntityService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class ProblemEntityServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemEntityService {

}
