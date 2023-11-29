package com.anjieyang.uooj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.entity.judge.JudgeServer;


@Mapper
@Repository
public interface JudgeServerMapper extends BaseMapper<JudgeServer> {

}
