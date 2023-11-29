package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.msg.UserSysNotice;
import com.anjieyang.uooj.pojo.vo.SysMsgVO;


@Mapper
@Repository
public interface UserSysNoticeMapper extends BaseMapper<UserSysNotice> {

    IPage<SysMsgVO> getSysOrMineNotice(Page<SysMsgVO> page, @Param("uid") String uid, @Param("type") String type);
}
