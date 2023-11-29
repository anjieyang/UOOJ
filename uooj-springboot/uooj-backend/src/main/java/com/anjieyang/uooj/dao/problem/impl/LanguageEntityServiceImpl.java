package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.mapper.LanguageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.problem.Language;
import com.anjieyang.uooj.dao.problem.LanguageEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class LanguageEntityServiceImpl extends ServiceImpl<LanguageMapper, Language> implements LanguageEntityService {
}