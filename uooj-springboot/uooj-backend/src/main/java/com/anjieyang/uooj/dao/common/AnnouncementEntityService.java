package com.anjieyang.uooj.dao.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface AnnouncementEntityService extends IService<Announcement> {

    IPage<AnnouncementVO> getAnnouncementList(int limit, int currentPage, Boolean notAdmin);

    IPage<AnnouncementVO> getContestAnnouncement(Long cid, Boolean notAdmin, int limit, int currentPage);
}
