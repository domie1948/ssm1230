package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CarEntity;
import java.util.Map;

/**
 * 车辆 服务类
 * @author 
 * @since 2021-02-24
 */
public interface CarService extends IService<CarEntity> {

     PageUtils queryPage(Map<String, Object> params);

}