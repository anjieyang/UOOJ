package com.anjieyang.uooj.service.admin.account.impl;

import com.anjieyang.uooj.service.admin.account.AdminAccountService;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusAccessDeniedException;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.admin.account.AdminAccountManager;
import com.anjieyang.uooj.pojo.vo.UserInfoVO;
import com.anjieyang.uooj.pojo.dto.LoginDTO;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Service
public class AdminAccountServiceImpl implements AdminAccountService {

    @Resource
    private AdminAccountManager adminAccountManager;

    @Override
    public CommonResult<UserInfoVO> login(LoginDTO loginDto) {
        try {
            return CommonResult.successResponse(adminAccountManager.login(loginDto));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        }
    }

    @Override
    public CommonResult<Void> logout() {
        adminAccountManager.logout();
        return CommonResult.successResponse("退出登录成功！");
    }
}