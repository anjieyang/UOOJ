package com.anjieyang.uooj.service.admin.tag.impl;

import com.anjieyang.uooj.service.admin.tag.AdminTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.admin.tag.AdminTagManager;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.pojo.entity.problem.TagClassification;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Service
public class AdminTagServiceImpl implements AdminTagService {

    @Autowired
    private AdminTagManager adminTagManager;

    @Override
    public CommonResult<Tag> addTag(Tag tag) {
        try {
            return CommonResult.successResponse(adminTagManager.addTag(tag));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateTag(Tag tag) {
        try {
            adminTagManager.updateTag(tag);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> deleteTag(Long tid) {
        try {
            adminTagManager.deleteTag(tid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<List<TagClassification>> getTagClassification(String oj) {
        return CommonResult.successResponse(adminTagManager.getTagClassification(oj));
    }

    @Override
    public CommonResult<TagClassification> addTagClassification(TagClassification tagClassification) {
        try {
            return CommonResult.successResponse(adminTagManager.addTagClassification(tagClassification));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> updateTagClassification(TagClassification tagClassification) {
        try {
            adminTagManager.updateTagClassification(tagClassification);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }

    @Override
    public CommonResult<Void> deleteTagClassification(Long tcid) {
        try {
            adminTagManager.deleteTagClassification(tcid);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}