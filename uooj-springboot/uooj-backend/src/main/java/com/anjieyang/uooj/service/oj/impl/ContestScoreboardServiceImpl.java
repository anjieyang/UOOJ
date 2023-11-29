package com.anjieyang.uooj.service.oj.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.ContestScoreboardManager;
import com.anjieyang.uooj.pojo.dto.ContestRankDTO;
import com.anjieyang.uooj.pojo.vo.ContestOutsideInfoVO;
import com.anjieyang.uooj.service.oj.ContestScoreboardService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ContestScoreboardServiceImpl implements ContestScoreboardService {

    @Resource
    private ContestScoreboardManager contestScoreboardManager;

    @Override
    public CommonResult<ContestOutsideInfoVO> getContestOutsideInfo(Long cid) {
        try {
            return CommonResult.successResponse(contestScoreboardManager.getContestOutsideInfo(cid));
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<IPage> getContestOutsideScoreboard(ContestRankDTO contestRankDto) {
        try {
            return CommonResult.successResponse(contestScoreboardManager.getContestOutsideScoreboard(contestRankDto));
        }  catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}