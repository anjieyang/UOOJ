package com.anjieyang.uooj.service.oj;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardInfoVO;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardSubmissionVO;

import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/10/3
 */
public interface ContestScrollBoardService {

    public CommonResult<ContestScrollBoardInfoVO> getContestScrollBoardInfo(Long cid);

    public CommonResult<List<ContestScrollBoardSubmissionVO>> getContestScrollBoardSubmission(Long cid, Boolean removeStar);
}
