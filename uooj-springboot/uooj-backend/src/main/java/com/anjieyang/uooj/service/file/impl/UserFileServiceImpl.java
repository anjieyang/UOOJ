package com.anjieyang.uooj.service.file.impl;

import org.springframework.stereotype.Service;
import com.anjieyang.uooj.manager.file.UserFileManager;
import com.anjieyang.uooj.service.file.UserFileService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class UserFileServiceImpl implements UserFileService {

    @Resource
    private UserFileManager userFileManager;


    @Override
    public void generateUserExcel(String key, HttpServletResponse response) throws IOException {
        userFileManager.generateUserExcel(key, response);
    }
}