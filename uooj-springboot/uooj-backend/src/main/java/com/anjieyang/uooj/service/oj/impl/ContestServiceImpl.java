package com.anjieyang.uooj.service.oj.impl;

import com.anjieyang.uooj.pojo.vo.*;
import com.anjieyang.uooj.service.oj.ContestService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.ContestManager;
import com.anjieyang.uooj.pojo.dto.ContestPrintDTO;
import com.anjieyang.uooj.pojo.dto.ContestRankDTO;
import com.anjieyang.uooj.pojo.dto.RegisterContestDTO;
import com.anjieyang.uooj.pojo.dto.UserReadContestAnnouncementDTO;
import com.anjieyang.uooj.pojo.entity.common.Announcement;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ContestServiceImpl implements ContestService {

    @Resource
    private ContestManager contestManager;

    @Override
    public CommonResult<IPage<ContestVO>> getContestList(Integer limit, Integer currentPage, Integer status, Integer type, String keyword) {
        return CommonResult.successResponse(contestManager.getContestList(limit, currentPage, status, type, keyword));
    }

    @Override
    public CommonResult<ContestVO> getContestInfo(Long cid) {
        try {
            return CommonResult.successResponse(contestManager.getContestInfo(cid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> toRegisterContest(RegisterContestDTO registerContestDto) {
        try {
            contestManager.toRegisterContest(registerContestDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<AccessVO> getContestAccess(Long cid) {
        try {
            return CommonResult.successResponse(contestManager.getContestAccess(cid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<List<ContestProblemVO>> getContestProblem(Long cid, Boolean isContainsContestEndJudge) {
        try {
            return CommonResult.successResponse(contestManager.getContestProblem(cid, isContainsContestEndJudge));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<ProblemInfoVO> getContestProblemDetails(Long cid, String displayId, Boolean isContainsContestEndJudge) {
        try {
            return CommonResult.successResponse(contestManager.getContestProblemDetails(cid, displayId, isContainsContestEndJudge));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<IPage<JudgeVO>> getContestSubmissionList(Integer limit,
                                                                 Integer currentPage,
                                                                 Boolean onlyMine,
                                                                 String displayId,
                                                                 Integer searchStatus,
                                                                 String searchUsername,
                                                                 Long searchCid,
                                                                 Boolean beforeContestSubmit,
                                                                 Boolean completeProblemID,
                                                                 Boolean isContainsContestEndJudge) {
        try {
            return CommonResult.successResponse(contestManager.getContestSubmissionList(limit,
                    currentPage,
                    onlyMine,
                    displayId,
                    searchStatus,
                    searchUsername,
                    searchCid,
                    beforeContestSubmit,
                    completeProblemID,
                    isContainsContestEndJudge));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<IPage> getContestRank(ContestRankDTO contestRankDto) {
        try {
            return CommonResult.successResponse(contestManager.getContestRank(contestRankDto));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<IPage<AnnouncementVO>> getContestAnnouncement(Long cid, Integer limit, Integer currentPage) {
        try {
            return CommonResult.successResponse(contestManager.getContestAnnouncement(cid, limit, currentPage));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<List<Announcement>> getContestUserNotReadAnnouncement(UserReadContestAnnouncementDTO userReadContestAnnouncementDto) {

        return CommonResult.successResponse(contestManager.getContestUserNotReadAnnouncement(userReadContestAnnouncementDto));
    }

    @Override
    public CommonResult<Void> submitPrintText(ContestPrintDTO contestPrintDto) {
        try {
            contestManager.submitPrintText(contestPrintDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }
}