package com.anjieyang.uooj.controller.oj;


import com.anjieyang.uooj.pojo.vo.AccessVO;
import com.anjieyang.uooj.pojo.vo.ProblemVO;
import com.anjieyang.uooj.pojo.vo.TrainingRankVO;
import com.anjieyang.uooj.pojo.vo.TrainingVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.*;
import com.anjieyang.uooj.annotation.AnonApi;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.dto.RegisterTrainingDTO;
import com.anjieyang.uooj.service.oj.TrainingService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 处理训练题单的请求
 */

@RestController
@RequestMapping("/api")
public class TrainingController {

    @Resource
    private TrainingService trainingService;

    /**
     * @param limit
     * @param currentPage
     * @param keyword
     * @param categoryId
     * @param auth
     * @MethodName getTrainingList
     * @Description 获取训练题单列表，可根据关键词、类别、权限、类型过滤
     * @Return
     * @Since 2021/11/20
     */
    @GetMapping("/get-training-list")
    @AnonApi
    public CommonResult<IPage<TrainingVO>> getTrainingList(@RequestParam(value = "limit", required = false) Integer limit,
                                                           @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                           @RequestParam(value = "keyword", required = false) String keyword,
                                                           @RequestParam(value = "categoryId", required = false) Long categoryId,
                                                           @RequestParam(value = "auth", required = false) String auth) {

        return trainingService.getTrainingList(limit, currentPage, keyword, categoryId, auth);
    }


    /**
     * @param tid
     * @MethodName getTraining
     * @Description 根据tid获取指定训练详情
     * @Return
     * @Since 2021/11/20
     */
    @GetMapping("/get-training-detail")
    @RequiresAuthentication
    public CommonResult<TrainingVO> getTraining(@RequestParam(value = "tid") Long tid) {
        return trainingService.getTraining(tid);
    }

    /**
     * @param tid
     * @MethodName getTrainingProblemList
     * @Description 根据tid获取指定训练的题单题目列表
     * @Return
     * @Since 2021/11/20
     */
    @GetMapping("/get-training-problem-list")
    @RequiresAuthentication
    public CommonResult<List<ProblemVO>> getTrainingProblemList(@RequestParam(value = "tid") Long tid) {
        return trainingService.getTrainingProblemList(tid);
    }

    /**
     * @param registerTrainingDto
     * @MethodName toRegisterTraining
     * @Description 注册校验私有权限的训练
     * @Return
     * @Since 2021/11/20
     */
    @PostMapping("/register-training")
    @RequiresAuthentication
    public CommonResult<Void> toRegisterTraining(@RequestBody RegisterTrainingDTO registerTrainingDto) {
        return trainingService.toRegisterTraining(registerTrainingDto);
    }


    /**
     * @param tid
     * @MethodName getTrainingAccess
     * @Description 私有权限的训练需要获取当前用户是否有进入训练的权限
     * @Return
     * @Since 2021/11/20
     */
    @RequiresAuthentication
    @GetMapping("/get-training-access")
    public CommonResult<AccessVO> getTrainingAccess(@RequestParam(value = "tid") Long tid) {
        return trainingService.getTrainingAccess(tid);
    }


    /**
     * @param tid
     * @param limit
     * @param currentPage
     * @MethodName getTrainingRank
     * @Description 获取训练的排行榜分页
     * @Return
     * @Since 2021/11/22
     */
    @GetMapping("/get-training-rank")
    @RequiresAuthentication
    public CommonResult<IPage<TrainingRankVO>> getTrainingRank(@RequestParam(value = "tid", required = true) Long tid,
                                                               @RequestParam(value = "limit", required = false) Integer limit,
                                                               @RequestParam(value = "currentPage", required = false) Integer currentPage,
                                                               @RequestParam(value = "keyword", required = false) String keyword) {
        return trainingService.getTrainingRank(tid, limit, currentPage, keyword);
    }

}