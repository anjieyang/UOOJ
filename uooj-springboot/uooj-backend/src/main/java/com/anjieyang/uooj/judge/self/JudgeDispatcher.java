package com.anjieyang.uooj.judge.self;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.utils.Constants;
import com.anjieyang.uooj.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import com.anjieyang.uooj.dao.judge.JudgeEntityService;
import com.anjieyang.uooj.pojo.dto.TestJudgeReq;
import com.anjieyang.uooj.pojo.entity.judge.Judge;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Component
@Slf4j(topic = "uooj")
@RefreshScope
public class JudgeDispatcher {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private JudgeEntityService judgeEntityService;

    @Autowired
    private JudgeReceiver judgeReceiver;

    @Value("${uooj.judge.token}")
    private String judgeToken;

    public void sendTask(Long judgeId, Long pid, Boolean isContest) {
        JSONObject task = new JSONObject();
        task.set("judgeId", judgeId);
        task.set("token", judgeToken);
        task.set("isContest", isContest);
        try {
            boolean isOk;
            if (isContest) {
                isOk = redisUtils.llPush(Constants.Queue.CONTEST_JUDGE_WAITING.getName(), JSONUtil.toJsonStr(task));
            } else {
                isOk = redisUtils.llPush(Constants.Queue.GENERAL_JUDGE_WAITING.getName(), JSONUtil.toJsonStr(task));
            }
            if (!isOk) {
                judgeEntityService.updateById(new Judge()
                        .setSubmitId(judgeId)
                        .setStatus(Constants.Judge.STATUS_SUBMITTED_FAILED.getStatus())
                        .setErrorMessage("Call Redis to push task error. Please try to submit again!")
                );
            }
            // 调用判题任务处理
            judgeReceiver.processWaitingTask();
        } catch (Exception e) {
            log.error("调用redis将判题纳入判题等待队列异常--------------->{}", e.getMessage());
            judgeEntityService.failToUseRedisPublishJudge(judgeId, pid, isContest);
        }
    }

    public void sendTestJudgeTask(TestJudgeReq testJudgeReq) throws StatusSystemErrorException {
        testJudgeReq.setToken(judgeToken);
        try {
            boolean isOk = redisUtils.llPush(Constants.Queue.TEST_JUDGE_WAITING.getName(), JSONUtil.toJsonStr(testJudgeReq));
            if (!isOk) {
                throw new StatusSystemErrorException("系统错误：当前评测任务进入等待队列失败！");
            }
            // 调用判题任务处理
            judgeReceiver.processWaitingTask();
        } catch (Exception e) {
            log.error("调用redis将判题纳入判题等待队列异常--------------->{}", e.getMessage());
            throw new StatusSystemErrorException("系统错误：当前评测任务进入等待队列失败！");
        }
    }
}