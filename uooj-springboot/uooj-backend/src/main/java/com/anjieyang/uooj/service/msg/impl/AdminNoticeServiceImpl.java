package com.anjieyang.uooj.service.msg.impl;

import com.anjieyang.uooj.service.msg.AdminNoticeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.msg.AdminNoticeManager;
import com.anjieyang.uooj.pojo.entity.msg.AdminSysNotice;
import com.anjieyang.uooj.pojo.vo.AdminSysNoticeVO;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {

    @Resource
    private AdminNoticeManager adminNoticeManager;

    @Override
    public CommonResult<IPage<AdminSysNoticeVO>> getSysNotice(Integer limit, Integer currentPage, String type) {

        return CommonResult.successResponse(adminNoticeManager.getSysNotice(limit, currentPage, type));
    }

    @Override
    public CommonResult<Void> addSysNotice(AdminSysNotice adminSysNotice) {
        try {
            adminNoticeManager.addSysNotice(adminSysNotice);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> deleteSysNotice(Long id) {
        try {
            adminNoticeManager.deleteSysNotice(id);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateSysNotice(AdminSysNotice adminSysNotice) {
        try {
            adminNoticeManager.updateSysNotice(adminSysNotice);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}