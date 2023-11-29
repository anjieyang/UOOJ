package com.anjieyang.uooj.service.group.announcement.impl;

import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.group.announcement.GroupAnnouncementManager;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.anjieyang.uooj.service.group.announcement.GroupAnnouncementService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupAnnouncementServiceImpl implements GroupAnnouncementService {

    @Autowired
    private GroupAnnouncementManager groupAnnouncementManager;

    @Override
    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupAnnouncementManager.getAnnouncementList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<IPage<AnnouncementVO>> getAdminAnnouncementList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupAnnouncementManager.getAdminAnnouncementList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> addAnnouncement(Announcement announcement) {
        try {
            groupAnnouncementManager.addAnnouncement(announcement);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> updateAnnouncement(Announcement announcement) {
        try {
            groupAnnouncementManager.updateAnnouncement(announcement);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> deleteAnnouncement(Long aid) {
        try {
            groupAnnouncementManager.deleteAnnouncement(aid);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

}
