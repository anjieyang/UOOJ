package com.anjieyang.uooj.service.admin.announcement.impl;

import com.anjieyang.uooj.service.admin.announcement.AdminAnnouncementService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.announcement.AdminAnnouncementManager;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class AdminAnnouncementServiceImpl implements AdminAnnouncementService {

    @Resource
    private AdminAnnouncementManager adminAnnouncementManager;

    @Override
    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(adminAnnouncementManager.getAnnouncementList(limit, currentPage));
    }

    @Override
    public CommonResult<Void> deleteAnnouncement(Long aid) {
        try {
            adminAnnouncementManager.deleteAnnouncement(aid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> addAnnouncement(Announcement announcement) {
        try {
            adminAnnouncementManager.addAnnouncement(announcement);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateAnnouncement(Announcement announcement) {
        try {
            adminAnnouncementManager.updateAnnouncement(announcement);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}