package com.anjieyang.uooj.service.group.member.impl;

import com.anjieyang.uooj.service.group.member.GroupMemberService;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusNotFoundException;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.common.result.ResultStatus;
import com.anjieyang.uooj.manager.group.member.GroupMemberManager;
import com.anjieyang.uooj.pojo.entity.group.GroupMember;
import com.anjieyang.uooj.pojo.vo.GroupMemberVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LengYun
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class GroupMemberServiceImpl implements GroupMemberService {

    @Autowired
    private GroupMemberManager groupMemberManager;

    @Override
    public CommonResult<IPage<GroupMemberVO>> getMemberList(Integer limit, Integer currentPage, String keyword, Integer auth, Long gid) {
        try {
            return CommonResult.successResponse(groupMemberManager.getMemberList(limit, currentPage, keyword, auth, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<IPage<GroupMemberVO>> getApplyList(Integer limit, Integer currentPage, String keyword, Integer auth, Long gid) {
        try {
            return CommonResult.successResponse(groupMemberManager.getApplyList(limit, currentPage, keyword, auth, gid));
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> addMember(Long gid, String code, String reason) {
        try {
            groupMemberManager.addMember(gid, code, reason);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }

    @Override
    public CommonResult<Void> updateMember(GroupMember groupMember) {
        try {
            groupMemberManager.updateMember(groupMember);
            return CommonResult.successResponse();
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        }
    }


    @Override
    public CommonResult<Void> deleteMember(String uid, Long gid) {
        try {
            groupMemberManager.deleteMember(uid, gid);
            return CommonResult.successResponse();
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }


    @Override
    public CommonResult<Void> exitGroup(Long gid) {
        try {
            groupMemberManager.exitGroup(gid);
            return CommonResult.successResponse();
        } catch (StatusNotFoundException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.NOT_FOUND);
        } catch (StatusForbiddenException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FORBIDDEN);
        } catch (StatusFailException e) {
            return CommonResult.errorResponse(e.getMessage(), ResultStatus.FAIL);
        }
    }
}
