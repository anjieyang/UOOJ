package com.anjieyang.uooj.dao.msg.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.mapper.UserSysNoticeMapper;
import com.anjieyang.uooj.pojo.entity.msg.UserSysNotice;
import com.anjieyang.uooj.pojo.vo.SysMsgVO;
import com.anjieyang.uooj.dao.msg.UserSysNoticeEntityService;

import javax.annotation.Resource;
/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class UserSysNoticeEntityServiceImpl extends ServiceImpl<UserSysNoticeMapper, UserSysNotice> implements UserSysNoticeEntityService {

    @Resource
    private UserSysNoticeMapper userSysNoticeMapper;

    @Override
    public IPage<SysMsgVO> getSysNotice(int limit, int currentPage, String uid) {
        Page<SysMsgVO> page = new Page<>(currentPage, limit);
        return userSysNoticeMapper.getSysOrMineNotice(page, uid, "Sys");
    }

    @Override
    public IPage<SysMsgVO> getMineNotice(int limit, int currentPage, String uid) {
        Page<SysMsgVO> page = new Page<>(currentPage, limit);
        return userSysNoticeMapper.getSysOrMineNotice(page, uid, "Mine");
    }

}