package com.anjieyang.uooj.pojo.dto;

import com.anjieyang.uooj.pojo.entity.common.Announcement;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class AnnouncementDTO {
    @NotBlank(message = "比赛id不能为空")
    private Long cid;

    private Announcement announcement;
}