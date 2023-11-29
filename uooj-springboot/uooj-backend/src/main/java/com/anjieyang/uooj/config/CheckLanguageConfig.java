package com.anjieyang.uooj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.anjieyang.uooj.pojo.entity.problem.Language;

import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2023/7/8
 */
@Configuration
@ConfigurationProperties(prefix = "check-language-config")
@Data
public class CheckLanguageConfig {

    private List<Language> list;

    @Override
    public String toString() {
        return "AntPoolConfigList{" +
                "list=" + list +
                '}';
    }
}
