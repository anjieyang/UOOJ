package com.anjieyang.uooj.controller.oj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anjieyang.uooj.annotation.AnonApi;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardInfoVO;
import com.anjieyang.uooj.pojo.vo.ContestScrollBoardSubmissionVO;
import com.anjieyang.uooj.service.oj.ContestScrollBoardService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/10/3
 */
@RestController
@RequestMapping("/api")
@AnonApi
public class ContestScrollBoardController {

    @Resource
    private ContestScrollBoardService contestScrollBoardService;

    @GetMapping("/get-contest-scroll-board-info")
    public CommonResult<ContestScrollBoardInfoVO> getContestScrollBoardInfo(@RequestParam(value = "cid") Long cid) {
        return contestScrollBoardService.getContestScrollBoardInfo(cid);
    }


    @GetMapping("/get-contest-scroll-board-submission")
    public CommonResult<List<ContestScrollBoardSubmissionVO>> getContestScrollBoardSubmission(
            @RequestParam(value = "cid", required = true) Long cid,
            @RequestParam(value = "removeStar", defaultValue = "false") Boolean removeStar) {
        return contestScrollBoardService.getContestScrollBoardSubmission(cid, removeStar);
    }


}
