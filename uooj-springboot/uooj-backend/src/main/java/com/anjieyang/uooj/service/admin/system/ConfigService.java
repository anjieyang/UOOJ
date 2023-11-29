package com.anjieyang.uooj.service.admin.system;

import cn.hutool.json.JSONObject;
import com.anjieyang.uooj.pojo.dto.*;
import com.anjieyang.uooj.common.result.CommonResult;

import java.util.List;

public interface ConfigService {

    public CommonResult<JSONObject> getServiceInfo();

    public CommonResult<List<JSONObject>> getJudgeServiceInfo();

    public CommonResult<Void> deleteHomeCarousel(Long id);

    public CommonResult<WebConfigDTO> getWebConfig();

    public CommonResult<Void> setWebConfig(WebConfigDTO config);

    public CommonResult<EmailConfigDTO> getEmailConfig();

    public CommonResult<Void> setEmailConfig(EmailConfigDTO config);

    public CommonResult<Void> testEmail(TestEmailDTO testEmailDto);

    public CommonResult<DBAndRedisConfigDTO> getDBAndRedisConfig();

    public CommonResult<Void> setDBAndRedisConfig(DBAndRedisConfigDTO config);

    public CommonResult<SwitchConfigDTO> getSwitchConfig();

    public CommonResult<Void> setSwitchConfig(SwitchConfigDTO config);

}
