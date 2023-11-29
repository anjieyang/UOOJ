package com.anjieyang.uooj.dao.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.msg.MsgRemind;
import com.anjieyang.uooj.pojo.vo.UserMsgVO;
import com.anjieyang.uooj.pojo.vo.UserUnreadMsgCountVO;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface MsgRemindEntityService extends IService<MsgRemind> {

    UserUnreadMsgCountVO getUserUnreadMsgCount(String uid);

    IPage<UserMsgVO> getUserMsg(Page<UserMsgVO> page, String uid, String action);
}