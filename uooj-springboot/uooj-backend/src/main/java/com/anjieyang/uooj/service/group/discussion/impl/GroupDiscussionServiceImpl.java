package com.anjieyang.uooj.service.group.discussion.impl;

import com.anjieyang.uooj.service.group.discussion.GroupDiscussionService;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;

import com.anjieyang.uooj.manager.group.discussion.GroupDiscussionManager;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupDiscussionServiceImpl implements GroupDiscussionService {

    @Autowired
    private GroupDiscussionManager groupDiscussionManager;

    @Override
    public CommonResult<IPage<Discussion>> getDiscussionList(Integer limit, Integer currentPage, Long gid, String pid) {
        try {
            return CommonResult.successResponse(groupDiscussionManager.getDiscussionList(limit, currentPage, gid, pid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<IPage<Discussion>> getAdminDiscussionList(Integer limit, Integer currentPage, Long gid) {
        try {
            return CommonResult.successResponse(groupDiscussionManager.getAdminDiscussionList(limit, currentPage, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> addDiscussion(Discussion discussion) {
        try {
            groupDiscussionManager.addDiscussion(discussion);
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
    public CommonResult<Void> updateDiscussion(Discussion discussion) {
        try {
            groupDiscussionManager.updateDiscussion(discussion);
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
    public CommonResult<Void> deleteDiscussion(Long did) {
        try {
            groupDiscussionManager.deleteDiscussion(did);
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
