package com.anjieyang.uooj.controller.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import com.anjieyang.uooj.annotation.AnonApi;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.ContestRankDTO;
import com.anjieyang.uooj.pojo.vo.ContestOutsideInfoVO;
import com.anjieyang.uooj.service.oj.ContestScoreboardService;

import javax.annotation.Resource;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 处理比赛外榜的相关请求
 */

@RestController
@RequestMapping("/api")
@AnonApi
public class ContestScoreboardController {

    @Resource
    private ContestScoreboardService contestScoreboardService;

    /**
     * @param cid 比赛id
     * @MethodName getContestOutsideInfo
     * @Description 提供比赛外榜所需的比赛信息和题目信息
     * @Return
     * @Since 2021/12/8
     */
    @GetMapping("/get-contest-outsize-info")
    public CommonResult<ContestOutsideInfoVO> getContestOutsideInfo(@RequestParam(value = "cid", required = true) Long cid) {
        return contestScoreboardService.getContestOutsideInfo(cid);
    }

    /**
     * @MethodName getContestScoreBoard
     * @Description 提供比赛外榜排名数据
     * @Return
     * @Since 2021/12/07
     */
    @PostMapping("/get-contest-outside-scoreboard")
    public CommonResult<IPage> getContestOutsideScoreboard(@RequestBody ContestRankDTO contestRankDto) {
        return contestScoreboardService.getContestOutsideScoreboard(contestRankDto);
    }
}