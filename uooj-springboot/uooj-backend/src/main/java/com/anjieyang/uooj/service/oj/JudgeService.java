package com.anjieyang.uooj.service.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.SubmitIdListDTO;
import com.anjieyang.uooj.pojo.dto.SubmitJudgeDTO;
import com.anjieyang.uooj.pojo.dto.TestJudgeDTO;
import com.anjieyang.uooj.pojo.entity.judge.Judge;
import com.anjieyang.uooj.pojo.vo.JudgeCaseVO;
import com.anjieyang.uooj.pojo.vo.JudgeVO;
import com.anjieyang.uooj.pojo.vo.SubmissionInfoVO;
import com.anjieyang.uooj.pojo.vo.TestJudgeVO;

import java.util.HashMap;

public interface JudgeService {

    public CommonResult<Judge> submitProblemJudge(SubmitJudgeDTO judgeDto);

    public CommonResult<String> submitProblemTestJudge(TestJudgeDTO testJudgeDto);

    public CommonResult<Judge> resubmit(Long submitId);

    public CommonResult<SubmissionInfoVO> getSubmission(Long submitId);

    public CommonResult<TestJudgeVO> getTestJudgeResult(String testJudgeKey);

    public CommonResult<IPage<JudgeVO>> getJudgeList(Integer limit,
                                                     Integer currentPage,
                                                     Boolean onlyMine,
                                                     String searchPid,
                                                     Integer searchStatus,
                                                     String searchUsername,
                                                     Boolean completeProblemID,
                                                     Long gid);

    public CommonResult<Void> updateSubmission(Judge judge);

    public CommonResult<HashMap<Long, Object>> checkCommonJudgeResult(SubmitIdListDTO submitIdListDto);

    public CommonResult<HashMap<Long, Object>> checkContestJudgeResult(SubmitIdListDTO submitIdListDto);

    public CommonResult<JudgeCaseVO> getALLCaseResult(Long submitId);
}
