package com.anjieyang.uooj.service.oj.impl;

import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.oj.CommonManager;
import com.anjieyang.uooj.pojo.entity.problem.CodeTemplate;
import com.anjieyang.uooj.pojo.entity.problem.Language;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;
import com.anjieyang.uooj.pojo.vo.CaptchaVO;
import com.anjieyang.uooj.pojo.vo.ProblemTagVO;
import com.anjieyang.uooj.service.oj.CommonService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonManager commonManager;

    @Override
    public CommonResult<CaptchaVO> getCaptcha() {
        return CommonResult.successResponse(commonManager.getCaptcha());
    }

    @Override
    public CommonResult<List<TrainingCategory>> getTrainingCategory() {
        return CommonResult.successResponse(commonManager.getTrainingCategory());
    }

    @Override
    public CommonResult<List<Tag>> getAllProblemTagsList(String oj) {
        return CommonResult.successResponse(commonManager.getAllProblemTagsList(oj));
    }

    @Override
    public CommonResult<List<ProblemTagVO>> getProblemTagsAndClassification(String oj) {
        return CommonResult.successResponse(commonManager.getProblemTagsAndClassification(oj));
    }

    @Override
    public CommonResult<Collection<Tag>> getProblemTags(Long pid) {
        return CommonResult.successResponse(commonManager.getProblemTags(pid));
    }

    @Override
    public CommonResult<List<Language>> getLanguages(Long pid, Boolean all) {
        return CommonResult.successResponse(commonManager.getLanguages(pid, all));
    }

    @Override
    public CommonResult<Collection<Language>> getProblemLanguages(Long pid) {
        return CommonResult.successResponse(commonManager.getProblemLanguages(pid));
    }

    @Override
    public CommonResult<List<CodeTemplate>> getProblemCodeTemplate(Long pid) {
        return CommonResult.successResponse(commonManager.getProblemCodeTemplate(pid));
    }
}