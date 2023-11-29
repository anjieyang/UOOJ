package com.anjieyang.uooj.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.judge.JudgeServer;

import java.util.HashMap;

public interface JudgeServerEntityService extends IService<JudgeServer> {

    public HashMap<String, Object> getJudgeServerInfo();
}
