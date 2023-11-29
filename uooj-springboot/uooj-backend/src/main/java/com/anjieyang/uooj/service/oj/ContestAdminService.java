package com.anjieyang.uooj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.CheckACDTO;
import com.anjieyang.uooj.pojo.entity.contest.ContestPrint;
import com.anjieyang.uooj.pojo.entity.contest.ContestRecord;

public interface ContestAdminService {

    public CommonResult<IPage<ContestRecord>> getContestACInfo(Long cid, Integer currentPage, Integer limit);

    public CommonResult<Void> checkContestACInfo(CheckACDTO checkACDto);

    public CommonResult<IPage<ContestPrint>> getContestPrint(Long cid, Integer currentPage, Integer limit);

    public CommonResult<Void> checkContestPrintStatus(Long id, Long cid);
}
