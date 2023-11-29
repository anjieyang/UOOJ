package com.anjieyang.uooj.service.oj;

import com.anjieyang.uooj.pojo.vo.*;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ChangeEmailDTO;
import com.anjieyang.uooj.pojo.dto.ChangePasswordDTO;
import com.anjieyang.uooj.pojo.dto.CheckUsernameOrEmailDTO;


public interface AccountService {

    public CommonResult<CheckUsernameOrEmailVO> checkUsernameOrEmail(CheckUsernameOrEmailDTO checkUsernameOrEmailDto);

    public CommonResult<UserHomeVO> getUserHomeInfo(String uid, String username);

    public CommonResult<UserCalendarHeatmapVO> getUserCalendarHeatmap(String uid, String username);

    public CommonResult<ChangeAccountVO> changePassword(ChangePasswordDTO changePasswordDto);

    public CommonResult<Void> getChangeEmailCode(String email);

    public CommonResult<ChangeAccountVO> changeEmail(ChangeEmailDTO changeEmailDto);

    public CommonResult<UserInfoVO> changeUserInfo(UserInfoVO userInfoVo);

    public CommonResult<UserAuthInfoVO> getUserAuthInfo();
}
