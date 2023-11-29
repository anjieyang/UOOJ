package com.anjieyang.uooj.service.admin.system.impl;

import com.anjieyang.uooj.service.admin.system.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.system.DashboardManager;
import com.anjieyang.uooj.pojo.entity.user.Session;

import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardManager dashboardManager;

    @Override
    public CommonResult<Session> getRecentSession() {
        return CommonResult.successResponse(dashboardManager.getRecentSession());
    }

    @Override
    public CommonResult<Map<Object, Object>> getDashboardInfo() {
        return CommonResult.successResponse(dashboardManager.getDashboardInfo());
    }
}