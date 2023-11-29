package com.anjieyang.uooj.service.admin.problem;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ProblemDTO;
import com.anjieyang.uooj.pojo.dto.CompileDTO;
import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.pojo.entity.problem.ProblemCase;
import java.util.List;


public interface AdminProblemService {

    public CommonResult<IPage<Problem>> getProblemList(Integer limit, Integer currentPage, String keyword, Integer auth, String oj);

    public CommonResult<Problem> getProblem(Long pid);

    public CommonResult<Void> deleteProblem(Long pid);

    public CommonResult<Void> addProblem(ProblemDTO problemDto);

    public CommonResult<Void> updateProblem(ProblemDTO problemDto);

    public CommonResult<List<ProblemCase>> getProblemCases(Long pid, Boolean isUpload);

    public CommonResult compileSpj(CompileDTO compileDTO);

    public CommonResult compileInteractive(CompileDTO compileDTO);

    public CommonResult<Void> importRemoteOJProblem(String name,String problemId);

    public CommonResult<Void> changeProblemAuth(Problem problem);
}
