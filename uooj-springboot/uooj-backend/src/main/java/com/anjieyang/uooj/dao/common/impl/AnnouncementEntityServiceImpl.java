package com.anjieyang.uooj.dao.common.impl;

import com.anjieyang.uooj.mapper.AnnouncementMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.anjieyang.uooj.dao.common.AnnouncementEntityService;
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
public class AnnouncementEntityServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementEntityService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public IPage<AnnouncementVO> getAnnouncementList(int limit, int currentPage, Boolean notAdmin) {
        //新建分页
        Page<AnnouncementVO> page = new Page<>(currentPage, limit);
        return announcementMapper.getAnnouncementList(page,notAdmin);
    }

    @Override
    public IPage<AnnouncementVO> getContestAnnouncement(Long cid, Boolean notAdmin, int limit, int currentPage) {
        Page<AnnouncementVO> page = new Page<>(currentPage, limit);
        return announcementMapper.getContestAnnouncement(page,cid,notAdmin);
    }
}
