package com.anjieyang.uooj.service.group.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.group.GroupRankManager;
import com.anjieyang.uooj.pojo.vo.OIRankVO;
import com.anjieyang.uooj.service.group.GroupRankService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupRankServiceImpl implements GroupRankService {

    @Resource
    private GroupRankManager groupRankManager;

    @Override
    public CommonResult<IPage<OIRankVO>> getGroupRankList(Integer limit,
                                                          Integer currentPage,
                                                          String searchUser,
                                                          Integer type,
                                                          Long gid) {
        try {
            return CommonResult.successResponse(groupRankManager.getGroupRankList(limit, currentPage, searchUser, type, gid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}