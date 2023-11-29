package com.anjieyang.uooj.dao.group.impl;

import com.anjieyang.uooj.dao.group.GroupDiscussionEntityService;
import com.anjieyang.uooj.mapper.GroupDiscussionMapper;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupDiscussionEntityServiceImpl extends ServiceImpl<GroupDiscussionMapper, Discussion> implements GroupDiscussionEntityService {
}
