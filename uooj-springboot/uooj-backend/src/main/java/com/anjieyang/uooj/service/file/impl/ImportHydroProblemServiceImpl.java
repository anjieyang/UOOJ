package com.anjieyang.uooj.service.file.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.file.ImportHydroProblemManager;
import com.anjieyang.uooj.service.file.ImportHydroProblemService;

import javax.annotation.Resource;

/**
 * @Author Anjie Yang
 * @Date 2022/10/16
 */
@Component
public class ImportHydroProblemServiceImpl implements ImportHydroProblemService {

    @Resource
    private ImportHydroProblemManager importHydroProblemManager;

    @Override
    public CommonResult<Void> importHydroProblem(MultipartFile file) {
        try {
            importHydroProblemManager.importHydroProblem(file);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }
}
