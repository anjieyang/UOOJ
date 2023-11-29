package com.anjieyang.uooj.service.admin.contest.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.contest.AdminContestAnnouncementManager;
import com.anjieyang.uooj.pojo.dto.AnnouncementDTO;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.anjieyang.uooj.service.admin.contest.AdminContestAnnouncementService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Service
public class AdminContestAnnouncementServiceImpl implements AdminContestAnnouncementService {

    @Autowired
    private AdminContestAnnouncementManager adminContestAnnouncementManager;

    @Override
    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(Integer limit, Integer currentPage, Long cid) {
        IPage<AnnouncementVO> announcementList = adminContestAnnouncementManager.getAnnouncementList(limit, currentPage, cid);
        return CommonResult.successResponse(announcementList);
    }

    @Override
    public CommonResult<Void> deleteAnnouncement(Long aid) {
        try {
            adminContestAnnouncementManager.deleteAnnouncement(aid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> addAnnouncement(AnnouncementDTO announcementDto) {
        try {
            adminContestAnnouncementManager.addAnnouncement(announcementDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateAnnouncement(AnnouncementDTO announcementDto) {
        try {
            adminContestAnnouncementManager.updateAnnouncement(announcementDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}