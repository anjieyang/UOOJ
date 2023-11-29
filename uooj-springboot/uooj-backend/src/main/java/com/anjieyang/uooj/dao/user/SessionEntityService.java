package com.anjieyang.uooj.dao.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.user.Session;

public interface SessionEntityService extends IService<Session> {

    public void checkRemoteLogin(String uid);

}
