package com.anjieyang.uooj.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 注册数据实体类
 */
@Data
@Accessors(chain = true)
public class RegisterDTO implements Serializable {

    @Nullable
    private String uuid;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "验证码不能为空")
    private String code;
}