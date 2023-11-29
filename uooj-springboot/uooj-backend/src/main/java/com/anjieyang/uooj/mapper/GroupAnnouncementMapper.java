package com.anjieyang.uooj.mapper;

import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Mapper
@Repository
public interface GroupAnnouncementMapper extends BaseMapper<Announcement> {

    List<AnnouncementVO> getAnnouncementList(IPage iPage, @Param("gid") Long gid);

    List<AnnouncementVO> getAdminAnnouncementList(IPage iPage, @Param("gid") Long gid);

}
