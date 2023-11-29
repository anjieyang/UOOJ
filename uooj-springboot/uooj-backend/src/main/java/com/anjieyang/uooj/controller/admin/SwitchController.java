package com.anjieyang.uooj.controller.admin;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.SwitchConfigDTO;
import com.anjieyang.uooj.service.admin.system.ConfigService;

import javax.annotation.Resource;

/**
 * @Author Anjie Yang
 * @Date 2022/5/9
 */
@RestController
@RequestMapping("/api/admin/switch")
public class SwitchController {

    @Resource
    private ConfigService configService;

    @RequiresPermissions("system_info_admin")
    @RequestMapping("/info")
    public CommonResult<SwitchConfigDTO> getSwitchConfig() {

        return configService.getSwitchConfig();
    }

    @RequiresPermissions("system_info_admin")
    @PutMapping("/update")
    public CommonResult<Void> setSwitchConfig(@RequestBody SwitchConfigDTO config) {
        return configService.setSwitchConfig(config);
    }
}
