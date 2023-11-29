package com.anjieyang.uooj.dao.discussion.impl;

import com.anjieyang.uooj.dao.msg.MsgRemindEntityService;
import com.anjieyang.uooj.mapper.DiscussionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.entity.msg.MsgRemind;
import com.anjieyang.uooj.pojo.vo.DiscussionVO;
import com.anjieyang.uooj.dao.discussion.DiscussionEntityService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class DiscussionEntityServiceImpl extends ServiceImpl<DiscussionMapper, Discussion> implements DiscussionEntityService {

    @Autowired
    private DiscussionMapper discussionMapper;

    @Override
    public DiscussionVO getDiscussion(Integer did, String uid) {
        return discussionMapper.getDiscussion(did, uid);
    }

    @Resource
    private MsgRemindEntityService msgRemindEntityService;

    @Async
    public void updatePostLikeMsg(String recipientId, String senderId, Integer discussionId, Long gid) {

        MsgRemind msgRemind = new MsgRemind();
        msgRemind.setAction("Like_Post")
                .setRecipientId(recipientId)
                .setSenderId(senderId)
                .setSourceId(discussionId)
                .setSourceType("Discussion")
                .setUrl("/discussion-detail/" + discussionId);

        if (gid != null) {
            msgRemind.setUrl("/group/" + gid + "/discussion-detail/" + discussionId);
        } else {
            msgRemind.setUrl("/discussion-detail/" + discussionId);
        }

        msgRemindEntityService.saveOrUpdate(msgRemind);
    }
}