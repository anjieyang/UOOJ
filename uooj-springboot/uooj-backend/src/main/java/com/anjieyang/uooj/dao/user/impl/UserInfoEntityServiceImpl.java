package com.anjieyang.uooj.dao.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.anjieyang.uooj.pojo.dto.RegisterDTO;
import com.anjieyang.uooj.pojo.entity.user.UserInfo;
import com.anjieyang.uooj.mapper.UserInfoMapper;
import com.anjieyang.uooj.dao.user.UserInfoEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.utils.Constants;
import com.anjieyang.uooj.utils.RedisUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class UserInfoEntityServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoEntityService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Boolean addUser(RegisterDTO registerDto) {
        return userInfoMapper.addUser(registerDto) == 1;
    }

    @Override
    public List<String> getSuperAdminUidList() {

        String cacheKey = Constants.Account.SUPER_ADMIN_UID_LIST_CACHE.getCode();
        List<String> superAdminUidList = (List<String>) redisUtils.get(cacheKey);
        if (superAdminUidList == null) {
            superAdminUidList = userInfoMapper.getSuperAdminUidList();
            redisUtils.set(cacheKey, superAdminUidList, 12 * 3600);
        }
        return superAdminUidList;
    }

    @Override
    public List<String> getProblemAdminUidList() {
        return userInfoMapper.getProblemAdminUidList();
    }

}
