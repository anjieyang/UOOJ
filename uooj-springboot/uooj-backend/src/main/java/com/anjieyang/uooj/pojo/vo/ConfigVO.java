package com.anjieyang.uooj.pojo.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@RefreshScope
@Data
@Component
public class ConfigVO {
    // 数据库配置
    @Value("${mysql-username}")
    private String mysqlUsername;

    @Value("${mysql-password}")
    private String mysqlPassword;

    @Value("${mysql-name}")
    private String mysqlDBName;

    @Value("${mysql-host}")
    private String mysqlHost;

    @Value("${mysql-public-host:127.0.0.1}")
    private String mysqlPublicHost;

    @Value("${mysql-port:3306}")
    private Integer mysqlPort;

    @Value("${mysql-public-port:3306}")
    private Integer mysqlPublicPort;

    // 判题服务token
    @Value("${judge-token}")
    private String judgeToken;

    // 缓存配置
    @Value("${redis-host}")
    private String redisHost;

    @Value("${redis-port}")
    private Integer redisPort;

    @Value("${redis-password}")
    private String redisPassword;

    // jwt配置
    @Value("${jwt-token-secret}")
    private String tokenSecret;

    @Value("${jwt-token-expire}")
    private String tokenExpire;

    @Value("${jwt-token-fresh-expire}")
    private String checkRefreshExpire;
}
