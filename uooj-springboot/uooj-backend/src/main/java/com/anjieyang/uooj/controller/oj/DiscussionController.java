package com.anjieyang.uooj.controller.oj;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.anjieyang.uooj.annotation.AnonApi;
import com.anjieyang.uooj.annotation.UOOJAccess;
import com.anjieyang.uooj.annotation.UOOJAccessEnum;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.problem.Category;
import com.anjieyang.uooj.pojo.entity.discussion.Discussion;
import com.anjieyang.uooj.pojo.entity.discussion.DiscussionReport;
import com.anjieyang.uooj.pojo.vo.DiscussionVO;
import com.anjieyang.uooj.service.oj.DiscussionService;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 负责讨论与评论模块的数据接口
 */
@RestController
@RequestMapping("/api")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;


    @GetMapping("/get-discussion-list")
    @AnonApi
    @UOOJAccess({UOOJAccessEnum.PUBLIC_DISCUSSION})
    public CommonResult<IPage<Discussion>> getDiscussionList(@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
                                                             @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                                             @RequestParam(value = "cid", required = false) Integer categoryId,
                                                             @RequestParam(value = "pid", required = false) String pid,
                                                             @RequestParam(value = "onlyMine", required = false, defaultValue = "false") Boolean onlyMine,
                                                             @RequestParam(value = "keyword", required = false) String keyword,
                                                             @RequestParam(value = "admin", defaultValue = "false") Boolean admin) {

        return discussionService.getDiscussionList(limit, currentPage, categoryId, pid, onlyMine, keyword, admin);

    }

    @GetMapping("/get-discussion-detail")
    @AnonApi
    public CommonResult<DiscussionVO> getDiscussion(@RequestParam(value = "did", required = true) Integer did) {
        return discussionService.getDiscussion(did);
    }

    @PostMapping("/discussion")
    @RequiresPermissions("discussion_add")
    @RequiresAuthentication
    @UOOJAccess({UOOJAccessEnum.PUBLIC_DISCUSSION})
    public CommonResult<Void> addDiscussion(@RequestBody Discussion discussion) {
        return discussionService.addDiscussion(discussion);
    }

    @PutMapping("/discussion")
    @RequiresPermissions("discussion_edit")
    @RequiresAuthentication
    @UOOJAccess({UOOJAccessEnum.PUBLIC_DISCUSSION})
    public CommonResult<Void> updateDiscussion(@RequestBody Discussion discussion) {
        return discussionService.updateDiscussion(discussion);
    }

    @DeleteMapping("/discussion")
    @RequiresPermissions("discussion_del")
    @RequiresAuthentication
    @UOOJAccess({UOOJAccessEnum.PUBLIC_DISCUSSION})
    public CommonResult<Void> removeDiscussion(@RequestParam("did") Integer did) {
        return discussionService.removeDiscussion(did);
    }

    @GetMapping("/discussion-like")
    @RequiresAuthentication
    public CommonResult<Void> addDiscussionLike(@RequestParam("did") Integer did,
                                                @RequestParam("toLike") Boolean toLike) {
        return discussionService.addDiscussionLike(did, toLike);
    }

    @GetMapping("/discussion-category")
    @AnonApi
    public CommonResult<List<Category>> getDiscussionCategory() {
        return discussionService.getDiscussionCategory();
    }

    @PostMapping("/discussion-category")
    @RequiresAuthentication
    @RequiresRoles("root")
    public CommonResult<List<Category>> upsertDiscussionCategory(@RequestBody List<Category> categoryList) {
        return discussionService.upsertDiscussionCategory(categoryList);
    }


    @PostMapping("/discussion-report")
    @RequiresAuthentication
    public CommonResult<Void> addDiscussionReport(@RequestBody DiscussionReport discussionReport) {
        return discussionService.addDiscussionReport(discussionReport);
    }

}