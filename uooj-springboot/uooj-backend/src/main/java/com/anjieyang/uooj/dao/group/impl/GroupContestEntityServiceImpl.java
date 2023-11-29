package com.anjieyang.uooj.dao.group.impl;

import com.anjieyang.uooj.dao.group.GroupContestEntityService;
import com.anjieyang.uooj.mapper.GroupContestMapper;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.vo.ContestVO;
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
public class GroupContestEntityServiceImpl extends ServiceImpl<GroupContestMapper, Contest> implements GroupContestEntityService {

    @Autowired
    private GroupContestMapper groupContestMapper;

    @Override
    public IPage<ContestVO> getContestList(int limit, int currentPage, Long gid) {
        IPage<ContestVO> iPage = new Page<>(currentPage, limit);

        List<ContestVO> contestList = groupContestMapper.getContestList(iPage, gid);

        return iPage.setRecords(contestList);
    }

    @Override
    public IPage<Contest> getAdminContestList(int limit, int currentPage, Long gid) {
        IPage<Contest> iPage = new Page<>(currentPage, limit);

        List<Contest> contestList = groupContestMapper.getAdminContestList(iPage, gid);

        return iPage.setRecords(contestList);
    }
}
