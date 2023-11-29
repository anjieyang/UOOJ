package com.anjieyang.uooj.service.admin.system;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.user.Session;

import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface DashboardService {

    public CommonResult<Session> getRecentSession();

    public CommonResult<Map<Object,Object>> getDashboardInfo();
}