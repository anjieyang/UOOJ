package com.anjieyang.uooj.service.file;

import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.result.CommonResult;

public interface ImportQDUOJProblemService {

    public CommonResult<Void> importQDOJProblem(MultipartFile file);
}
