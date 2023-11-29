package com.anjieyang.uooj.controller.group;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.common.Announcement;
import com.anjieyang.uooj.pojo.vo.AnnouncementVO;
import com.anjieyang.uooj.service.group.announcement.GroupAnnouncementService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@RestController
@RequiresAuthentication
@RequestMapping("/api/group")
public class GroupAnnouncementController {

    @Autowired
    private GroupAnnouncementService groupAnnouncementService;

    @GetMapping("/get-announcement-list")
    public CommonResult<IPage<AnnouncementVO>> getAnnouncementList(@RequestParam(value = "limit", required = false) Integer limit,
                                                                   @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                                   @RequestParam(value = "gid", required = true) Long gid) {
        return groupAnnouncementService.getAnnouncementList(limit, currentPage, gid);
    }

    @GetMapping("/get-admin-announcement-list")
    public CommonResult<IPage<AnnouncementVO>> getAdminAnnouncementList(@RequestParam(value = "limit", required = false) Integer limit,
                                                                        @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                                        @RequestParam(value = "gid", required = true) Long gid) {
        return groupAnnouncementService.getAdminAnnouncementList(limit, currentPage, gid);
    }

    @PostMapping("/announcement")
    public CommonResult<Void> addAnnouncement(@RequestBody Announcement announcement) {
        return groupAnnouncementService.addAnnouncement(announcement);
    }

    @PutMapping("/announcement")
    public CommonResult<Void> updateAnnouncement(@RequestBody Announcement announcement) {
        return groupAnnouncementService.updateAnnouncement(announcement);
    }

    @DeleteMapping("/announcement")
    public CommonResult<Void> deleteAnnouncement(@RequestParam(value = "aid", required = true) Long aid) {
        return groupAnnouncementService.deleteAnnouncement(aid);
    }

}
