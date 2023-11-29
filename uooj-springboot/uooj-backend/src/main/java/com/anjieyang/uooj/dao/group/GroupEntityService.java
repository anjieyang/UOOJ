package com.anjieyang.uooj.dao.group;

import com.anjieyang.uooj.pojo.entity.group.Group;
import com.anjieyang.uooj.pojo.vo.GroupVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface GroupEntityService extends IService<Group> {
    IPage<GroupVO> getGroupList(int limit,
                                int currentPage,
                                String keyword,
                                Integer auth,
                                String uid,
                                Boolean onlyMine,
                                Boolean isRoot);
}
