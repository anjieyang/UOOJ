package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
@ApiModel(value="比赛报名统计", description="")
public class ContestRegisterCountVO implements Serializable {

    @ApiModelProperty(value = "比赛id")
    private Long cid;

    @ApiModelProperty(value = "比赛报名人数")
    private Integer count;
}