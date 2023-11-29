package com.anjieyang.uooj.pojo.dto;

import com.anjieyang.uooj.pojo.entity.problem.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
@Accessors(chain = true)
public class ProblemDTO {

    private Problem problem;

    private List<ProblemCase> samples;

    private Boolean isUploadTestCase;

    private String uploadTestcaseDir;

    private String judgeMode;

    private Boolean changeModeCode;

    private Boolean changeJudgeCaseMode;

    private List<Language> languages;

    private List<Tag> tags;

    private List<CodeTemplate> codeTemplates;

}