package com.anjieyang.uooj.config;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.anjieyang.uooj.dao.JudgeServerEntityService;
import com.anjieyang.uooj.pojo.entity.judge.JudgeServer;
import com.anjieyang.uooj.util.IpUtils;

import java.util.HashMap;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:项目启动加载类，启动完毕将该判题机加入到redis里面
 */
@Component
@Slf4j
public class StartupRunner implements CommandLineRunner {

    @Value("${uooj-judge-server.max-task-num}")
    private Integer maxTaskNum;

    @Value("${uooj-judge-server.remote-judge.max-task-num}")
    private Integer maxRemoteTaskNum;

    @Value("${uooj-judge-server.remote-judge.open}")
    private Boolean openRemoteJudge;

    @Value("${uooj-judge-server.name}")
    private String name;

    @Value("${uooj-judge-server.ip}")
    private String ip;

    @Value("${uooj-judge-server.port}")
    private Integer port;

    private static final int cpuNum = Runtime.getRuntime().availableProcessors();

    @Autowired
    private JudgeServerEntityService judgeServerEntityService;

    @Override
    @Transactional
    public void run(String... args) {

        log.info("IP  of the current judge server:" + ip);
        log.info("Port of the current judge server:" + port);

        if (maxTaskNum == -1) {
            maxTaskNum = cpuNum + 1;
        }
        if (ip.equals("-1")) {
            ip = IpUtils.getLocalIpv4Address();
        }
        UpdateWrapper<JudgeServer> judgeServerQueryWrapper = new UpdateWrapper<>();
        judgeServerQueryWrapper.eq("ip", ip).eq("port", port);
        judgeServerEntityService.remove(judgeServerQueryWrapper);
        boolean isOk1 = judgeServerEntityService.save(new JudgeServer()
                .setCpuCore(cpuNum)
                .setIp(ip)
                .setPort(port)
                .setUrl(ip + ":" + port)
                .setMaxTaskNumber(maxTaskNum)
                .setIsRemote(false)
                .setName(name));
        boolean isOk2 = true;
        if (openRemoteJudge) {
            if (maxRemoteTaskNum == -1) {
                maxRemoteTaskNum = cpuNum * 2 + 1;
            }
            isOk2 = judgeServerEntityService.save(new JudgeServer()
                    .setCpuCore(cpuNum)
                    .setIp(ip)
                    .setPort(port)
                    .setUrl(ip + ":" + port)
                    .setMaxTaskNumber(maxRemoteTaskNum)
                    .setIsRemote(true)
                    .setName(name));
        }

        if (!isOk1 || !isOk2) {
            log.error("初始化判题机信息到数据库失败，请重新启动试试！");
        } else {
            HashMap<String, Object> judgeServerInfo = judgeServerEntityService.getJudgeServerInfo();
            log.info("UOOJ-JudgeServer had successfully started! The judge config and sandbox config Info:" + judgeServerInfo);
        }

    }

}