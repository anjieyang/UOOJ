package com.anjieyang.uooj.controller.group;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.group.GroupMember;
import com.anjieyang.uooj.pojo.vo.GroupMemberVO;
import com.anjieyang.uooj.service.group.member.GroupMemberService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LengYun
 *
 * @Description:
 */
@RestController
@RequiresAuthentication
@RequestMapping("/api/group")
public class GroupMemberController {

    @Autowired
    private GroupMemberService groupMemberService;

    @GetMapping("/get-member-list")
    public CommonResult<IPage<GroupMemberVO>> getMemberList(@RequestParam(value = "limit", required = false) Integer limit,
                                                            @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                            @RequestParam(value = "keyword", required = false) String keyword,
                                                            @RequestParam(value = "auth", required = false) Integer auth,
                                                            @RequestParam(value = "gid", required = true) Long gid) {
        return groupMemberService.getMemberList(limit, currentPage, keyword, auth, gid);
    }

    @GetMapping("/get-apply-list")
    public CommonResult<IPage<GroupMemberVO>> getApplyList(@RequestParam(value = "limit", required = false) Integer limit,
                                                           @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                           @RequestParam(value = "keyword", required = false) String keyword,
                                                           @RequestParam(value = "auth", required = false) Integer auth,
                                                           @RequestParam(value = "gid", required = true) Long gid) {
        return groupMemberService.getApplyList(limit, currentPage, keyword, auth, gid);
    }

    @PostMapping("/member")
    @RequiresAuthentication
    public CommonResult<Void> addGroupMember(@RequestParam(value = "gid", required = true) Long gid,
                                             @RequestParam(value = "code", required = false) String code,
                                             @RequestParam(value = "reason", required = false) String reason) {
        return groupMemberService.addMember(gid, code, reason);
    }

    @PutMapping("/member")
    @RequiresAuthentication
    public CommonResult<Void> updateMember(@RequestBody GroupMember groupMember) {
        return groupMemberService.updateMember(groupMember);
    }

    @DeleteMapping("/member")
    @RequiresAuthentication
    public CommonResult<Void> deleteMember(@RequestParam(value = "uid", required = true) String uid,
                                           @RequestParam(value = "gid", required = true) Long gid) {
        return groupMemberService.deleteMember(uid, gid);
    }

    @DeleteMapping("/member/exit")
    @RequiresAuthentication
    public CommonResult<Void> exitGroup(@RequestParam(value = "gid", required = true) Long gid) {
        return groupMemberService.exitGroup(gid);
    }


}
