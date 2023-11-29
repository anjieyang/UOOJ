package com.anjieyang.uooj.dao.user.impl;

import com.anjieyang.uooj.dao.user.AuthEntityService;
import com.anjieyang.uooj.pojo.entity.user.Auth;
import com.anjieyang.uooj.mapper.AuthMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */
@Service
public class AuthEntityServiceImpl extends ServiceImpl<AuthMapper, Auth> implements AuthEntityService {

}
