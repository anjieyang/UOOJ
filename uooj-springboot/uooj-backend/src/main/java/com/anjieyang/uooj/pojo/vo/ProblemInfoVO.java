package com.anjieyang.uooj.pojo.vo;

import com.anjieyang.uooj.pojo.entity.problem.Problem;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
@AllArgsConstructor
public class ProblemInfoVO {
    /**
     * 题目内容
     */
    private Problem problem;
    /**
     * 题目标签
     */
    private List<Tag> tags;
    /**
     * 题目可用编程语言
     */
    private List<String> languages;
    /**
     * 题目提交统计情况
     */
    private ProblemCountVO problemCount;
    /**
     * 题目默认模板
     */
    private HashMap<String, String> codeTemplate;
}