package com.anjieyang.uooj.dao.contest.impl;

import com.anjieyang.uooj.mapper.ContestPrintMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.anjieyang.uooj.pojo.entity.contest.ContestPrint;
import com.anjieyang.uooj.dao.contest.ContestPrintEntityService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ContestPrintEntityServiceImpl extends ServiceImpl<ContestPrintMapper, ContestPrint> implements ContestPrintEntityService {
}