package com.anjieyang.uooj.service.oj.impl;

import com.anjieyang.uooj.exception.AccessException;
import com.anjieyang.uooj.service.oj.CommentService;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.CommentManager;
import com.anjieyang.uooj.pojo.dto.ReplyDTO;
import com.anjieyang.uooj.pojo.entity.discussion.Comment;
import com.anjieyang.uooj.pojo.vo.CommentListVO;
import com.anjieyang.uooj.pojo.vo.CommentVO;
import com.anjieyang.uooj.pojo.vo.ReplyVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentManager commentManager;

    @Override
    public CommonResult<CommentListVO> getComments(Long cid, Integer did, Integer limit, Integer currentPage) {
        try {
            return CommonResult.successResponse(commentManager.getComments(cid, did, limit, currentPage));
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<CommentVO> addComment(Comment comment) {
        try {
            return CommonResult.successResponse(commentManager.addComment(comment));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> deleteComment(Comment comment) {
        try {
            commentManager.deleteComment(comment);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> addCommentLike(Integer cid, Boolean toLike, Integer sourceId, String sourceType) {
        try {
            commentManager.addCommentLike(cid, toLike, sourceId, sourceType);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<List<ReplyVO>> getAllReply(Integer commentId, Long cid) {
        try {
            return CommonResult.successResponse(commentManager.getAllReply(commentId, cid));
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }

    @Override
    public CommonResult<ReplyVO> addReply(ReplyDTO replyDto) {
        try {
            return CommonResult.successResponse(commentManager.addReply(replyDto));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> deleteReply(ReplyDTO replyDto) {
        try {
            commentManager.deleteReply(replyDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException | AccessException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }
}