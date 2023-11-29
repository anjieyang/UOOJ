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
@ConfigurationProperties(prefix = "uooj.db")
@Data
public class DataSourceConfigure {

    private String username;

    private String password;

    private String host;

    private Integer port;

    private String name;
}
