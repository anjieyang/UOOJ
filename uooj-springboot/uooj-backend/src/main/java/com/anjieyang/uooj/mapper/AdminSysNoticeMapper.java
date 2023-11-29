package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.msg.AdminSysNotice;
import com.anjieyang.uooj.pojo.vo.AdminSysNoticeVO;

@Mapper
@Repository
public interface AdminSysNoticeMapper extends BaseMapper<AdminSysNotice> {
    IPage<AdminSysNoticeVO> getAdminSysNotice(Page<AdminSysNoticeVO> page, @Param("type") String type);
}
