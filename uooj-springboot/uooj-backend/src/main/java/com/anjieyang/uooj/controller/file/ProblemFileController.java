package com.anjieyang.uooj.controller.file;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.service.file.ProblemFileService;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Controller
@RequestMapping("/api/file")
public class ProblemFileController {

    @Autowired
    private ProblemFileService problemFileService;


    /**
     * @param file
     * @MethodName importProblem
     * @Description zip文件导入题目 仅超级管理员可操作
     * @Return
     * @Since 2021/5/27
     */
    @RequiresRoles("root")
    @RequiresAuthentication
    @ResponseBody
    @PostMapping("/import-problem")
    public CommonResult<Void> importProblem(@RequestParam("file") MultipartFile file) {
        return problemFileService.importProblem(file);
    }


    /**
     * @param pidList
     * @param response
     * @MethodName exportProblem
     * @Description 导出指定的题目包括测试数据生成zip 仅超级管理员可操作
     * @Return
     * @Since 2021/5/28
     */
    @GetMapping("/export-problem")
    @RequiresAuthentication
    @RequiresRoles("root")
    public void exportProblem(@RequestParam("pid") List<Long> pidList, HttpServletResponse response) {
        problemFileService.exportProblem(pidList, response);
    }

}