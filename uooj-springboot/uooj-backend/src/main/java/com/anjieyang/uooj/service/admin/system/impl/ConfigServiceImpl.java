package com.anjieyang.uooj.service.admin.system.impl;

import cn.hutool.json.JSONObject;
import com.anjieyang.uooj.pojo.dto.*;
import com.anjieyang.uooj.service.admin.system.ConfigService;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.system.ConfigManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigManager configManager;

    @Override
    public CommonResult<JSONObject> getServiceInfo() {
        return CommonResult.successResponse(configManager.getServiceInfo());
    }

    @Override
    public CommonResult<List<JSONObject>> getJudgeServiceInfo() {
        return CommonResult.successResponse(configManager.getJudgeServiceInfo());
    }

    @Override
    public CommonResult<Void> deleteHomeCarousel(Long id) {
        try {
            configManager.deleteHomeCarousel(id);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<WebConfigDTO> getWebConfig() {
        return CommonResult.successResponse(configManager.getWebConfig());
    }

    @Override
    public CommonResult<Void> setWebConfig(WebConfigDTO config) {
        try {
            configManager.setWebConfig(config);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<EmailConfigDTO> getEmailConfig() {
        return CommonResult.successResponse(configManager.getEmailConfig());
    }

    @Override
    public CommonResult<Void> setEmailConfig(EmailConfigDTO config) {
        try {
            configManager.setEmailConfig(config);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> testEmail(TestEmailDTO testEmailDto) {
        try {
            configManager.testEmail(testEmailDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<DBAndRedisConfigDTO> getDBAndRedisConfig() {
        return CommonResult.successResponse(configManager.getDBAndRedisConfig());
    }

    @Override
    public CommonResult<Void> setDBAndRedisConfig(DBAndRedisConfigDTO config) {
        try {
            configManager.setDBAndRedisConfig(config);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<SwitchConfigDTO> getSwitchConfig() {
        return CommonResult.successResponse(configManager.getSwitchConfig());
    }

    @Override
    public CommonResult<Void> setSwitchConfig(SwitchConfigDTO config) {
        try {
            configManager.setSwitchConfig(config);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}