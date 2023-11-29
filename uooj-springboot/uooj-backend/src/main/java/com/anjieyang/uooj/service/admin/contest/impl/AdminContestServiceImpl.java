package com.anjieyang.uooj.service.admin.contest.impl;

import com.anjieyang.uooj.service.admin.contest.AdminContestService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.admin.contest.AdminContestManager;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.vo.AdminContestVO;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class AdminContestServiceImpl implements AdminContestService {

    @Autowired
    private AdminContestManager adminContestManager;

    @Override
    public CommonResult<IPage<Contest>> getContestList(Integer limit, Integer currentPage, String keyword) {
        IPage<Contest> contestList = adminContestManager.getContestList(limit, currentPage, keyword);
        return CommonResult.successResponse(contestList);
    }

    @Override
    public CommonResult<AdminContestVO> getContest(Long cid) {
        try {
            AdminContestVO adminContestVo = adminContestManager.getContest(cid);
            return CommonResult.successResponse(adminContestVo);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> deleteContest(Long cid) {
        try {
            adminContestManager.deleteContest(cid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> addContest(AdminContestVO adminContestVo) {
        try {
            adminContestManager.addContest(adminContestVo);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> cloneContest(Long cid) {
        try {
            adminContestManager.cloneContest(cid);
            return CommonResult.successResponse();
        }catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }

    @Override
    public CommonResult<Void> updateContest(AdminContestVO adminContestVo) {

        try {
            adminContestManager.updateContest(adminContestVo);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
        return CommonResult.successResponse();
    }

    @Override
    public CommonResult<Void> changeContestVisible(Long cid, String uid, Boolean visible) {
        try {
            adminContestManager.changeContestVisible(cid, uid, visible);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
        return CommonResult.successResponse();
    }
}