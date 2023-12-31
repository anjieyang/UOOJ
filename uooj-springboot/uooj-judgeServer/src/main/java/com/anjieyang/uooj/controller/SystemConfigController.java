package com.anjieyang.uooj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anjieyang.uooj.service.SystemConfigService;

import java.util.HashMap;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@RestController
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @RequestMapping("/get-sys-config")
    public HashMap<String,Object> getSystemConfig(){
        return systemConfigService.getSystemConfig();
    }
}