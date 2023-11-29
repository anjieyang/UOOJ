package com.anjieyang.uooj.dao.discussion.impl;

import com.anjieyang.uooj.dao.msg.MsgRemindEntityService;
import com.anjieyang.uooj.dao.user.UserInfoEntityService;
import com.anjieyang.uooj.mapper.ReplyMapper;
import com.anjieyang.uooj.utils.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.dao.contest.ContestEntityService;
import com.anjieyang.uooj.dao.discussion.DiscussionEntityService;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.entity.msg.MsgRemind;
import com.anjieyang.uooj.pojo.entity.discussion.Reply;
import com.anjieyang.uooj.dao.discussion.ReplyEntityService;
import com.anjieyang.uooj.pojo.vo.ReplyVO;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ReplyEntityServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyEntityService {

    @Resource
    private MsgRemindEntityService msgRemindEntityService;

    @Autowired
    private ContestEntityService contestEntityService;

    @Autowired
    private UserInfoEntityService userInfoEntityService;

    @Autowired
    private DiscussionEntityService discussionEntityService;

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<ReplyVO> getAllReplyByCommentId(Long cid, String uid, Boolean isRoot, Integer commentId) {


        if (cid != null) {
            Contest contest = contestEntityService.getById(cid);
            boolean onlyMineAndAdmin = contest.getStatus().equals(Constants.Contest.STATUS_RUNNING.getCode())
                    && !isRoot && !contest.getUid().equals(uid);
            if (onlyMineAndAdmin) { // 自己和比赛管理者评论可看

                List<String> myAndAdminUidList = userInfoEntityService.getSuperAdminUidList();
                myAndAdminUidList.add(uid);
                myAndAdminUidList.add(contest.getUid());
                return replyMapper.getAllReplyByCommentId(commentId, myAndAdminUidList);
            }

        }
        return replyMapper.getAllReplyByCommentId(commentId, null);
    }

    @Async
    @Override
    public void updateReplyMsg(Integer sourceId, String sourceType, String content,
                               Integer quoteId, String quoteType, String recipientId, String senderId) {
        if (content.length() > 200) {
            content = content.substring(0, 200) + "...";
        }

        MsgRemind msgRemind = new MsgRemind();
        msgRemind.setAction("Reply")
                .setSourceId(sourceId)
                .setSourceType(sourceType)
                .setSourceContent(content)
                .setQuoteId(quoteId)
                .setQuoteType(quoteType)
                .setRecipientId(recipientId)
                .setSenderId(senderId);


        if (sourceType.equals("Discussion")) {
            Discussion discussion = discussionEntityService.getById(sourceId);
            if (discussion != null) {
                if (discussion.getGid() != null) {
                    msgRemind.setUrl("/group/" + discussion.getGid() + "/discussion-detail/" + sourceId);
                } else {
                    msgRemind.setUrl("/discussion-detail/" + sourceId);
                }
            }
        } else if (sourceType.equals("Contest")) {
            msgRemind.setUrl("/contest/" + sourceId + "/comment");
        }

        msgRemindEntityService.saveOrUpdate(msgRemind);
    }
}