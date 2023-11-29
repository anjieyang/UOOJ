package com.anjieyang.uooj.service.group.member;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.group.GroupMember;
import com.anjieyang.uooj.pojo.vo.GroupMemberVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupMemberService {

    public CommonResult<IPage<GroupMemberVO>> getMemberList(Integer limit, Integer currentPage, String keyword, Integer auth, Long gid);

    public CommonResult<IPage<GroupMemberVO>> getApplyList(Integer limit, Integer currentPage, String keyword, Integer auth, Long gid);

    public CommonResult<Void> addMember(Long gid, String code, String reason);

    public CommonResult<Void> updateMember(GroupMember groupMember);

    public CommonResult<Void> deleteMember(String uid, Long gid);

    public CommonResult<Void> exitGroup(Long gid);
}
