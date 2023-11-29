package com.anjieyang.uooj.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class SubmitIdListDTO {
    @NotEmpty(message = "查询的提交id列表不能为空")
    private List<Long> submitIds;

    private Long cid;
}