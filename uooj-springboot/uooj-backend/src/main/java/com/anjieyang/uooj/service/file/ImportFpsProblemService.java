package com.anjieyang.uooj.service.file;

import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.result.CommonResult;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
public interface ImportFpsProblemService {

    public CommonResult<Void> importFPSProblem(MultipartFile file);
}