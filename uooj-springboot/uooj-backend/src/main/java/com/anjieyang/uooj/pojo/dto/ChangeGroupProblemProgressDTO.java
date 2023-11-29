package com.anjieyang.uooj.pojo.dto;

import lombok.Data;

/**
 * @Author Anjie Yang
 * @Date 2022/4/13
 */
@Data
public class ChangeGroupProblemProgressDTO {

    /**
     * 题目id
     */
    private Long pid;

    /**
     * 1为申请中，2为申请通过，3为申请拒绝
     */
    private Integer progress;
}
