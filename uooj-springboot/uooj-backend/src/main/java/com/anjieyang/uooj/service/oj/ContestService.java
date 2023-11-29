package com.anjieyang.uooj.service.oj;

import com.anjieyang.uooj.pojo.vo.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ContestPrintDTO;
import com.anjieyang.uooj.pojo.dto.ContestRankDTO;
import com.anjieyang.uooj.pojo.dto.RegisterContestDTO;
import com.anjieyang.uooj.pojo.dto.UserReadContestAnnouncementDTO;
import com.anjieyang.uooj.pojo.entity.common.Announcement;

import java.util.List;

public interface ContestService {

    public CommonResult<IPage<ContestVO>> getContestList(Integer limit, Integer currentPage, Integer status, Integer type, String keyword);

    public CommonResult<ContestVO> getContestInfo(Long cid);

    public CommonResult<Void> toRegisterContest(RegisterContestDTO registerContestDto);

    public CommonResult<AccessVO> getContestAccess(Long cid);

    public CommonResult<List<ContestProblemVO>> getContestProblem(Long cid, Boolean isContainsContestEndJudge);

    public CommonResult<ProblemInfoVO> getContestProblemDetails(Long cid, String displayId, Boolean isContainsContestEndJudge);

    public CommonResult<IPage<JudgeVO>> getContestSubmissionList(Integer limit,
                                                                 Integer currentPage,
                                                                 Boolean onlyMine,
                                                                 String displayId,
                                                                 Integer searchStatus,
                                                                 String searchUsername,
                                                                 Long searchCid,
                                                                 Boolean beforeContestSubmit,
                                                                 Boolean completeProblemID,
                                                                 Boolean isContainsContestEndJudge);

    public CommonResult<IPage> getContestRank(ContestRankDTO contestRankDto);

    public CommonResult<IPage<AnnouncementVO>> getContestAnnouncement(Long cid, Integer limit, Integer currentPage);

    public CommonResult<List<Announcement>> getContestUserNotReadAnnouncement(UserReadContestAnnouncementDTO userReadContestAnnouncementDto);

    public CommonResult<Void> submitPrintText(ContestPrintDTO contestPrintDto);

}
