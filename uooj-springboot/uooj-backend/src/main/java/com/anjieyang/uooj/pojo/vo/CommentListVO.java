package com.anjieyang.uooj.pojo.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.HashMap;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Data
public class CommentListVO {

    private IPage<CommentVO> commentList;

    private HashMap<Integer, Boolean>  commentLikeMap;
}