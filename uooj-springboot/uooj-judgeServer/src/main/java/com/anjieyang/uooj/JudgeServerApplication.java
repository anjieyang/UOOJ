package com.anjieyang.uooj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 判题机服务系统启动类
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync(proxyTargetClass=true) //开启异步注解
@EnableTransactionManagement
@EnableRetry
public class JudgeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JudgeServerApplication.class,args);
        System.out.println("start end...");
    }
}