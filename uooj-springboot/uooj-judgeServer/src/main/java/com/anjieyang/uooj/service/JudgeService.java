package com.anjieyang.uooj.service;

import com.anjieyang.uooj.common.exception.SystemError;
import com.anjieyang.uooj.pojo.dto.TestJudgeReq;
import com.anjieyang.uooj.pojo.dto.TestJudgeRes;
import com.anjieyang.uooj.pojo.entity.judge.Judge;
import com.anjieyang.uooj.pojo.dto.ToJudgeDTO;

import java.util.HashMap;

public interface JudgeService {

    public void judge(Judge judge);

    public TestJudgeRes testJudge(TestJudgeReq testJudgeReq);

    public void remoteJudge(ToJudgeDTO toJudgeDTO);

    public Boolean compileSpj(String code, Long pid, String spjLanguage, HashMap<String, String> extraFiles) throws SystemError;

    public Boolean compileInteractive(String code, Long pid, String interactiveLanguage, HashMap<String, String> extraFiles) throws SystemError;

}
