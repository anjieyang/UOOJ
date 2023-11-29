package com.anjieyang.uooj.service.file.impl;

import org.springframework.stereotype.Service;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.manager.file.ContestFileManager;
import com.anjieyang.uooj.service.file.ContestFileService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class ContestFileServiceImpl implements ContestFileService {

    @Resource
    private ContestFileManager contestFileManager;

    @Override
    public void downloadContestRank(Long cid, Boolean forceRefresh, Boolean removeStar, Boolean isContainsAfterContestJudge,
                                    HttpServletResponse response) throws StatusFailException, IOException, StatusForbiddenException {
        contestFileManager.downloadContestRank(cid, forceRefresh, removeStar, isContainsAfterContestJudge, response);
    }

    @Override
    public void downloadContestACSubmission(Long cid, Boolean excludeAdmin, String splitType, HttpServletResponse response) throws StatusFailException, StatusForbiddenException {
        contestFileManager.downloadContestACSubmission(cid, excludeAdmin, splitType, response);
    }

    @Override
    public void downloadContestPrintText(Long id, HttpServletResponse response) throws StatusForbiddenException {
        contestFileManager.downloadContestPrintText(id, response);
    }
}