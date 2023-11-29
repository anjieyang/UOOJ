package com.anjieyang.uooj.service.oj;

import com.anjieyang.uooj.pojo.vo.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface HomeService {

    public CommonResult<List<ContestVO>> getRecentContest();

    public CommonResult<List<HashMap<String, Object>>> getHomeCarousel();

    public CommonResult<List<ACMRankVO>> getRecentSevenACRank();

    @Deprecated
    public CommonResult<List<HashMap<String, Object>>> getRecentOtherContest();

    public CommonResult<IPage<AnnouncementVO>> getCommonAnnouncement(Integer limit, Integer currentPage);

    public CommonResult<Map<Object, Object>> getWebConfig();

    public CommonResult<List<RecentUpdatedProblemVO>> getRecentUpdatedProblemList();

    public CommonResult<SubmissionStatisticsVO> getLastWeekSubmissionStatistics(Boolean forceRefresh);
}