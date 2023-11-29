package com.anjieyang.uooj.service.admin.contest;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.AnnouncementDTO;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;


public interface AdminContestAnnouncementService {

    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(Integer limit, Integer currentPage, Long cid);

    public CommonResult<Void> deleteAnnouncement(Long aid);

    public CommonResult<Void> addAnnouncement(AnnouncementDTO announcementDto);

    public CommonResult<Void> updateAnnouncement(AnnouncementDTO announcementDto);
}
