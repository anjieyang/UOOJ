package com.anjieyang.uooj.service.file.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.file.ProblemFileManager;
import com.anjieyang.uooj.service.file.ProblemFileService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ProblemFileServiceImpl implements ProblemFileService {

    @Resource
    private ProblemFileManager problemFileManager;

    @Override
    public CommonResult<Void> importProblem(MultipartFile file) {
        try {
            problemFileManager.importProblem(file);
            return CommonResult.successResponse();
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        }
    }

    @Override
    public void exportProblem(List<Long> pidList, HttpServletResponse response) {
        problemFileManager.exportProblem(pidList, response);
    }
}