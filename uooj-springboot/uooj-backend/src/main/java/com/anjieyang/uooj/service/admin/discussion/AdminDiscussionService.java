package com.anjieyang.uooj.service.admin.discussion;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionReport;
import com.anjieyang.uooj.pojo.vo.DiscussionReportVO;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface AdminDiscussionService {

    public CommonResult<Void> updateDiscussion(Discussion discussion);

    public CommonResult<Void> removeDiscussion(List<Integer> didList);

    public CommonResult<IPage<DiscussionReportVO>> getDiscussionReport(Integer limit, Integer currentPage);

    public CommonResult<Void> updateDiscussionReport(DiscussionReport discussionReport);
}