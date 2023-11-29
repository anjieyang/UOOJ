package com.anjieyang.uooj.config;

import lombok.Data;
import com.anjieyang.uooj.utils.IpUtils;

/**
 * @Author Anjie Yang
 * @Date 2022/10/26
 */
@Data
public class WebConfig {

    // 邮箱配置
    private String emailUsername;

    private String emailPassword;

    private String emailHost;

    private Integer emailPort;

    private Boolean emailSsl = true;

    private String emailBGImg = "example.png";

    // 网站前端显示配置
    private String baseUrl = "http://" + IpUtils.getServiceIp();

    private String name = "University of Ottawa Online Judge";

    private String shortName = "UOOJ";

    private String description;

    private Boolean register = true;

    private String recordName;

    private String recordUrl;

    private String projectName = "UOOJ";

    private String projectUrl = "https://github.com/anjieyang";
}
