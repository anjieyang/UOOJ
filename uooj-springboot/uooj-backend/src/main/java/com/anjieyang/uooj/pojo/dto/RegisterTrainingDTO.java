package com.anjieyang.uooj.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class RegisterTrainingDTO {

    @NotBlank(message = "tid不能为空")
    private Long tid;

    @NotBlank(message = "password不能为空")
    private String password;
}