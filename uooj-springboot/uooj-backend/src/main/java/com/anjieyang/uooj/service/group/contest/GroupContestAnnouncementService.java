package com.anjieyang.uooj.service.group.contest;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.AnnouncementDTO;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupContestAnnouncementService {

    public CommonResult<IPage<AnnouncementVO>> getContestAnnouncementList(Integer limit, Integer currentPage, Long cid);

    public CommonResult<Void> addContestAnnouncement(AnnouncementDTO announcementDto);

    public CommonResult<Void> updateContestAnnouncement(AnnouncementDTO announcementDto);

    public CommonResult<Void> deleteContestAnnouncement(Long aid, Long cid);

}
