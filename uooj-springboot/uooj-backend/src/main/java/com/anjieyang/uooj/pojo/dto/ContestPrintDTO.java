package com.anjieyang.uooj.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class ContestPrintDTO {

    @NotBlank(message = "比赛id不能为空")
    private Long cid;

    @NotBlank(message = "打印内容不能为空")
    private String content;
}