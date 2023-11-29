package com.anjieyang.uooj.service.oj.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.ContestAdminManager;
import com.anjieyang.uooj.pojo.dto.CheckACDTO;
import com.anjieyang.uooj.pojo.entity.contest.ContestPrint;
import com.anjieyang.uooj.pojo.entity.contest.ContestRecord;
import com.anjieyang.uooj.service.oj.ContestAdminService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Service
public class ContestAdminServiceImpl implements ContestAdminService {

    @Resource
    private ContestAdminManager contestAdminManager;

    @Override
    public CommonResult<IPage<ContestRecord>> getContestACInfo(Long cid, Integer currentPage, Integer limit) {
        try {
            return CommonResult.successResponse(contestAdminManager.getContestACInfo(cid, currentPage, limit));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> checkContestACInfo(CheckACDTO checkACDto) {
        try {
            contestAdminManager.checkContestACInfo(checkACDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<IPage<ContestPrint>> getContestPrint(Long cid, Integer currentPage, Integer limit) {
        try {
            return CommonResult.successResponse(contestAdminManager.getContestPrint(cid, currentPage, limit));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> checkContestPrintStatus(Long id, Long cid) {
        try {
            contestAdminManager.checkContestPrintStatus(id, cid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }
}