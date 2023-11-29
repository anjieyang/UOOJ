package com.anjieyang.uooj.dao.msg.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.mapper.MsgRemindMapper;
import com.anjieyang.uooj.pojo.entity.msg.MsgRemind;
import com.anjieyang.uooj.pojo.vo.UserMsgVO;
import com.anjieyang.uooj.pojo.vo.UserUnreadMsgCountVO;
import com.anjieyang.uooj.dao.msg.MsgRemindEntityService;

import javax.annotation.Resource;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class MsgRemindEntityServiceImpl extends ServiceImpl<MsgRemindMapper, MsgRemind> implements MsgRemindEntityService {

    @Resource
    private MsgRemindMapper msgRemindMapper;
    @Override
    public UserUnreadMsgCountVO getUserUnreadMsgCount(String uid) {
        return msgRemindMapper.getUserUnreadMsgCount(uid);
    }

    @Override
    public IPage<UserMsgVO> getUserMsg(Page<UserMsgVO> page, String uid, String action) {
        return msgRemindMapper.getUserMsg(page, uid, action);
    }

}