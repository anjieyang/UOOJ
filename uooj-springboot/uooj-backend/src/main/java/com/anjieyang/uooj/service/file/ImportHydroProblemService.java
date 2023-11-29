package com.anjieyang.uooj.service.file;

import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.result.CommonResult;

/**
 * @Author Anjie Yang
 * @Date 2022/10/16
 */
public interface ImportHydroProblemService {

    public CommonResult<Void> importHydroProblem(MultipartFile file);
}
