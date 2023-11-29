package com.anjieyang.uooj.manager.admin.tag;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.dao.problem.TagClassificationEntityService;
import com.anjieyang.uooj.dao.problem.TagEntityService;
import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.pojo.entity.problem.TagClassification;
import com.anjieyang.uooj.shiro.AccountProfile;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Component
@Slf4j(topic = "uooj")
public class AdminTagManager {

    @Autowired
    private TagEntityService tagEntityService;

    @Autowired
    private TagClassificationEntityService tagClassificationEntityService;

    public Tag addTag(Tag tag) throws StatusFailException {
        QueryWrapper<Tag> tagQueryWrapper = new QueryWrapper<>();
        tagQueryWrapper.eq(tag.getGid() != null, "gid", tag.getGid())
                .eq("name", tag.getName())
                .eq("oj", tag.getOj());
        Tag existTag = tagEntityService.getOne(tagQueryWrapper, false);

        if (existTag != null) {
            throw new StatusFailException("该标签名称已存在！请勿重复添加！");
        }

        boolean isOk = tagEntityService.save(tag);
        if (!isOk) {
            throw new StatusFailException("添加失败");
        }
        return tag;
    }

    public void updateTag(Tag tag) throws StatusFailException {
        boolean isOk = tagEntityService.updateById(tag);
        if (!isOk) {
            throw new StatusFailException("更新失败");
        }
    }

    public void deleteTag(Long tid) throws StatusFailException {
        boolean isOk = tagEntityService.removeById(tid);
        if (!isOk) {
            throw new StatusFailException("删除失败");
        }
        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        log.info("[{}],[{}],tid:[{}],operatorUid:[{}],operatorUsername:[{}]",
                "Admin_Tag", "Delete", tid, userRolesVo.getUid(), userRolesVo.getUsername());
    }

    public List<TagClassification> getTagClassification(String oj) {
        oj = oj.toUpperCase();
        if (oj.equals("ALL")) {
            return tagClassificationEntityService.list();
        } else {
            QueryWrapper<TagClassification> tagClassificationQueryWrapper = new QueryWrapper<>();
            tagClassificationQueryWrapper.eq("oj", oj).orderByAsc("`rank`");
            return tagClassificationEntityService.list(tagClassificationQueryWrapper);
        }
    }

    public TagClassification addTagClassification(TagClassification tagClassification) throws StatusFailException {
        QueryWrapper<TagClassification> tagClassificationQueryWrapper = new QueryWrapper<>();
        tagClassificationQueryWrapper.eq("name", tagClassification.getName())
                .eq("oj", tagClassification.getOj());
        TagClassification existTagClassification = tagClassificationEntityService.getOne(tagClassificationQueryWrapper, false);

        if (existTagClassification != null) {
            throw new StatusFailException("该标签分类名称已存在！请勿重复！");
        }
        boolean isOk = tagClassificationEntityService.save(tagClassification);
        if (!isOk) {
            throw new StatusFailException("添加失败");
        }
        return tagClassification;
    }

    public void updateTagClassification(TagClassification tagClassification) throws StatusFailException {
        boolean isOk = tagClassificationEntityService.updateById(tagClassification);
        if (!isOk) {
            throw new StatusFailException("更新失败");
        }
    }

    public void deleteTagClassification(Long tcid) throws StatusFailException {
        boolean isOk = tagClassificationEntityService.removeById(tcid);
        if (!isOk) {
            throw new StatusFailException("删除失败");
        }
        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        log.info("[{}],[{}],tcid:[{}],operatorUid:[{}],operatorUsername:[{}]",
                "Admin_Tag_Classification", "Delete", tcid, userRolesVo.getUid(), userRolesVo.getUsername());
    }
}