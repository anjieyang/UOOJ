package com.anjieyang.uooj.service.admin.problem;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ChangeGroupProblemProgressDTO;
import com.anjieyang.uooj.pojo.entity.problem.Problem;

/**
 * @Author Anjie Yang
 * @Date 2022/4/13
 */
public interface AdminGroupProblemService {

    public CommonResult<IPage<Problem>> getProblemList(Integer currentPage, Integer limit, String keyword, Long gid);

    public CommonResult<Void> changeProgress(ChangeGroupProblemProgressDTO changeGroupProblemProgressDto);
}
