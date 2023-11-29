package com.anjieyang.uooj.service.file.impl;

import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.file.TestCaseManager;
import com.anjieyang.uooj.service.file.TestCaseService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Resource
    private TestCaseManager testCaseManager;

    @Override
    public CommonResult<Map<Object, Object>> uploadTestcaseZip(MultipartFile file, Long gid, String mode) {
        try {
            return CommonResult.successResponse(testCaseManager.uploadTestcaseZip(file, gid, mode));
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage());
        } catch (StatusSystemErrorException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.SYSTEM_ERROR);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        }
    }

    @Override
    public void downloadTestcase(Long pid, HttpServletResponse response) throws StatusFailException, StatusForbiddenException {
        testCaseManager.downloadTestcase(pid, response);
    }
}