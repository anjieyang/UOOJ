package com.anjieyang.uooj.dao.group;

import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.vo.ContestVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupContestEntityService extends IService<Contest> {

    IPage<ContestVO> getContestList(int limit, int currentPage, Long gid);

    IPage<Contest> getAdminContestList(int limit, int currentPage, Long gid);

}
