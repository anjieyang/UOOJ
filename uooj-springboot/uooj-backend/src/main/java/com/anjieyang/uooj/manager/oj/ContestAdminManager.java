package com.anjieyang.uooj.manager.oj;


import com.anjieyang.uooj.validator.GroupValidator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.dao.contest.ContestEntityService;
import com.anjieyang.uooj.dao.contest.ContestPrintEntityService;
import com.anjieyang.uooj.dao.contest.ContestRecordEntityService;
import com.anjieyang.uooj.pojo.dto.CheckACDTO;
import com.anjieyang.uooj.pojo.entity.contest.Contest;
import com.anjieyang.uooj.pojo.entity.contest.ContestPrint;
import com.anjieyang.uooj.pojo.entity.contest.ContestRecord;
import com.anjieyang.uooj.shiro.AccountProfile;
import com.anjieyang.uooj.utils.Constants;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Component
public class ContestAdminManager {

    @Autowired
    private ContestEntityService contestEntityService;

    @Autowired
    private ContestRecordEntityService contestRecordEntityService;

    @Autowired
    private ContestPrintEntityService contestPrintEntityService;

    @Autowired
    private GroupValidator groupValidator;

    public IPage<ContestRecord> getContestACInfo(Long cid, Integer currentPage, Integer limit) throws StatusForbiddenException {

        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();

        // 获取本场比赛的状态
        Contest contest = contestEntityService.getById(cid);

        // 超级管理员或者该比赛的创建者，则为比赛管理者
        boolean isRoot = SecurityUtils.getSubject().hasRole("root");

        if (!isRoot
                && !contest.getUid().equals(userRolesVo.getUid())
                && !(contest.getIsGroup() && groupValidator.isGroupRoot(userRolesVo.getUid(), contest.getGid()))) {
            throw new StatusForbiddenException("对不起，您无权限操作！");
        }

        if (currentPage == null || currentPage < 1) currentPage = 1;
        if (limit == null || limit < 1) limit = 30;

        // 获取当前比赛的，状态为ac，未被校验的排在前面
        return contestRecordEntityService.getACInfo(currentPage,
                limit,
                Constants.Contest.RECORD_AC.getCode(),
                cid,
                contest.getUid(),
                contest.getStartTime(),
                contest.getEndTime());

    }


    public void checkContestACInfo(CheckACDTO checkACDto) throws StatusFailException, StatusForbiddenException {

        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();

        // 获取本场比赛的状态
        Contest contest = contestEntityService.getById(checkACDto.getCid());

        // 超级管理员或者该比赛的创建者，则为比赛管理者
        boolean isRoot = SecurityUtils.getSubject().hasRole("root");

        if (!isRoot
                && !contest.getUid().equals(userRolesVo.getUid())
                && !(contest.getIsGroup() && groupValidator.isGroupRoot(userRolesVo.getUid(), contest.getGid()))) {
            throw new StatusForbiddenException("对不起，您无权限操作！");
        }

        boolean isOk = contestRecordEntityService.updateById(
                new ContestRecord().setChecked(checkACDto.getChecked()).setId(checkACDto.getId()));

        if (!isOk) {
            throw new StatusFailException("修改失败！");
        }

    }

    public IPage<ContestPrint> getContestPrint(Long cid, Integer currentPage, Integer limit) throws StatusForbiddenException {

        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        // 获取本场比赛的状态
        Contest contest = contestEntityService.getById(cid);

        // 超级管理员或者该比赛的创建者，则为比赛管理者
        boolean isRoot = SecurityUtils.getSubject().hasRole("root");

        if (!isRoot
                && !contest.getUid().equals(userRolesVo.getUid())
                && !(contest.getIsGroup() && groupValidator.isGroupRoot(userRolesVo.getUid(), contest.getGid()))) {
            throw new StatusForbiddenException("对不起，您无权限操作！");
        }

        if (currentPage == null || currentPage < 1) currentPage = 1;
        if (limit == null || limit < 1) limit = 30;

        // 获取当前比赛的，未被确定的排在签名

        IPage<ContestPrint> contestPrintIPage = new Page<>(currentPage, limit);

        QueryWrapper<ContestPrint> contestPrintQueryWrapper = new QueryWrapper<>();
        contestPrintQueryWrapper.select("id", "cid", "username", "realname", "status", "gmt_create")
                .eq("cid", cid)
                .orderByAsc("status")
                .orderByDesc("gmt_create");

        return contestPrintEntityService.page(contestPrintIPage, contestPrintQueryWrapper);
    }


    public void checkContestPrintStatus(Long id, Long cid) throws StatusFailException, StatusForbiddenException {

        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        // 获取本场比赛的状态
        Contest contest = contestEntityService.getById(cid);

        // 超级管理员或者该比赛的创建者，则为比赛管理者
        boolean isRoot = SecurityUtils.getSubject().hasRole("root");

        if (!isRoot && !contest.getUid().equals(userRolesVo.getUid())
                && !(contest.getIsGroup() && groupValidator.isGroupRoot(userRolesVo.getUid(), contest.getGid()))) {
            throw new StatusForbiddenException("对不起，您无权限操作！");
        }

        boolean isOk = contestPrintEntityService.updateById(new ContestPrint().setId(id).setStatus(1));

        if (!isOk) {
            throw new StatusFailException("修改失败！");
        }
    }

}