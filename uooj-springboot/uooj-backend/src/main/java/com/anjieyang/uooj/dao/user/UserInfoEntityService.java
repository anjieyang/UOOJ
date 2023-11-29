package com.anjieyang.uooj.dao.user;

import com.anjieyang.uooj.pojo.dto.RegisterDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.user.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
public interface UserInfoEntityService extends IService<UserInfo> {

    public Boolean addUser(RegisterDTO registerDto);

    public List<String> getSuperAdminUidList();

    public List<String> getProblemAdminUidList();
}
