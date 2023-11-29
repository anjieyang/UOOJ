package com.anjieyang.uooj.service.oj.impl;

import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusAccessDeniedException;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.oj.PassportManager;
import com.anjieyang.uooj.pojo.dto.ApplyResetPasswordDTO;
import com.anjieyang.uooj.pojo.dto.LoginDTO;
import com.anjieyang.uooj.pojo.dto.RegisterDTO;
import com.anjieyang.uooj.pojo.dto.ResetPasswordDTO;
import com.anjieyang.uooj.pojo.vo.RegisterCodeVO;
import com.anjieyang.uooj.pojo.vo.UserInfoVO;
import com.anjieyang.uooj.service.oj.PassportService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class PassportServiceImpl implements PassportService {

    @Resource
    private PassportManager passportManager;

    @Override
    public CommonResult<UserInfoVO> login(LoginDTO loginDto, HttpServletResponse response, HttpServletRequest request) {
        try {
            return CommonResult.successResponse(passportManager.login(loginDto, response, request));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<RegisterCodeVO> getRegisterCode(String email) {
        try {
            return CommonResult.successResponse(passportManager.getRegisterCode(email));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> register(RegisterDTO registerDto) {
        try {
            passportManager.register(registerDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusAccessDeniedException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.ACCESS_DENIED);
        }
    }

    @Override
    public CommonResult<Void> applyResetPassword(ApplyResetPasswordDTO applyResetPasswordDto) {
        try {
            passportManager.applyResetPassword(applyResetPasswordDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> resetPassword(ResetPasswordDTO resetPasswordDto) {
        try {
            passportManager.resetPassword(resetPasswordDto);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> logout() {
        passportManager.logout();
        return CommonResult.successResponse("登出成功");
    }
}