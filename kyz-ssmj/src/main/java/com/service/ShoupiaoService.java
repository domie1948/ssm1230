package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShoupiaoEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 售票 服务类
 * @author 
 * @since 2021-02-24
 */
public interface ShoupiaoService extends IService<ShoupiaoEntity> {

     PageUtils queryPage(Map<String, Object> params);

     List<HashMap<String, String>> graph();

}