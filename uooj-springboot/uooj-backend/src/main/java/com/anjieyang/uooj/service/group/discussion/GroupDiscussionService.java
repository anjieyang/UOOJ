package com.anjieyang.uooj.service.group.discussion;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupDiscussionService {

    public CommonResult<IPage<Discussion>> getDiscussionList(Integer limit, Integer currentPage, Long gid, String pid);

    public CommonResult<IPage<Discussion>> getAdminDiscussionList(Integer limit, Integer currentPage, Long gid);

    public CommonResult<Void> addDiscussion(Discussion discussion);

    public CommonResult<Void> updateDiscussion(Discussion discussion);

    public CommonResult<Void> deleteDiscussion(Long did);

}
