package com.anjieyang.uooj.dao.group.impl;

import com.anjieyang.uooj.mapper.GroupProblemMapper;
import com.anjieyang.uooj.dao.group.GroupProblemEntityService;
import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupProblemEntityServiceImpl extends ServiceImpl<GroupProblemMapper, Problem> implements GroupProblemEntityService {

    @Autowired
    private GroupProblemMapper groupProblemMapper;

    @Override
    public IPage<ProblemVO> getProblemList(int limit, int currentPage, Long gid) {
        IPage<ProblemVO> iPage = new Page<>(currentPage, limit);

        List<ProblemVO> problemList = groupProblemMapper.getProblemList(iPage, gid);

        return iPage.setRecords(problemList);
    }

    @Override
    public IPage<Problem> getAdminProblemList(int limit, int currentPage, Long gid) {
        IPage<Problem> iPage = new Page<>(currentPage, limit);

        List<Problem> problemList = groupProblemMapper.getAdminProblemList(iPage, gid);

        return iPage.setRecords(problemList);
    }

}
