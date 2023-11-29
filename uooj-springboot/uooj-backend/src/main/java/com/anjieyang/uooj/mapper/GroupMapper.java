package com.anjieyang.uooj.mapper;

import com.anjieyang.uooj.pojo.entity.group.Group;
import com.anjieyang.uooj.pojo.vo.GroupVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Mapper
@Repository
public interface GroupMapper extends BaseMapper<Group> {
    List<GroupVO> getGroupList(IPage iPage,
                               @Param("keyword") String keyword,
                               @Param("auth") Integer auth,
                               @Param("uid") String uid,
                               @Param("onlyMine") Boolean onlyMine,
                               @Param("isRoot") Boolean isRoot);
}
