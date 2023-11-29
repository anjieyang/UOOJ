package com.anjieyang.uooj.pojo.dto;

import com.anjieyang.uooj.pojo.entity.training.Training;
import com.anjieyang.uooj.pojo.entity.training.TrainingCategory;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: Anjie Yang
 * @Date: 2023/11/28 22:28
 * @Description: 后台管理训练的传输类
 */
@Data
@Accessors(chain = true)
public class TrainingDTO {

    private Training training;

    private TrainingCategory trainingCategory;
}