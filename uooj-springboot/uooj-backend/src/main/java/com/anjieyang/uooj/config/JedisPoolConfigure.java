package com.anjieyang.uooj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author Anjie Yang
 * @Date 2022/6/15
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "uooj.redis")
@Data
public class JedisPoolConfigure {
    private String host;

    private Integer port;

    private String password;
}
