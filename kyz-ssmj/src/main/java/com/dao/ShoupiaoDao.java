package com.dao;

import com.entity.ShoupiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShoupiaoView;

/**
 * 售票 Dao 接口
 *
 * @author 
 * @since 2021-02-24
 */
public interface ShoupiaoDao extends BaseMapper<ShoupiaoEntity> {

   List<ShoupiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

   List<HashMap<String,String>> graph();

}
