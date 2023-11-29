package com.anjieyang.uooj.dao.problem.impl;

import com.anjieyang.uooj.mapper.ProblemCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.anjieyang.uooj.pojo.entity.problem.ProblemCount;
import com.anjieyang.uooj.dao.problem.ProblemCountEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class ProblemCountServiceImpl extends ServiceImpl<ProblemCountMapper, ProblemCount> implements ProblemCountEntityService {

    @Autowired
    private ProblemCountMapper problemCountMapper;

    @Override
    public ProblemCount getContestProblemCount(Long pid, Long cpid, Long cid) {
        return problemCountMapper.getContestProblemCount(pid,cpid, cid);
    }
}
