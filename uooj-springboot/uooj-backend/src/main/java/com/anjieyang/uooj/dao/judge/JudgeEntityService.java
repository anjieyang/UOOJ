package com.anjieyang.uooj.dao.judge;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.anjieyang.uooj.pojo.entity.judge.Judge;
import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardSubmissionVO;
import com.anjieyang.uooj.pojo.vo.JudgeVO;
import com.anjieyang.uooj.pojo.vo.ProblemCountVO;

import java.util.Date;
import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Anjie Yang
 * @since 2020-10-23
 */

public interface JudgeEntityService extends IService<Judge> {

    IPage<JudgeVO> getCommonJudgeList(Integer limit,
                                      Integer currentPage,
                                      String searchPid,
                                      Integer status,
                                      String username,
                                      String uid,
                                      Boolean completeProblemID,
                                      Long gid);

    IPage<JudgeVO> getContestJudgeList(Integer limit,
                                       Integer currentPage,
                                       String displayId,
                                       Long cid,
                                       Integer status,
                                       String username,
                                       String uid,
                                       Boolean beforeContestSubmit,
                                       String rule,
                                       Date startTime,
                                       Date sealRankTime,
                                       String sealTimeUid,
                                       Boolean completeProblemID);


    void failToUseRedisPublishJudge(Long submitId, Long pid, Boolean isContest);

    ProblemCountVO getContestProblemCount(Long pid,
                                          Long cpid,
                                          Long cid,
                                          Date startTime,
                                          Date sealRankTime,
                                          List<String> adminList);

    ProblemCountVO getProblemCount(Long pid, Long gid);

    public int getTodayJudgeNum();

    public List<ProblemCountVO> getProblemListCount(List<Long> pidList);

    public List<ContestScrollBoardSubmissionVO> getContestScrollBoardSubmission(Long cid, List<String> removeUidList);
}
