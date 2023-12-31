package com.anjieyang.uooj.crawler.problem;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Slf4j(topic = "uooj")
public class ProblemContext {

    ProblemStrategy problemStrategy;

    public ProblemContext(ProblemStrategy problemStrategy) {
        this.problemStrategy = problemStrategy;
    }

    //上下文接口
    public ProblemStrategy.RemoteProblemInfo getProblemInfo(String problemId, String author) throws Exception {
        try {
            return problemStrategy.getProblemInfo(problemId, author);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            log.error("获取题目详情失败---------------->{}", e);
            throw e;
        }
    }

    //上下文接口
    public ProblemStrategy.RemoteProblemInfo getProblemInfoByLogin(String problemId, String author, String username, String password) throws Exception {

        try {
            return problemStrategy.getProblemInfoByLogin(problemId, author, username, password);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            log.error("获取题目详情失败---------------->{}", e);
        }
        return null;
    }
}