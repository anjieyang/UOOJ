package com.anjieyang.uooj.manager.file;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anjieyang.uooj.pojo.vo.ExcelUserVO;
import com.anjieyang.uooj.utils.RedisUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Component
@Slf4j(topic = "uooj")
public class UserFileManager {

    @Autowired
    private RedisUtils redisUtils;

    public void generateUserExcel(String key, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode(key, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        response.setHeader("Content-Type", "application/xlsx");
        EasyExcel.write(response.getOutputStream(), ExcelUserVO.class).sheet("用户数据").doWrite(getGenerateUsers(key));
    }

    private List<ExcelUserVO> getGenerateUsers(String key) {
        List<ExcelUserVO> result = new LinkedList<>();
        Map<Object, Object> userInfo = redisUtils.hmget(key);
        for (Object hashKey : userInfo.keySet()) {
            String username = (String) hashKey;
            String password = (String) userInfo.get(hashKey);
            result.add(new ExcelUserVO().setUsername(username).setPassword(password));
        }
        return result;
    }
}