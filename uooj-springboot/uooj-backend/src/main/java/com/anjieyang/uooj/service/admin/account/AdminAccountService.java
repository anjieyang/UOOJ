package com.anjieyang.uooj.service.admin.account;


import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.LoginDTO;
import com.anjieyang.uooj.pojo.vo.UserInfoVO;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface AdminAccountService {

    public CommonResult<UserInfoVO> login(LoginDTO loginDto);

    public CommonResult<Void> logout();
}