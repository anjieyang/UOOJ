package com.anjieyang.uooj.service.file.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.file.ImportQDUOJProblemManager;
import com.anjieyang.uooj.service.file.ImportQDUOJProblemService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ImportQDUOJProblemServiceImpl implements ImportQDUOJProblemService {

    @Autowired
    private ImportQDUOJProblemManager importQDUOJProblemManager;

    @Override
    public CommonResult<Void> importQDOJProblem(MultipartFile file) {
        try {
            importQDUOJProblemManager.importQDOJProblem(file);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }
}