package com.anjieyang.uooj.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.problem.ProblemCount;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface ProblemCountEntityService extends IService<ProblemCount> {

    void updateCount(int status, Long pid);

}
