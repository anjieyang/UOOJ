package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.mapper.TagClassificationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.dao.problem.TagClassificationEntityService;
import com.anjieyang.uooj.pojo.entity.problem.TagClassification;

/**
 * @Author Anjie Yang
 * @Date 2022/8/3
 */
@Service
public class TagClassificationEntityServiceImpl extends ServiceImpl<TagClassificationMapper, TagClassification> implements TagClassificationEntityService {
}
