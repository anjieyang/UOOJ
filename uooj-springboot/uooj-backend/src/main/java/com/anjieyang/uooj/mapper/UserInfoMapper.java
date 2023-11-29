package com.anjieyang.uooj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.anjieyang.uooj.pojo.dto.RegisterDTO;
import com.anjieyang.uooj.pojo.entity.user.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    int addUser(RegisterDTO registerDto);

    List<String> getSuperAdminUidList();

    List<String> getProblemAdminUidList();
}
