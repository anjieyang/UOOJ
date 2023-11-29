package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.vo.DiscussionVO;


@Mapper
@Repository
public interface DiscussionMapper extends BaseMapper<Discussion> {
    DiscussionVO getDiscussion(@Param("did") Integer did, @Param("uid") String uid);
}
