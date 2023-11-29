package com.anjieyang.uooj.service.msg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.vo.SysMsgVO;

public interface NoticeService {

    public CommonResult<IPage<SysMsgVO>> getSysNotice(Integer limit, Integer currentPage);

    public CommonResult<IPage<SysMsgVO>> getMineNotice(Integer limit, Integer currentPage);
}
