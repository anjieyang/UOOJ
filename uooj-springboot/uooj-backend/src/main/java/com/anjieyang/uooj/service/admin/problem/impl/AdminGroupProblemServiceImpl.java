package com.anjieyang.uooj.service.admin.problem.impl;

import com.anjieyang.uooj.service.admin.problem.AdminGroupProblemService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.admin.problem.AdminGroupProblemManager;
import com.anjieyang.uooj.pojo.dto.ChangeGroupProblemProgressDTO;
import com.anjieyang.uooj.pojo.entity.problem.Problem;

import javax.annotation.Resource;

/**
 * @Author Anjie Yang
 * @Date 2022/4/13
 */
@Service
public class AdminGroupProblemServiceImpl implements AdminGroupProblemService {

    @Resource
    private AdminGroupProblemManager adminGroupProblemManager;

    @Override
    public CommonResult<IPage<Problem>> getProblemList(Integer currentPage, Integer limit, String keyword, Long gid) {
        return CommonResult.successResponse(adminGroupProblemManager.list(currentPage, limit, keyword, gid));
    }

    @Override
    public CommonResult<Void> changeProgress(ChangeGroupProblemProgressDTO changeGroupProblemProgressDto) {
        try {
            adminGroupProblemManager.changeProgress(changeGroupProblemProgressDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }
}
