package com.anjieyang.uooj.service.oj;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.LastAcceptedCodeVO;
import com.anjieyang.uooj.pojo.dto.PidListDTO;
import com.anjieyang.uooj.pojo.vo.ProblemFullScreenListVO;
import com.anjieyang.uooj.pojo.vo.ProblemInfoVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.vo.RandomProblemVO;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface ProblemService {

    public CommonResult<Page<ProblemVO>> getProblemList(Integer limit, Integer currentPage,
                                                        String keyword, List<Long> tagId, Integer difficulty, String oj);

    public CommonResult<RandomProblemVO> getRandomProblem();

    public CommonResult<HashMap<Long, Object>> getUserProblemStatus(PidListDTO pidListDto);

    public CommonResult<ProblemInfoVO> getProblemInfo(String problemId, Long gid);

    public CommonResult<LastAcceptedCodeVO> getUserLastAcceptedCode(Long pid, Long cid);

    public CommonResult<List<ProblemFullScreenListVO>> getFullScreenProblemList(Long tid, Long cid);

}