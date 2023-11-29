package com.anjieyang.uooj.service.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.msg.AdminSysNotice;
import com.anjieyang.uooj.pojo.vo.AdminSysNoticeVO;

public interface AdminNoticeService {

    public CommonResult<IPage<AdminSysNoticeVO>> getSysNotice(Integer limit, Integer currentPage, String type);

    public CommonResult<Void> addSysNotice(AdminSysNotice adminSysNotice);

    public CommonResult<Void> deleteSysNotice(Long id);

    public CommonResult<Void> updateSysNotice(AdminSysNotice adminSysNotice);
}
