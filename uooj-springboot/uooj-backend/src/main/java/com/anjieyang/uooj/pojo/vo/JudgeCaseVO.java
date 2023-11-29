package com.anjieyang.uooj.pojo.vo;

import com.anjieyang.uooj.pojo.entity.judge.JudgeCase;
import lombok.Data;

import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/8/28
 */
@Data
public class JudgeCaseVO {

    /**
     * 当judgeCaseMode为default时
     */
    private List<JudgeCase> judgeCaseList;

    /**
     * 当judgeCaseMode为subtask_lowest,subtask_average时
     */
    private List<SubTaskJudgeCaseVO> subTaskJudgeCaseVoList;

    /**
     * default,subtask_lowest,subtask_average
     */
    private String judgeCaseMode;
}
