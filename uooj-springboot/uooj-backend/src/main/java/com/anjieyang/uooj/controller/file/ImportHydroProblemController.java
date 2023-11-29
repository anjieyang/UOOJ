package com.anjieyang.uooj.controller.file;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.service.file.ImportHydroProblemService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Controller
@RequestMapping("/api/file")
public class ImportHydroProblemController {

    @Autowired
    private ImportHydroProblemService importHydroProblemService;

    /**
     * @param file
     * @MethodName importQDOJProblem
     * @Description zip文件导入题目 仅超级管理员可操作
     * @Return
     * @Since 2022/10/16
     */
    @RequiresRoles("root")
    @RequiresAuthentication
    @ResponseBody
    @PostMapping("/import-hydro-problem")
    public CommonResult<Void> importHydroProblem(@RequestParam("file") MultipartFile file) {
        return importHydroProblemService.importHydroProblem(file);
    }


}