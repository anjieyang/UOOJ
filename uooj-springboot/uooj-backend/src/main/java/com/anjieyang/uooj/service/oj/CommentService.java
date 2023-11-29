package com.anjieyang.uooj.service.oj;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ReplyDTO;
import com.anjieyang.uooj.pojo.entity.discussion.Comment;
import com.anjieyang.uooj.pojo.vo.CommentListVO;
import com.anjieyang.uooj.pojo.vo.CommentVO;
import com.anjieyang.uooj.pojo.vo.ReplyVO;

import java.util.List;

public interface CommentService {

    public CommonResult<CommentListVO> getComments(Long cid, Integer did, Integer limit, Integer currentPage);

    public CommonResult<CommentVO> addComment(Comment comment);

    public CommonResult<Void> deleteComment(Comment comment);

    public CommonResult<Void> addCommentLike(Integer cid, Boolean toLike, Integer sourceId, String sourceType);

    public CommonResult<List<ReplyVO>> getAllReply(Integer commentId, Long cid);

    public CommonResult<ReplyVO> addReply(ReplyDTO replyDto);

    public CommonResult<Void> deleteReply(ReplyDTO replyDto);
}
