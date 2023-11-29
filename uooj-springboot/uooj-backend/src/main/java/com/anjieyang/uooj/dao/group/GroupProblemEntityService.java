package com.anjieyang.uooj.dao.group;

import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupProblemEntityService extends IService<Problem> {

    IPage<ProblemVO> getProblemList(int limit, int currentPage, Long gid);

    IPage<Problem> getAdminProblemList(int limit, int currentPage, Long gid);

}
