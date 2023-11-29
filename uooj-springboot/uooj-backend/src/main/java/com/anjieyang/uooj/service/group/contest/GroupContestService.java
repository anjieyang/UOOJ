package com.anjieyang.uooj.service.group.contest;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.vo.AdminContestVO;
import com.anjieyang.uooj.pojo.vo.ContestVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupContestService {

    public CommonResult<IPage<ContestVO>> getContestList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<IPage<Contest>> getAdminContestList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<AdminContestVO> getContest(Long cid);

    public CommonResult<Void> addContest(AdminContestVO adminContestVo);

    public CommonResult<Void> updateContest(AdminContestVO adminContestVo);

    public CommonResult<Void> deleteContest(Long cid);

    public CommonResult<Void> changeContestVisible(Long cid, Boolean visible);

}
