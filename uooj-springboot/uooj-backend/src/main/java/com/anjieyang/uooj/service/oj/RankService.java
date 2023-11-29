package com.anjieyang.uooj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;

public interface RankService {

    public CommonResult<IPage> getRankList(Integer limit, Integer currentPage, String searchUser, Integer type);
}
