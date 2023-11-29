package com.anjieyang.uooj.dao.group;

import com.anjieyang.uooj.pojo.entity.group.GroupMember;
import com.anjieyang.uooj.pojo.vo.GroupMemberVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupMemberEntityService extends IService<GroupMember> {

    IPage<GroupMemberVO> getMemberList(int limit, int currentPage, String keyword, Integer auth, Long gid);

    IPage<GroupMemberVO> getApplyList(int limit, int currentPage, String keyword, Integer auth, Long gid);

    List<String> getGroupRootUidList(Long gid);

    void addApplyNoticeToGroupRoot(Long gid, String groupName, String newMemberUid);

    void addWelcomeNoticeToGroupNewMember(Long gid, String groupName,String memberUid);

    void addRemoveNoticeToGroupMember(Long gid, String groupName, String operator, String memberUid);

    void addDissolutionNoticeToGroupMember(Long gid, String groupName, List<String> groupMemberUidList, String operator);
}
