package com.anjieyang.uooj.pojo.vo;

import com.anjieyang.uooj.pojo.entity.problem.Tag;
import com.anjieyang.uooj.pojo.entity.problem.TagClassification;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Anjie Yang
 * @Date 2022/8/3
 */
@Data
public class ProblemTagVO implements Serializable {
    /**
     * 标签分类
     */
    private TagClassification classification;

    /**
     * 标签列表
     */
    private List<Tag> tagList;

}
