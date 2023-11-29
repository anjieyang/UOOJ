package com.anjieyang.uooj.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/10/15
 */
@Data
public class SubmissionStatisticsVO {

    @ApiModelProperty(value = "最近七天日期格式 mm-dd,升序")
    private List<String> dateStrList;

    @ApiModelProperty(value = "最近七天每天AC数量")
    private List<Long> acCountList;

    @ApiModelProperty(value = "最近七天每天提交数量")
    private List<Long> totalCountList;
}
