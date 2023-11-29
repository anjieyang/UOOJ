package com.anjieyang.uooj.service.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.vo.UserMsgVO;
import com.anjieyang.uooj.pojo.vo.UserUnreadMsgCountVO;

public interface UserMessageService {

    public CommonResult<UserUnreadMsgCountVO> getUnreadMsgCount();

    public CommonResult<Void> cleanMsg(String type, Long id);

    public CommonResult<IPage<UserMsgVO>> getCommentMsg(Integer limit, Integer currentPage);

    public CommonResult<IPage<UserMsgVO>> getReplyMsg(Integer limit, Integer currentPage);

    public CommonResult<IPage<UserMsgVO>> getLikeMsg(Integer limit, Integer currentPage);

}
