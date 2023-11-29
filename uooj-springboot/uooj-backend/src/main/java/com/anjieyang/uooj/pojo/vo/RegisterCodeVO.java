package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class RegisterCodeVO {

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "注册邮件有效时间，单位秒")
    private Integer expire;
}