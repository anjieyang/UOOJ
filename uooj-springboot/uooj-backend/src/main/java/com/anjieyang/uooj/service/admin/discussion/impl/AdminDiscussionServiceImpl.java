package com.anjieyang.uooj.service.admin.discussion.impl;

import com.anjieyang.uooj.service.admin.discussion.AdminDiscussionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.discussion.AdminDiscussionManager;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionReport;
import com.anjieyang.uooj.pojo.vo.DiscussionReportVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Service
public class AdminDiscussionServiceImpl implements AdminDiscussionService {

    @Autowired
    private AdminDiscussionManager adminDiscussionManager;

    @Override
    public CommonResult<Void> updateDiscussion(Discussion discussion) {
        try {
            adminDiscussionManager.updateDiscussion(discussion);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> removeDiscussion(List<Integer> didList) {
        try {
            adminDiscussionManager.removeDiscussion(didList);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<IPage<DiscussionReportVO>> getDiscussionReport(Integer limit, Integer currentPage) {
        IPage<DiscussionReportVO> discussionReportIPage = adminDiscussionManager.getDiscussionReport(limit, currentPage);
        return CommonResult.successResponse(discussionReportIPage);
    }


    @Override
    public CommonResult<Void> updateDiscussionReport(DiscussionReport discussionReport) {
        try {
            adminDiscussionManager.updateDiscussionReport(discussionReport);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}