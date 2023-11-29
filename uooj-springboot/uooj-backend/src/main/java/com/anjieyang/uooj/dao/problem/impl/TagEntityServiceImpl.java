package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.mapper.TagMapper;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.dao.problem.TagEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class TagEntityServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagEntityService {

}
