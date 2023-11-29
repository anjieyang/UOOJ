package com.anjieyang.uooj.service.file.impl;

import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.file.ImageManager;
import com.anjieyang.uooj.pojo.entity.group.Group;
import com.anjieyang.uooj.service.file.ImageService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageManager imageManager;

    @Override
    public CommonResult<Map<Object, Object>> uploadAvatar(MultipartFile image) {
        try {
            return CommonResult.successResponse(imageManager.uploadAvatar(image));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }

    @Override
    public CommonResult<Group> uploadGroupAvatar(MultipartFile image, Long gid) {
        try {
            return CommonResult.successResponse(imageManager.uploadGroupAvatar(image, gid));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public CommonResult<Map<Object, Object>> uploadCarouselImg(MultipartFile image) {
        try {
            return CommonResult.successResponse(imageManager.uploadCarouselImg(image));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }
}