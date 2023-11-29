package com.anjieyang.uooj.service.msg.impl;

import com.anjieyang.uooj.service.msg.NoticeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.msg.NoticeManager;
import com.anjieyang.uooj.pojo.vo.SysMsgVO;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeManager noticeManager;

    @Override
    public CommonResult<IPage<SysMsgVO>> getSysNotice(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(noticeManager.getSysNotice(limit, currentPage));
    }

    @Override
    public CommonResult<IPage<SysMsgVO>> getMineNotice(Integer limit, Integer currentPage) {
        return CommonResult.successResponse(noticeManager.getMineNotice(limit, currentPage));
    }
}