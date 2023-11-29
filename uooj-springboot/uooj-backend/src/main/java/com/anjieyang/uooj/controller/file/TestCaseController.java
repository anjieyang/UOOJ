package com.anjieyang.uooj.controller.file;

import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.service.file.TestCaseService;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Controller
@RequestMapping("/api/file")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;


    @PostMapping("/upload-testcase-zip")
    @ResponseBody
    @RequiresAuthentication
    public CommonResult<Map<Object, Object>> uploadTestcaseZip(@RequestParam("file") MultipartFile file,
                                                               @RequestParam(value = "mode", defaultValue = "default") String mode,
                                                               @RequestParam(value = "gid", required = false) Long gid) {
        return testCaseService.uploadTestcaseZip(file, gid, mode);
    }


    @GetMapping("/download-testcase")
    @RequiresAuthentication
    public void downloadTestcase(@RequestParam("pid") Long pid, HttpServletResponse response) throws StatusFailException, StatusForbiddenException {
        testCaseService.downloadTestcase(pid, response);
    }
}