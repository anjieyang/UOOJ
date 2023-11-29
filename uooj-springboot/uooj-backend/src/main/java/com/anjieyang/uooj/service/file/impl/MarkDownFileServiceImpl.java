package com.anjieyang.uooj.service.file.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.file.MarkDownFileManager;
import com.anjieyang.uooj.service.file.MarkDownFileService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class MarkDownFileServiceImpl implements MarkDownFileService {

    @Resource
    private MarkDownFileManager markDownFileManager;

    @Override
    public CommonResult<Map<Object, Object>> uploadMDImg(MultipartFile image, Long gid) {
        try {
            return CommonResult.successResponse(markDownFileManager.uploadMDImg(image, gid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Void> deleteMDImg(Long fileId) {
        try {
            markDownFileManager.deleteMDImg(fileId);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Map<Object, Object>> uploadMd(MultipartFile file, Long gid) {
        try {
            return CommonResult.successResponse(markDownFileManager.uploadMd(file, gid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }
}