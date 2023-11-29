package com.anjieyang.uooj.dao.training;

import com.baomidou.mybatisplus.extension.service.IService;
import com.anjieyang.uooj.pojo.entity.training.TrainingRegister;
import java.util.List;

public interface TrainingRegisterEntityService extends IService<TrainingRegister> {


    public List<String> getAlreadyRegisterUidList(Long tid);

}
