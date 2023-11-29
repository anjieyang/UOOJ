package com.anjieyang.uooj.dao.judge.impl;

import com.anjieyang.uooj.mapper.RemoteJudgeAccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.judge.RemoteJudgeAccount;
import com.anjieyang.uooj.dao.judge.RemoteJudgeAccountEntityService;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class RemoteJudgeAccountEntityServiceImpl extends ServiceImpl<RemoteJudgeAccountMapper, RemoteJudgeAccount> implements RemoteJudgeAccountEntityService {
}