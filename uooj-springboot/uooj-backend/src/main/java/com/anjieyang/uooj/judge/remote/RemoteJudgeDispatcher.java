package com.anjieyang.uooj.judge.remote;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.anjieyang.uooj.utils.Constants;
import com.anjieyang.uooj.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import com.anjieyang.uooj.dao.judge.JudgeEntityService;
import com.anjieyang.uooj.pojo.entity.judge.Judge;


@Component
@Slf4j(topic = "uooj")
@RefreshScope
public class RemoteJudgeDispatcher {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private JudgeEntityService judgeEntityService;

    @Autowired
    private RemoteJudgeReceiver remoteJudgeReceiver;

    @Value("${uooj.judge.token}")
    private String judgeToken;

    public void sendTask(Long judgeId, Long pid, String remoteJudgeProblem, Boolean isContest, Boolean isHasSubmitIdRemoteReJudge) {
        JSONObject task = new JSONObject();
        task.set("judgeId", judgeId);
        task.set("remoteJudgeProblem", remoteJudgeProblem);
        task.set("token", judgeToken);
        task.set("isContest", isContest);
        task.set("isHasSubmitIdRemoteReJudge", isHasSubmitIdRemoteReJudge);
        try {
            boolean isOk;
            if (isContest) {
                isOk = redisUtils.llPush(Constants.Queue.CONTEST_REMOTE_JUDGE_WAITING_HANDLE.getName(), JSONUtil.toJsonStr(task));
            } else {
                isOk = redisUtils.llPush(Constants.Queue.GENERAL_REMOTE_JUDGE_WAITING_HANDLE.getName(), JSONUtil.toJsonStr(task));
            }
            if (!isOk) {
                judgeEntityService.updateById(new Judge()
                        .setSubmitId(judgeId)
                        .setStatus(Constants.Judge.STATUS_SUBMITTED_FAILED.getStatus())
                        .setErrorMessage("Call Redis to push task error. Please try to submit again!")
                );
            }
            remoteJudgeReceiver.processWaitingTask();
        } catch (Exception e) {
            log.error("调用redis将判题纳入判题等待队列异常,此次判题任务判为系统错误--------------->", e);
            judgeEntityService.failToUseRedisPublishJudge(judgeId, pid, isContest);
        }
    }
}
