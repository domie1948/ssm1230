package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.DiaoduEntity;

import com.service.DiaoduService;
import com.entity.view.DiaoduView;
import com.service.CarService;
import com.entity.CarEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆调度
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/diaodu")
public class DiaoduController {
    private static final Logger logger = LoggerFactory.getLogger(DiaoduController.class);

    @Autowired
    private DiaoduService diaoduService;


    @Autowired
    private TokenService tokenService;


    //级联表service
    @Autowired
    private CarService carService;

    //字典表map
    Map<String, Map<Integer, String>> dictionaryMap;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        PageUtils page = diaoduService.queryPage(params);

        //字典表数据转换
        List<DiaoduView> list =(List<DiaoduView>)page.getList();
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        for(DiaoduView c:list){
            this.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DiaoduEntity diaodu = diaoduService.selectById(id);
        if(diaodu !=null){
            //entity转view
            DiaoduView view = new DiaoduView();
            BeanUtils.copyProperties( diaodu , view );//把实体数据重构到view中

            //级联表
            CarEntity car = carService.selectById(diaodu.getCarId());
            if(car != null){
                BeanUtils.copyProperties( car , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
            }
            //字典表字典转换
            ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
            dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
            this.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DiaoduEntity diaodu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,diaodu:{}",this.getClass().getName(),diaodu.toString());
        Wrapper<DiaoduEntity> queryWrapper = new EntityWrapper<DiaoduEntity>()
            .eq("car_id", diaodu.getCarId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiaoduEntity diaoduEntity = diaoduService.selectOne(queryWrapper);
        if(diaoduEntity==null){
            diaodu.setCreateTime(new Date());
            diaoduService.insert(diaodu);
            return R.ok();
        }else {
            return R.error(511,"该车辆已经被排班了");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DiaoduEntity diaodu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,diaodu:{}",this.getClass().getName(),diaodu.toString());
        //根据字段查询是否有相同数据
        Wrapper<DiaoduEntity> queryWrapper = new EntityWrapper<DiaoduEntity>()
            .notIn("id",diaodu.getId())
            .eq("car_id", diaodu.getCarId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiaoduEntity diaoduEntity = diaoduService.selectOne(queryWrapper);
        if(diaoduEntity==null){
            diaoduService.updateById(diaodu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"一辆车不允许排多次班");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        diaoduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    *字典表数据转换
    */
    public void dictionaryConvert(DiaoduView diaoduView){
        //当前表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(diaoduView.getSchedulingTypes()))){
            diaoduView.setSchedulingValue(dictionaryMap.get("scheduling_types").get(diaoduView.getSchedulingTypes()));
        }

        //级联表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(diaoduView.getCarTypes()))){
            diaoduView.setCarValue(dictionaryMap.get("car_types").get(diaoduView.getCarTypes()));
        }
    }


}

