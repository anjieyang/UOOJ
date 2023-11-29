package com.anjieyang.uooj.dao.contest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.pojo.vo.ContestVO;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface ContestEntityService extends IService<Contest> {

    List<ContestVO> getWithinNext14DaysContests();

    IPage<ContestVO> getContestList(Integer limit, Integer currentPage, Integer type, Integer status, String keyword);

    ContestVO getContestInfoById(long cid);
}
