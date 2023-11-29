package com.anjieyang.uooj.pojo.vo;

import com.anjieyang.uooj.pojo.entity.contest.ContestProblem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@ApiModel(value = "赛外排行榜所需的比赛信息，同时包括题目题号、气球颜色", description = "")
@Data
public class ContestOutsideInfoVO {

    @ApiModelProperty(value = "比赛信息")
    private ContestVO contest;

    @ApiModelProperty(value = "比赛题目信息列表")
    private List<ContestProblem> problemList;
}