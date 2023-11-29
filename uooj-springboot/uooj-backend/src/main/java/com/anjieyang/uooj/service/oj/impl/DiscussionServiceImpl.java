package com.anjieyang.uooj.service.oj.impl;

import com.anjieyang.uooj.exception.AccessException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.DiscussionManager;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionReport;
import com.anjieyang.uooj.pojo.entity.problem.Category;
import com.anjieyang.uooj.pojo.vo.DiscussionVO;
import com.anjieyang.uooj.service.oj.DiscussionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Resource
    private DiscussionManager discussionManager;

    @Override
    public CommonResult<IPage<Discussion>> getDiscussionList(Integer limit, Integer currentPage, Integer categoryId, String pid, Boolean onlyMine, String keyword, Boolean admin) {
        return CommonResult.successResponse(discussionManager.getDiscussionList(limit, currentPage, categoryId, pid, onlyMine, keyword, admin));
    }

    @Override
    public CommonResult<DiscussionVO> getDiscussion(Integer did) {
        try {
            return CommonResult.successResponse(discussionManager.getDiscussion(did));
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> addDiscussion(Discussion discussion) {
        try {
            discussionManager.addDiscussion(discussion);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> updateDiscussion(Discussion discussion) {
        try {
            discussionManager.updateDiscussion(discussion);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> removeDiscussion(Integer did) {
        try {
            discussionManager.removeDiscussion(did);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> addDiscussionLike(Integer did, Boolean toLike) {
        try {
            discussionManager.addDiscussionLike(did, toLike);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<List<Category>> getDiscussionCategory() {
        return CommonResult.successResponse(discussionManager.getDiscussionCategory());
    }

    @Override
    public CommonResult<List<Category>> upsertDiscussionCategory(List<Category> categoryList) {
        try {
            return CommonResult.successResponse(discussionManager.upsertDiscussionCategory(categoryList));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> addDiscussionReport(DiscussionReport discussionReport) {
        try {
            discussionManager.addDiscussionReport(discussionReport);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}