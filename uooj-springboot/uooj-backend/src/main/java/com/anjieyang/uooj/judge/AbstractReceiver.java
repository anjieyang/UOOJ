package com.anjieyang.uooj.judge;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

public abstract class AbstractReceiver {

    public void handleWaitingTask(String... queues) {
        for (String queue : queues) {
            String taskStr = getTaskByRedis(queue);
            if (taskStr != null) {
                handleJudgeMsg(taskStr, queue);
            }
        }
    }

    public abstract String getTaskByRedis(String queue);

    public abstract void handleJudgeMsg(String taskStr, String queueName);

}