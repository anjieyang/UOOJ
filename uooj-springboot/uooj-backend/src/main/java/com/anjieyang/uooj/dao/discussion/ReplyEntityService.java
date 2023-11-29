package com.anjieyang.uooj.dao.discussion;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.discussion.Reply;
import com.anjieyang.uooj.pojo.vo.ReplyVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface ReplyEntityService extends IService<Reply> {

    public List<ReplyVO> getAllReplyByCommentId(Long cid, String uid, Boolean isRoot, Integer commentId);

    public void updateReplyMsg(Integer sourceId, String sourceType, String content,
                               Integer quoteId, String quoteType, String recipientId,String senderId);
}