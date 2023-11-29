package com.anjieyang.uooj.pojo.dto;

import com.anjieyang.uooj.pojo.entity.discussion.Reply;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
@Accessors(chain = true)
public class ReplyDTO {

    private Reply reply;

    private Integer did;

    private Integer quoteId;

    private String quoteType;
}