package com.anjieyang.uooj.service.msg.impl;

import com.anjieyang.uooj.service.msg.UserMessageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.msg.UserMessageManager;
import com.anjieyang.uooj.pojo.vo.UserMsgVO;
import com.anjieyang.uooj.pojo.vo.UserUnreadMsgCountVO;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Resource
    private UserMessageManager userMessageManager;

    @Override
    public CommonResult<UserUnreadMsgCountVO> getUnreadMsgCount() {
        return CommonResult.successResponse(userMessageManager.getUnreadMsgCount());
    }

    @Override
    public CommonResult<Void> cleanMsg(String type, Long id) {
        try {
            userMessageManager.cleanMsg(type, id);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<IPage<UserMsgVO>> getCommentMsg(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(userMessageManager.getCommentMsg(limit, currentPage));
    }

    @Override
    public CommonResult<IPage<UserMsgVO>> getReplyMsg(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(userMessageManager.getReplyMsg(limit, currentPage));
    }

    @Override
    public CommonResult<IPage<UserMsgVO>> getLikeMsg(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(userMessageManager.getLikeMsg(limit, currentPage));
    }
}