package com.anjieyang.uooj.dao.contest.impl;

import com.anjieyang.uooj.mapper.ContestAnnouncementMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.contest.ContestAnnouncement;
import com.anjieyang.uooj.dao.contest.ContestAnnouncementEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ContestAnnouncementEntityServiceImpl extends ServiceImpl<ContestAnnouncementMapper, ContestAnnouncement> implements ContestAnnouncementEntityService {
}