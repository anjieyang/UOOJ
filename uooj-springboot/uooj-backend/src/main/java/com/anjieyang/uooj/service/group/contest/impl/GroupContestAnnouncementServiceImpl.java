package com.anjieyang.uooj.service.group.contest.impl;

import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.group.contest.GroupContestAnnouncementManager;
import com.anjieyang.uooj.pojo.dto.AnnouncementDTO;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.anjieyang.uooj.service.group.contest.GroupContestAnnouncementService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupContestAnnouncementServiceImpl implements GroupContestAnnouncementService {

    @Autowired
    private GroupContestAnnouncementManager groupContestAnnouncementManager;

    @Override
    public CommonResult<IPage<AnnouncementVO>> getContestAnnouncementList(Integer limit, Integer currentPage, Long cid) {
        try {
            return CommonResult.successResponse(groupContestAnnouncementManager.getContestAnnouncementList(limit, currentPage, cid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> addContestAnnouncement(AnnouncementDTO announcementDto) {
        try {
            groupContestAnnouncementManager.addContestAnnouncement(announcementDto);
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
    public CommonResult<Void> updateContestAnnouncement(AnnouncementDTO announcementDto) {
        try {
            groupContestAnnouncementManager.updateContestAnnouncement(announcementDto);
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
    public CommonResult<Void> deleteContestAnnouncement(Long aid, Long cid) {
        try {
            groupContestAnnouncementManager.deleteContestAnnouncement(aid, cid);
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
