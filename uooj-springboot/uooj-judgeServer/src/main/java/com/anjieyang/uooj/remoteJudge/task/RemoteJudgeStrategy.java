package com.anjieyang.uooj.remoteJudge.task;

import com.anjieyang.uooj.remoteJudge.entity.RemoteJudgeDTO;
import com.anjieyang.uooj.remoteJudge.entity.RemoteJudgeRes;
import lombok.Getter;
import lombok.Setter;


/**
 * 远程评测抽象类
 */
public abstract class RemoteJudgeStrategy {

    @Setter
    @Getter
    private RemoteJudgeDTO remoteJudgeDTO;

    public abstract void submit();

    public abstract RemoteJudgeRes result();

    public abstract void login();

    public abstract String getLanguage(String language);

}
