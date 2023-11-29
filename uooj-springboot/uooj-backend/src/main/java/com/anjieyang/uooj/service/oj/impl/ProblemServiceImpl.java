package com.anjieyang.uooj.service.oj.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusAccessDeniedException;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.ProblemManager;
import com.anjieyang.uooj.pojo.dto.LastAcceptedCodeVO;
import com.anjieyang.uooj.pojo.dto.PidListDTO;
import com.anjieyang.uooj.pojo.vo.ProblemFullScreenListVO;
import com.anjieyang.uooj.pojo.vo.ProblemInfoVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.vo.RandomProblemVO;
import com.anjieyang.uooj.service.oj.ProblemService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    private ProblemManager problemManager;

    @Override
    public CommonResult<Page<ProblemVO>> getProblemList(Integer limit, Integer currentPage, String keyword, List<Long> tagId, Integer difficulty, String oj) {
        return CommonResult.successResponse(problemManager.getProblemList(limit, currentPage, keyword, tagId, difficulty, oj));
    }

    @Override
    public CommonResult<RandomProblemVO> getRandomProblem() {
        try {
            return CommonResult.successResponse(problemManager.getRandomProblem());
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<HashMap<Long, Object>> getUserProblemStatus(PidListDTO pidListDto) {
        try {
            return CommonResult.successResponse(problemManager.getUserProblemStatus(pidListDto));
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<ProblemInfoVO> getProblemInfo(String problemId, Long gid) {
        try {
            return CommonResult.successResponse(problemManager.getProblemInfo(problemId, gid));
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<LastAcceptedCodeVO> getUserLastAcceptedCode(Long pid, Long cid) {
        return CommonResult.successResponse(problemManager.getUserLastAcceptedCode(pid, cid));
    }

    @Override
    public CommonResult<List<ProblemFullScreenListVO>> getFullScreenProblemList(Long tid, Long cid) {
        try {
            return CommonResult.successResponse(problemManager.getFullScreenProblemList(tid, cid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        }
    }
}