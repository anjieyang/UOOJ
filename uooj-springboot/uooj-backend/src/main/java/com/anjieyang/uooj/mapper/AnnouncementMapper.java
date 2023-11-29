package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Mapper
@Repository
public interface AnnouncementMapper extends BaseMapper<Announcement> {
    IPage<AnnouncementVO> getAnnouncementList(Page<AnnouncementVO> page, @Param("notAdmin") Boolean notAdmin);
    IPage<AnnouncementVO> getContestAnnouncement(Page<AnnouncementVO> page, @Param("cid")Long cid, @Param("notAdmin") Boolean notAdmin);
}
