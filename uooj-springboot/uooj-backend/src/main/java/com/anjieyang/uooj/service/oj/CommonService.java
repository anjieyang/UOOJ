package com.anjieyang.uooj.service.oj;

import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.problem.CodeTemplate;
import com.anjieyang.uooj.pojo.entity.problem.Language;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;
import com.anjieyang.uooj.pojo.vo.CaptchaVO;
import com.anjieyang.uooj.pojo.vo.ProblemTagVO;

import java.util.Collection;
import java.util.List;

public interface CommonService {

    public CommonResult<CaptchaVO> getCaptcha();

    public CommonResult<List<TrainingCategory>> getTrainingCategory();

    public CommonResult<List<Tag>> getAllProblemTagsList(String oj);

    public CommonResult<List<ProblemTagVO>> getProblemTagsAndClassification(String oj);

    public CommonResult<Collection<Tag>> getProblemTags(Long pid);

    public CommonResult<List<Language>> getLanguages(Long pid, Boolean all);

    public CommonResult<Collection<Language>> getProblemLanguages(Long pid);

    public CommonResult<List<CodeTemplate>> getProblemCodeTemplate(Long pid);
}
