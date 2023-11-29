package com.anjieyang.uooj.service.group.contest;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ContestProblemDTO;
import com.anjieyang.uooj.pojo.dto.ProblemDTO;
import com.anjieyang.uooj.pojo.entity.contest.ContestProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupContestProblemService {

    public CommonResult<HashMap<String, Object>> getContestProblemList(Integer limit, Integer currentPage, String keyword, Long cid, Integer problemType, String oj);

    public CommonResult<Map<Object, Object>> addProblem(ProblemDTO problemDto);

    public CommonResult<ContestProblem> getContestProblem(Long pid, Long cid);

    public CommonResult<Void> updateContestProblem(ContestProblem contestProblem);

    public CommonResult<Void> deleteContestProblem(Long pid, Long cid);

    public CommonResult<Void> addProblemFromPublic(ContestProblemDTO contestProblemDto);

    public CommonResult<Void> addProblemFromGroup(String problemId, Long cid, String displayId);

}
