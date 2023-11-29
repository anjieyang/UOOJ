package com.anjieyang.uooj.dao.discussion.impl;

import com.anjieyang.uooj.mapper.DiscussionReportMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.dao.discussion.DiscussionReportEntityService;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionReport;
import com.anjieyang.uooj.pojo.vo.DiscussionReportVO;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class DiscussionReportEntityServiceImpl extends ServiceImpl<DiscussionReportMapper, DiscussionReport> implements DiscussionReportEntityService {

    @Resource
    private DiscussionReportMapper discussionReportMapper;

    @Override
    public IPage<DiscussionReportVO> getDiscussionReportList(Integer limit, Integer currentPage) {
        Page<DiscussionReportVO> page = new Page<>(currentPage, limit);
        return discussionReportMapper.getDiscussionReportList(page);
    }
}