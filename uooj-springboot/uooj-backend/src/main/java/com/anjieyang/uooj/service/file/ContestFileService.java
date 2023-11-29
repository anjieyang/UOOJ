package com.anjieyang.uooj.service.file;


import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

public interface ContestFileService {

    public void downloadContestRank(Long cid, Boolean forceRefresh, Boolean removeStar, Boolean isContainsAfterContestJudge,
                                    HttpServletResponse response) throws StatusFailException, IOException, StatusForbiddenException;

    public void downloadContestACSubmission(Long cid, Boolean excludeAdmin, String splitType, HttpServletResponse response) throws StatusFailException, StatusForbiddenException;

    public void downloadContestPrintText(Long id, HttpServletResponse response) throws StatusForbiddenException;
}