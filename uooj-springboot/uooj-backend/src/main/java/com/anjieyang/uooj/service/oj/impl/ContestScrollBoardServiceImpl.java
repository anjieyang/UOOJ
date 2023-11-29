package com.anjieyang.uooj.service.oj.impl;

import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.oj.ContestScrollBoardManager;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardInfoVO;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardSubmissionVO;
import com.anjieyang.uooj.service.oj.ContestScrollBoardService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/10/3
 */
@Service
public class ContestScrollBoardServiceImpl implements ContestScrollBoardService {

    @Resource
    private ContestScrollBoardManager contestScrollBoardManager;

    @Override
    public CommonResult<ContestScrollBoardInfoVO> getContestScrollBoardInfo(Long cid) {
        try {
            return CommonResult.successResponse(contestScrollBoardManager.getContestScrollBoardInfo(cid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<List<ContestScrollBoardSubmissionVO>> getContestScrollBoardSubmission(Long cid, Boolean removeStar) {
        try {
            return CommonResult.successResponse(contestScrollBoardManager.getContestScrollBoardSubmission(cid, removeStar));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}
