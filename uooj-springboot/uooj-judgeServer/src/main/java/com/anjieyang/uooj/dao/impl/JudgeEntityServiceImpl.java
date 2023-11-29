package com.anjieyang.uooj.dao.impl;


import com.anjieyang.uooj.mapper.JudgeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.judge.Judge;
import com.anjieyang.uooj.dao.JudgeEntityService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class JudgeEntityServiceImpl extends ServiceImpl<JudgeMapper, Judge> implements JudgeEntityService {

}
