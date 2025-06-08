package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShoupiaoDao;
import com.entity.ShoupiaoEntity;
import com.service.ShoupiaoService;
import com.entity.view.ShoupiaoView;

/**
 * 售票 服务实现类
 * @author 
 * @since 2021-02-24
 */
@Service("shoupiaoService")
@Transactional
public class ShoupiaoServiceImpl extends ServiceImpl<ShoupiaoDao, ShoupiaoEntity> implements ShoupiaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShoupiaoView> page =new Query<ShoupiaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


    @Override
    public List<HashMap<String, String>> graph() {
        List<HashMap<String, String>> graph = baseMapper.graph();
        return graph;
    }
}
