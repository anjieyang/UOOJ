package com.anjieyang.uooj.dao.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.anjieyang.uooj.pojo.entity.judge.Judge;
import com.anjieyang.uooj.pojo.vo.ACMRankVO;
import com.anjieyang.uooj.pojo.entity.user.UserRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.vo.OIRankVO;
import com.anjieyang.uooj.pojo.vo.UserHomeVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface UserRecordEntityService extends IService<UserRecord> {

    List<ACMRankVO> getRecent7ACRank();

    UserHomeVO getUserHomeInfo(String uid, String username);

    List<Judge> getLastYearUserJudgeList(String uid, String username);

    IPage<OIRankVO> getOIRankList(Page<OIRankVO> page, List<String> uidList);

    IPage<ACMRankVO> getACMRankList(Page<ACMRankVO> page, List<String> uidList);

    IPage<OIRankVO> getGroupRankList(Page<OIRankVO> page, Long gid, List<String> uidList, String rankType, Boolean useCache);

}
