package com.anjieyang.uooj.service.file;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserFileService {

    public void generateUserExcel(String key, HttpServletResponse response) throws IOException;
}
