package com.anjieyang.uooj.mapper;

import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Mapper
@Repository
public interface GroupDiscussionMapper extends BaseMapper<Discussion> {

}
