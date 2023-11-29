package com.anjieyang.uooj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ContestRankDTO;
import com.anjieyang.uooj.pojo.vo.ContestOutsideInfoVO;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface ContestScoreboardService {

    public CommonResult<ContestOutsideInfoVO> getContestOutsideInfo(Long cid);

    public CommonResult<IPage> getContestOutsideScoreboard(ContestRankDTO contestRankDto);

}