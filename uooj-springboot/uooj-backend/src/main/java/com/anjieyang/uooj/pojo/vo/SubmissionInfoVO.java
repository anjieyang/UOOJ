package com.anjieyang.uooj.pojo.vo;

import com.anjieyang.uooj.pojo.entity.judge.Judge;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class SubmissionInfoVO {

    @ApiModelProperty(value = "提交详情")
    private Judge submission;

    @ApiModelProperty(value = "提交者是否可以分享该代码")
    private Boolean codeShare;
}