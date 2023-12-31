package com.anjieyang.uooj.controller.file;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.anjieyang.uooj.service.file.UserFileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Controller
@RequestMapping("/api/file")
public class UserFileController {

    @Autowired
    private UserFileService userFileService;

    @RequestMapping("/generate-user-excel")
    @RequiresAuthentication
    @RequiresRoles("root")
    public void generateUserExcel(@RequestParam("key") String key, HttpServletResponse response) throws IOException {
        userFileService.generateUserExcel(key, response);
    }

}