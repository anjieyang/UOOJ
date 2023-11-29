package com.anjieyang.uooj.service.file;

import org.springframework.web.multipart.MultipartFile;
import com.anjieyang.uooj.common.result.CommonResult;
import com.anjieyang.uooj.pojo.entity.group.Group;

import java.util.Map;

public interface ImageService {

    public CommonResult<Map<Object, Object>> uploadAvatar(MultipartFile image);

    public CommonResult<Group> uploadGroupAvatar(MultipartFile image, Long gid);

    public CommonResult<Map<Object, Object>> uploadCarouselImg(MultipartFile image);
}
