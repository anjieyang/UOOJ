package com.anjieyang.uooj.manager.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import com.anjieyang.uooj.dao.user.UserInfoEntityService;
import com.anjieyang.uooj.dao.user.UserRoleEntityService;
import com.anjieyang.uooj.pojo.entity.common.File;
import com.anjieyang.uooj.validator.GroupValidator;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.exception.StatusFailException;
import com.anjieyang.uooj.common.exception.StatusForbiddenException;
import com.anjieyang.uooj.common.exception.StatusSystemErrorException;
import com.anjieyang.uooj.dao.common.FileEntityService;
import com.anjieyang.uooj.dao.group.GroupEntityService;
import com.anjieyang.uooj.pojo.entity.group.Group;
import com.anjieyang.uooj.pojo.entity.user.Role;
import com.anjieyang.uooj.pojo.entity.user.UserInfo;
import com.anjieyang.uooj.pojo.vo.UserRolesVO;
import com.anjieyang.uooj.shiro.AccountProfile;
import com.anjieyang.uooj.utils.Constants;

import java.util.Map;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Component
@Slf4j(topic = "uooj")
public class ImageManager {

    @Autowired
    private FileEntityService fileEntityService;

    @Autowired
    private UserInfoEntityService userInfoEntityService;

    @Autowired
    private GroupEntityService groupEntityService;

    @Autowired
    private GroupValidator groupValidator;

    @Autowired
    private UserRoleEntityService userRoleEntityService;

    @Transactional(rollbackFor = Exception.class)
    public Map<Object, Object> uploadAvatar(MultipartFile image) throws StatusFailException, StatusSystemErrorException {
        if (image == null) {
            throw new StatusFailException("上传的头像图片文件不能为空！");
        }
        if (image.getSize() > 1024 * 1024 * 2) {
            throw new StatusFailException("上传的头像图片文件大小不能大于2M！");
        }
        //获取文件后缀
        String suffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png,webp".toUpperCase().contains(suffix.toUpperCase())) {
            throw new StatusFailException("请选择jpg,jpeg,gif,png,webp格式的头像图片！");
        }
        //若不存在该目录，则创建目录
        FileUtil.mkdir(Constants.File.USER_AVATAR_FOLDER.getPath());
        //通过UUID生成唯一文件名
        String filename = IdUtil.simpleUUID() + "." + suffix;
        try {
            //将文件保存指定目录
            image.transferTo(FileUtil.file(Constants.File.USER_AVATAR_FOLDER.getPath() +
                    java.io.File.separator + filename));
        } catch (Exception e) {
            log.error("头像文件上传异常-------------->", e);
            throw new StatusSystemErrorException("服务器异常：头像上传失败！");
        }

        // 获取当前登录用户
        AccountProfile accountProfile = (AccountProfile) SecurityUtils.getSubject().getPrincipal();

        // 将当前用户所属的file表中avatar类型的实体的delete设置为1；
        fileEntityService.updateFileToDeleteByUidAndType(accountProfile.getUid(), "avatar");

        //更新user_info里面的avatar
        UpdateWrapper<UserInfo> userInfoUpdateWrapper = new UpdateWrapper<>();
        userInfoUpdateWrapper.set("avatar", Constants.File.IMG_API.getPath() + filename)
                .eq("uuid", accountProfile.getUid());
        userInfoEntityService.update(userInfoUpdateWrapper);

        // 插入file表记录
        File imgFile = new File();
        imgFile.setName(filename).setFolderPath(Constants.File.USER_AVATAR_FOLDER.getPath())
                .setFilePath(Constants.File.USER_AVATAR_FOLDER.getPath() + java.io.File.separator + filename)
                .setSuffix(suffix)
                .setType("avatar")
                .setUid(accountProfile.getUid());
        fileEntityService.saveOrUpdate(imgFile);
        // 更新session
        accountProfile.setAvatar(Constants.File.IMG_API.getPath() + filename);

        UserRolesVO userRolesVo = userRoleEntityService.getUserRoles(accountProfile.getUid(), null);

