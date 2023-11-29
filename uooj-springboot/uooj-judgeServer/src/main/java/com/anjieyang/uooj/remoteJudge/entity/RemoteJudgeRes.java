package com.anjieyang.uooj.remoteJudge.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.anjieyang.uooj.pojo.entity.judge.JudgeCase;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class RemoteJudgeRes implements Serializable {
    private static final long serialVersionUID = 999L;

    private Integer status;

    private Integer time;

    private Integer memory;

    private String errorInfo;

    private List<JudgeCase> judgeCaseList;
}