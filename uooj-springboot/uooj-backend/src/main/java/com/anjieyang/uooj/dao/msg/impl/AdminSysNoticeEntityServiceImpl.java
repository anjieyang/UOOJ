package com.anjieyang.uooj.dao.msg.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.mapper.AdminSysNoticeMapper;

import com.anjieyang.uooj.pojo.entity.msg.AdminSysNotice;
import com.anjieyang.uooj.pojo.vo.AdminSysNoticeVO;
import com.anjieyang.uooj.dao.msg.AdminSysNoticeEntityService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class AdminSysNoticeEntityServiceImpl extends ServiceImpl<AdminSysNoticeMapper, AdminSysNotice> implements AdminSysNoticeEntityService {

    @Resource
    private AdminSysNoticeMapper adminSysNoticeMapper;

    @Override
    public IPage<AdminSysNoticeVO> getSysNotice(int limit, int currentPage, String type) {
        Page<AdminSysNoticeVO> page = new Page<>(currentPage, limit);
        return adminSysNoticeMapper.getAdminSysNotice(page, type);
    }
}