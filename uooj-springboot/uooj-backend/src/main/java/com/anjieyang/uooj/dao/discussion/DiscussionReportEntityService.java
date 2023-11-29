package com.anjieyang.uooj.dao.discussion;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionReport;
import com.anjieyang.uooj.pojo.vo.DiscussionReportVO;

public interface DiscussionReportEntityService extends IService<DiscussionReport> {

    IPage<DiscussionReportVO> getDiscussionReportList(Integer limit, Integer currentPage);
}
