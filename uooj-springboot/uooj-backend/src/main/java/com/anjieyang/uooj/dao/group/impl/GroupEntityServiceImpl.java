package com.anjieyang.uooj.dao.group.impl;

import com.anjieyang.uooj.dao.group.GroupEntityService;
import com.anjieyang.uooj.mapper.GroupMapper;
import com.anjieyang.uooj.pojo.entity.group.Group;
import com.anjieyang.uooj.pojo.vo.GroupVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupEntityServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupEntityService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public IPage<GroupVO> getGroupList(int limit,
                                       int currentPage,
                                       String keyword,
                                       Integer auth,
                                       String uid,
                                       Boolean onlyMine,
                                       Boolean isRoot) {
        IPage<GroupVO> iPage = new Page<>(currentPage, limit);
        List<GroupVO> groupList = groupMapper.getGroupList(iPage, keyword, auth, uid, onlyMine,isRoot);

        return iPage.setRecords(groupList);
    }
}
