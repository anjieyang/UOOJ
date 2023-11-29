package com.anjieyang.uooj.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */

@Data
public class UserReadContestAnnouncementDTO {

    private Long cid;

    private List<Long> readAnnouncementList;
}