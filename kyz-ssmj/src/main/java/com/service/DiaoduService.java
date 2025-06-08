package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiaoduEntity;
import java.util.Map;

/**
 * 车辆调度 服务类
 * @author 
 * @since 2021-02-24
 */
public interface DiaoduService extends IService<DiaoduEntity> {

     PageUtils queryPage(Map<String, Object> params);

}