package com.anjieyang.uooj.service.group;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.group.Group;
import com.anjieyang.uooj.pojo.vo.AccessVO;
import com.anjieyang.uooj.pojo.vo.GroupVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupService {

    public CommonResult<IPage<GroupVO>> getGroupList(Integer limit, Integer currentPage, String keyword, Integer auth, Boolean onlyMine);

    public CommonResult<Group> getGroup(Long gid);

    public CommonResult<AccessVO> getGroupAccess(Long gid);

    public CommonResult<Integer> getGroupAuth(Long gid);

    public CommonResult<Void> addGroup(Group group);

    public CommonResult<Void> updateGroup(Group group);

    public CommonResult<Void> deleteGroup(Long gid);
}
