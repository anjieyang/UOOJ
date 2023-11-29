package com.anjieyang.uooj.dao.impl;

import com.anjieyang.uooj.mapper.ContestMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;;

import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.dao.ContestEntityService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class ContestEntityServiceImpl extends ServiceImpl<ContestMapper, Contest> implements ContestEntityService {

}
