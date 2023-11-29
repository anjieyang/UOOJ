package com.anjieyang.uooj.service;

public interface RemoteJudgeService {

    public void changeAccountStatus(String remoteJudge, String username);

    public void changeServerSubmitCFStatus(String ip, Integer port);
}
