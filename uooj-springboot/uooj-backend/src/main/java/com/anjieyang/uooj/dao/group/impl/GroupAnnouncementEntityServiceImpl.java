package com.anjieyang.uooj.dao.group.impl;

import com.anjieyang.uooj.mapper.GroupAnnouncementMapper;
import com.anjieyang.uooj.dao.group.GroupAnnouncementEntityService;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupAnnouncementEntityServiceImpl extends ServiceImpl<GroupAnnouncementMapper, Announcement> implements GroupAnnouncementEntityService {

    @Autowired
    private GroupAnnouncementMapper groupAnnouncementMapper;

    @Override
    public IPage<AnnouncementVO> getAnnouncementList(int limit, int currentPage, Long gid) {
        IPage<AnnouncementVO> iPage = new Page<>(currentPage, limit);

        List<AnnouncementVO> announcementList = groupAnnouncementMapper.getAnnouncementList(iPage, gid);

        return iPage.setRecords(announcementList);
    }

    @Override
    public IPage<AnnouncementVO> getAdminAnnouncementList(int limit, int currentPage, Long gid) {
        IPage<AnnouncementVO> iPage = new Page<>(currentPage, limit);

        List<AnnouncementVO> announcementList = groupAnnouncementMapper.getAdminAnnouncementList(iPage, gid);

        return iPage.setRecords(announcementList);
    }

}
