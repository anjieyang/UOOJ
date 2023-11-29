package com.anjieyang.uooj.dao.discussion;

import com.baomidou.mybatisplus.extension.service.IService;

import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.vo.DiscussionVO;

public interface DiscussionEntityService extends IService<Discussion> {

    DiscussionVO getDiscussion(Integer did, String uid);

    void updatePostLikeMsg(String recipientId, String senderId, Integer discussionId, Long gid);
}
