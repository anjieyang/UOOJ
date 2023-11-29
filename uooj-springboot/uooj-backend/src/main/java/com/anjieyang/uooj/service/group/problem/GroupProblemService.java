package com.anjieyang.uooj.service.group.problem;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ProblemDTO;
import com.anjieyang.uooj.pojo.dto.CompileDTO;
import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.pojo.entity.problem.ProblemCase;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupProblemService {

    public CommonResult<IPage<ProblemVO>> getProblemList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<IPage<Problem>> getAdminProblemList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<Problem> getProblem(Long pid);

    public CommonResult<Void> addProblem(ProblemDTO problemDto);

    public CommonResult<Void> updateProblem(ProblemDTO problemDto);

    public CommonResult<Void> deleteProblem(Long pid);

    public CommonResult<List<ProblemCase>> getProblemCases(Long pid, Boolean isUpload);

    public CommonResult<List<Tag>> getAllProblemTagsList(Long gid);

    public CommonResult<Void> compileSpj(CompileDTO compileDTO, Long gid);

    public CommonResult<Void> compileInteractive(CompileDTO compileDTO, Long gid);

    public CommonResult<Void> changeProblemAuth(Long pid, Integer auth);

    public CommonResult<Void> applyPublic(Long pid, Boolean isApplied);
}
