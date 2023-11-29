package com.anjieyang.uooj.dao.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.msg.AdminSysNotice;
import com.anjieyang.uooj.pojo.vo.AdminSysNoticeVO;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface AdminSysNoticeEntityService extends IService<AdminSysNotice> {

    public IPage<AdminSysNoticeVO> getSysNotice(int limit, int currentPage, String type);

}