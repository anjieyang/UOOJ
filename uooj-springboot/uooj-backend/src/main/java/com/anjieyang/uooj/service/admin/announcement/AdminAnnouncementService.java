package com.anjieyang.uooj.service.admin.announcement;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface AdminAnnouncementService {

    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(Integer limit, Integer currentPage);

    public CommonResult<Void> deleteAnnouncement(Long aid);

    public CommonResult<Void> addAnnouncement(Announcement announcement);

    public CommonResult<Void> updateAnnouncement(Announcement announcement);
}