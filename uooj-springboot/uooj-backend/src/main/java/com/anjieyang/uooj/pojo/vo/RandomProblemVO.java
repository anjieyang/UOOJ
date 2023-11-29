package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class RandomProblemVO {

    @ApiModelProperty(value = "题目id")
    private String problemId;
}