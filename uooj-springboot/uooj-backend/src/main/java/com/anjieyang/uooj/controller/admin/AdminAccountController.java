package com.anjieyang.uooj.controller.admin;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.anjieyang.uooj.common.result.CommonResult;

import com.anjieyang.uooj.pojo.dto.LoginDTO;

import com.anjieyang.uooj.pojo.vo.UserInfoVO;
import com.anjieyang.uooj.service.admin.account.AdminAccountService;



/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@RestController
@RequestMapping("/api/admin")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;

    @PostMapping("/login")
    public CommonResult<UserInfoVO> login(@Validated @RequestBody LoginDTO loginDto){
       return adminAccountService.login(loginDto);
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    @RequiresRoles(value = {"root","admin","problem_admin"},logical = Logical.OR)
    public CommonResult<Void> logout() {
        return adminAccountService.logout();
    }

}