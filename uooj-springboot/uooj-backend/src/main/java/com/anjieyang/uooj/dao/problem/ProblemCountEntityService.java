package com.anjieyang.uooj.dao.problem;

import com.anjieyang.uooj.pojo.entity.problem.ProblemCount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface ProblemCountEntityService extends IService<ProblemCount> {
    ProblemCount getContestProblemCount(Long pid, Long cpid, Long cid);
}
