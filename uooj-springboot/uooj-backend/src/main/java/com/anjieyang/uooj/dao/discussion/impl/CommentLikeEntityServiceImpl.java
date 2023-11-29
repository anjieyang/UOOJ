package com.anjieyang.uooj.dao.discussion.impl;

import com.anjieyang.uooj.dao.discussion.CommentLikeEntityService;
import com.anjieyang.uooj.mapper.CommentLikeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.anjieyang.uooj.pojo.entity.discussion.CommentLike;


/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description:
 */
@Service
public class CommentLikeEntityServiceImpl extends ServiceImpl<CommentLikeMapper, CommentLike> implements CommentLikeEntityService {
}