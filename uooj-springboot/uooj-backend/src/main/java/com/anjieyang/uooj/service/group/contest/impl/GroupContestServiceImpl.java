package com.anjieyang.uooj.service.group.contest.impl;

import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.group.contest.GroupContestManager;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.vo.AdminContestVO;
import com.anjieyang.uooj.pojo.vo.ContestVO;
import com.anjieyang.uooj.service.group.contest.GroupContestService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupContestServiceImpl implements GroupContestService {

    @Autowired
    private GroupContestManager groupContestManager;

    @Override
    public CommonResult<IPage<ContestVO>> getContestList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupContestManager.getContestList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<IPage<Contest>> getAdminContestList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupContestManager.getAdminContestList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<AdminContestVO> getContest(Long tid) {
        try {
            return CommonResult.successResponse(groupContestManager.getContest(tid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<Void> addContest(AdminContestVO adminContestVo) {
        try {
            groupContestManager.addContest(adminContestVo);
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
    public CommonResult<Void> updateContest(AdminContestVO adminContestVo) {
        try {
            groupContestManager.updateContest(adminContestVo);
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
    public CommonResult<Void> deleteContest(Long tid) {
        try {
            groupContestManager.deleteContest(tid);
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
    public CommonResult<Void> changeContestVisible(Long tid, Boolean visible) {
        try {
            groupContestManager.changeContestVisible(tid, visible);
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
