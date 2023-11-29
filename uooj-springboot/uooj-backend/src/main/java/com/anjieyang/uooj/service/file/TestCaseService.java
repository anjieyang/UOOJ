package com.anjieyang.uooj.service.file;

import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface TestCaseService {

    public CommonResult<Map<Object, Object>> uploadTestcaseZip(MultipartFile file, Long gid, String mode);

    public void downloadTestcase(Long pid, HttpServletResponse response) throws StatusFailException, StatusForbiddenException;
}