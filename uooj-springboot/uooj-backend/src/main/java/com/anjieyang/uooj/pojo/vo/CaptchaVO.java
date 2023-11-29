package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class CaptchaVO {

    @ApiModelProperty(value = "验证码图片的base64")
    private String img;

    @ApiModelProperty(value = "验证码key")
    private String captchaKey;
}