        return MapUtil.builder()
                .put("uid", userRolesVo.getUid())
                .put("username", userRolesVo.getUsername())
                .put("nickname", userRolesVo.getNickname())
                .put("avatar", Constants.File.IMG_API.getPath() + filename)
                .put("email", userRolesVo.getEmail())
                .put("number", userRolesVo.getNumber())
                .put("school", userRolesVo.getSchool())
                .put("course", userRolesVo.getCourse())
                .put("signature", userRolesVo.getSignature())
                .put("realname", userRolesVo.getRealname())
                .put("github", userRolesVo.getGithub())
                .put("blog", userRolesVo.getBlog())
                .put("cfUsername", userRolesVo.getCfUsername())
                .put("roleList", userRolesVo.getRoles().stream().map(Role::getRole))
                .map();
    }

    @Transactional(rollbackFor = Exception.class)
    public Group uploadGroupAvatar(MultipartFile image, Long gid) throws StatusFailException, StatusSystemErrorException, StatusForbiddenException {
        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();

        boolean isRoot = SecurityUtils.getSubject().hasRole("root");
        if (!isRoot && !groupValidator.isGroupRoot(userRolesVo.getUid(), gid)) {
            throw new StatusForbiddenException("对不起，您无权限操作！");
        }

        if (image == null) {
            throw new StatusFailException("上传的头像图片文件不能为空！");
        }
        if (image.getSize() > 1024 * 1024 * 2) {
            throw new StatusFailException("上传的头像图片文件大小不能大于2M！");
        }

        String suffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png,webp".toUpperCase().contains(suffix.toUpperCase())) {
            throw new StatusFailException("请选择jpg,jpeg,gif,png,webp格式的头像图片！");
        }

        FileUtil.mkdir(Constants.File.GROUP_AVATAR_FOLDER.getPath());

        String filename = IdUtil.simpleUUID() + "." + suffix;
        try {
            image.transferTo(FileUtil.file(Constants.File.GROUP_AVATAR_FOLDER.getPath() + java.io.File.separator + filename));
        } catch (Exception e) {
            log.error("头像文件上传异常-------------->", e);
            throw new StatusSystemErrorException("服务器异常：头像上传失败！");
        }

        fileEntityService.updateFileToDeleteByGidAndType(gid, "avatar");

        UpdateWrapper<Group> GroupUpdateWrapper = new UpdateWrapper<>();
        GroupUpdateWrapper.set("avatar", Constants.File.IMG_API.getPath() + filename)
                .eq("id", gid);
        groupEntityService.update(GroupUpdateWrapper);

        File imgFile = new File();
        imgFile.setName(filename).setFolderPath(Constants.File.GROUP_AVATAR_FOLDER.getPath())
                .setFilePath(Constants.File.GROUP_AVATAR_FOLDER.getPath() + java.io.File.separator + filename)
                .setSuffix(suffix)
                .setType("avatar")
                .setGid(gid);
        fileEntityService.saveOrUpdate(imgFile);

        Group group = groupEntityService.getById(gid);

        return group;
    }

    @Transactional(rollbackFor = Exception.class)
    public Map<Object, Object> uploadCarouselImg(MultipartFile image) throws StatusFailException, StatusSystemErrorException {

        if (image == null) {
            throw new StatusFailException("上传的图片文件不能为空！");
        }

        //获取文件后缀
        String suffix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png,webp,jfif,svg".toUpperCase().contains(suffix.toUpperCase())) {
            throw new StatusFailException("请选择jpg,jpeg,gif,png,webp,jfif,svg格式的头像图片！");
        }
        //若不存在该目录，则创建目录
        FileUtil.mkdir(Constants.File.HOME_CAROUSEL_FOLDER.getPath());
        //通过UUID生成唯一文件名
        String filename = IdUtil.simpleUUID() + "." + suffix;
        try {
            //将文件保存指定目录
            image.transferTo(FileUtil.file(Constants.File.HOME_CAROUSEL_FOLDER.getPath() + java.io.File.separator + filename));
        } catch (Exception e) {
            log.error("图片文件上传异常-------------->{}", e.getMessage());
            throw new StatusSystemErrorException("服务器异常：图片上传失败！");
        }

        // 获取当前登录用户
        AccountProfile userRolesVo = (AccountProfile) SecurityUtils.getSubject().getPrincipal();


        // 插入file表记录
        File imgFile = new File();
        imgFile.setName(filename).setFolderPath(Constants.File.HOME_CAROUSEL_FOLDER.getPath())
                .setFilePath(Constants.File.HOME_CAROUSEL_FOLDER.getPath() + java.io.File.separator + filename)
                .setSuffix(suffix)
                .setType("carousel")
                .setUid(userRolesVo.getUid());
        fileEntityService.saveOrUpdate(imgFile);

        return MapUtil.builder()
                .put("id", imgFile.getId())
                .put("url", Constants.File.IMG_API.getPath() + filename)
                .map();
    }

}