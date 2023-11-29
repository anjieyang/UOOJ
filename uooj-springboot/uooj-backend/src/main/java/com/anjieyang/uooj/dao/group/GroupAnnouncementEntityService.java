package com.anjieyang.uooj.dao.group;

import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupAnnouncementEntityService extends IService<Announcement> {

    IPage<AnnouncementVO> getAnnouncementList(int limit, int currentPage, Long gid);

    IPage<AnnouncementVO> getAdminAnnouncementList(int limit, int currentPage, Long gid);

}
