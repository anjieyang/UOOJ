package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.mapper.CodeTemplateMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.problem.CodeTemplate;
import com.anjieyang.uooj.dao.problem.CodeTemplateEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class CodeTemplateEntityServiceImpl extends ServiceImpl<CodeTemplateMapper, CodeTemplate> implements CodeTemplateEntityService {
}