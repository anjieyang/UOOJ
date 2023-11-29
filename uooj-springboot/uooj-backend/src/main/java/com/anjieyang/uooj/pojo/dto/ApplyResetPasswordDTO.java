package com.anjieyang.uooj.pojo.dto;

import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class ApplyResetPasswordDTO {

    private String captcha;

    private String captchaKey;

    private String email;
}