package com.anjieyang.uooj.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.contest.ContestRecord;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface ContestRecordEntityService extends IService<ContestRecord> {
    void updateContestRecord(Integer score, Integer status, Long submitId, Integer useTime);
}
