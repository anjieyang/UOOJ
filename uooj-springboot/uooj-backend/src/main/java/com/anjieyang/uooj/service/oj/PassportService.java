package com.anjieyang.uooj.service.oj;


import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ApplyResetPasswordDTO;
import com.anjieyang.uooj.pojo.dto.LoginDTO;
import com.anjieyang.uooj.pojo.dto.RegisterDTO;
import com.anjieyang.uooj.pojo.dto.ResetPasswordDTO;
import com.anjieyang.uooj.pojo.vo.RegisterCodeVO;
import com.anjieyang.uooj.pojo.vo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface PassportService {

    public CommonResult<UserInfoVO> login(LoginDTO loginDto, HttpServletResponse response, HttpServletRequest request);

    public CommonResult<RegisterCodeVO> getRegisterCode(String email);

    public CommonResult<Void> register(RegisterDTO registerDto);

    public CommonResult<Void> applyResetPassword(ApplyResetPasswordDTO applyResetPasswordDto);

    public CommonResult<Void> resetPassword(ResetPasswordDTO resetPasswordDto);

    public CommonResult<Void> logout();
}