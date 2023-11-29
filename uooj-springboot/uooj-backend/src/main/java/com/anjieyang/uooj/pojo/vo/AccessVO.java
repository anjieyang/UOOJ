package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class AccessVO {

    @ApiModelProperty(value = "是否有进入比赛或训练的权限")
    private Boolean access;
}