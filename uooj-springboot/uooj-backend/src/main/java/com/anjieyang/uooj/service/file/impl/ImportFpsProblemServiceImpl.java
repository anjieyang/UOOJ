package com.anjieyang.uooj.service.file.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.manager.file.ImportFpsProblemManager;
import com.anjieyang.uooj.service.file.ImportFpsProblemService;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ImportFpsProblemServiceImpl implements ImportFpsProblemService {

    @Resource
    private ImportFpsProblemManager importFpsProblemManager;

    @Override
    public CommonResult<Void> importFPSProblem(MultipartFile file) {
        try {
            importFpsProblemManager.importFPSProblem(file);
            return CommonResult.successResponse();
        } catch (IOException | StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        }
    }
}