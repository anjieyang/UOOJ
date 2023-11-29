package com.anjieyang.uooj.pojo.vo;

import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class ChangeAccountVO {

    private Integer code;

    private String msg;

    private UserInfoVO userInfo;
}