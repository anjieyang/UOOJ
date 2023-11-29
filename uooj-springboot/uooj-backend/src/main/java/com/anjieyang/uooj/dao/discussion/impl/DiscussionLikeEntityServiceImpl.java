package com.anjieyang.uooj.dao.discussion.impl;

import com.anjieyang.uooj.mapper.DiscussionLikeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionLike;
import com.anjieyang.uooj.dao.discussion.DiscussionLikeEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class DiscussionLikeEntityServiceImpl extends ServiceImpl<DiscussionLikeMapper, DiscussionLike> implements DiscussionLikeEntityService {
}