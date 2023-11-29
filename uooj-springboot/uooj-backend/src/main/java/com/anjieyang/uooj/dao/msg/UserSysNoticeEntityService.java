package com.anjieyang.uooj.dao.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.msg.UserSysNotice;
import com.anjieyang.uooj.pojo.vo.SysMsgVO;

public interface UserSysNoticeEntityService extends IService<UserSysNotice> {

    IPage<SysMsgVO> getSysNotice(int limit, int currentPage, String uid);

    IPage<SysMsgVO> getMineNotice(int limit, int currentPage, String uid);
}