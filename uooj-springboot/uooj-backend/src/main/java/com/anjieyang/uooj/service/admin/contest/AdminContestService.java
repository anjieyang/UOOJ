package com.anjieyang.uooj.service.admin.contest;

;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.vo.AdminContestVO;


public interface AdminContestService {

    public CommonResult<IPage<Contest>> getContestList(Integer limit, Integer currentPage, String keyword);

    public CommonResult<AdminContestVO> getContest(Long cid);

    public CommonResult<Void> deleteContest(Long cid);

    public CommonResult<Void> addContest(AdminContestVO adminContestVo);

    public CommonResult<Void> cloneContest(Long cid);

    public CommonResult<Void> updateContest(AdminContestVO adminContestVo);

    public CommonResult<Void> changeContestVisible(Long cid, String uid, Boolean visible);

}
