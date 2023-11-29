package com.anjieyang.uooj.service.group.announcement;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupAnnouncementService {

    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<IPage<AnnouncementVO>> getAdminAnnouncementList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<Void> addAnnouncement(Announcement announcement);

    public CommonResult<Void> updateAnnouncement(Announcement announcement);

    public CommonResult<Void> deleteAnnouncement(Long aid);

}
