package com.anjieyang.uooj.controller.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anjieyang.uooj.annotation.AnonApi;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.service.oj.RankService;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 处理排行榜数据
 */
@RestController
@RequestMapping("/api")
@AnonApi
public class RankController {

    @Autowired
    private RankService rankService;

    /**
     * @MethodName get-rank-list
     * @Params * @param null
     * @Description 获取排行榜数据
     * @Return CommonResult
     * @Since 2020/10/27
     */
    @GetMapping("/get-rank-list")
    public CommonResult<IPage> getRankList(@RequestParam(value = "limit", required = false) Integer limit,
                                           @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                           @RequestParam(value = "searchUser", required = false) String searchUser,
                                           @RequestParam(value = "type", required = true) Integer type) {
        return rankService.getRankList(limit, currentPage, searchUser, type);
    }
}