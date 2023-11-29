package com.anjieyang.uooj.dao.discussion;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.pojo.entity.discussion.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.vo.CommentVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface CommentEntityService extends IService<Comment> {

    IPage<CommentVO> getCommentList(int limit, int currentPage, Long cid, Integer did, Boolean isRoot, String uid);

    void updateCommentMsg(String recipientId, String senderId, String content, Integer discussionId, Long gid);

    void updateCommentLikeMsg(String recipientId, String senderId, Integer sourceId, String sourceType);
}
