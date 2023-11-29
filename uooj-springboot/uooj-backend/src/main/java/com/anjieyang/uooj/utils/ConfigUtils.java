package com.anjieyang.uooj.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anjieyang.uooj.pojo.vo.ConfigVO;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Component
@Slf4j(topic = "uooj")
public class ConfigUtils {

    @Autowired
    private ConfigVO configVo;

    public String getConfigContent() {
        return buildYamlStr(configVo);
    }

    public String buildYamlStr(ConfigVO configVo) {
        return "uooj:\n" +
                "  jwt:\n" +
                "    # 加密秘钥\n" +
                "    secret: " + configVo.getTokenSecret() + "\n" +
                "    # token有效时长，1天，单位秒\n" +
                "    expire: " + configVo.getTokenExpire() + "\n" +
                "    checkRefreshExpire: " + configVo.getCheckRefreshExpire() + "\n" +
                "    header: token\n" +
                "  judge:\n" +
                "    # 调用判题服务器的token\n" +
                "    token: " + configVo.getJudgeToken() + "\n" +
                "  db:\n" +
                "    host: " + configVo.getMysqlHost() + "\n" +
                "    port: " + configVo.getMysqlPort() + "\n" +
                "    public-host: " + configVo.getMysqlPublicHost() + "\n" +
                "    public-port: " + configVo.getMysqlPublicPort() + "\n" +
                "    name: " + configVo.getMysqlDBName() + "\n" +
                "    username: " + configVo.getMysqlUsername() + "\n" +
                "    password: " + configVo.getMysqlPassword() + "\n" +
                "  redis:\n" +
                "    host: " + configVo.getRedisHost() + "\n" +
                "    port: " + configVo.getRedisPort() + "\n" +
                "    password: " + configVo.getRedisPassword();
    }

}