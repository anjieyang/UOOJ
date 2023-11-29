package com.anjieyang.uooj.controller.admin;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.user.Session;
import com.anjieyang.uooj.service.admin.system.DashboardService;


import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@RestController
@RequestMapping("/api/admin/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @PostMapping("/get-sessions")
    @RequiresAuthentication
    @RequiresRoles(value = {"root","admin","problem_admin"},logical = Logical.OR)
    public CommonResult<Session> getRecentSession(){

        return dashboardService.getRecentSession();
    }

    @GetMapping("/get-dashboard-info")
    @RequiresAuthentication
    @RequiresRoles(value = {"root","admin","problem_admin"},logical = Logical.OR)
    public CommonResult<Map<Object,Object>> getDashboardInfo(){

        return dashboardService.getDashboardInfo();
    }
}