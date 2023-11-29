package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/12/4
 */
@Data
public class UserAuthInfoVO {

    @ApiModelProperty(value = "角色列表")
    private List<String> roles;

    @ApiModelProperty(value = "权限列表")
    private List<String> permissions;
}
