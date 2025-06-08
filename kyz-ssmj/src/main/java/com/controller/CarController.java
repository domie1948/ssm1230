package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.DiaoduEntity;
import com.service.DiaoduService;
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

import com.entity.CarEntity;

import com.service.CarService;
import com.entity.view.CarView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/car")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;
    @Autowired
    private DiaoduService diaoduService;


    @Autowired
    private TokenService tokenService;


    //级联表service

    //字典表map
    Map<String, Map<Integer, String>> dictionaryMap;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        PageUtils page = carService.queryPage(params);

        //字典表数据转换
        List<CarView> list =(List<CarView>)page.getList();
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        for(CarView c:list){
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
        CarEntity car = carService.selectById(id);
        if(car !=null){
            //entity转view
            CarView view = new CarView();
            BeanUtils.copyProperties( car , view );//把实体数据重构到view中

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
    public R save(@RequestBody CarEntity car, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,car:{}",this.getClass().getName(),car.toString());
        Wrapper<CarEntity> queryWrapper = new EntityWrapper<CarEntity>()
            .eq("car_name", car.getCarName())
            .eq("car_driver", car.getCarDriver())
            .eq("repair_content", car.getRepairContent())
            .eq("car_types", car.getCarTypes())
            .eq("car_number", car.getCarNumber())
            .eq("start", car.getStart())
            .eq("end", car.getEnd())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CarEntity carEntity = carService.selectOne(queryWrapper);
        if(carEntity==null){
            car.setCreateTime(new Date());
            carService.insert(car);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CarEntity car, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,car:{}",this.getClass().getName(),car.toString());
        //根据字段查询是否有相同数据
        Wrapper<CarEntity> queryWrapper = new EntityWrapper<CarEntity>()
            .notIn("id",car.getId())
            .eq("car_name", car.getCarName())
            .eq("car_driver", car.getCarDriver())
            .eq("repair_content", car.getRepairContent())
            .eq("car_types", car.getCarTypes())
            .eq("car_number", car.getCarNumber())
            .eq("start", car.getStart())
            .eq("end", car.getEnd())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CarEntity carEntity = carService.selectOne(queryWrapper);
        if(carEntity==null){
            carService.updateById(car);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        carService.deleteBatchIds(Arrays.asList(ids));
        //级联删除调度表
        diaoduService.delete(new EntityWrapper<DiaoduEntity>().in("car_id",ids));
        return R.ok();
    }

    /**
    *字典表数据转换
    */
    public void dictionaryConvert(CarView carView){
        //当前表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(carView.getCarTypes()))){
            carView.setCarValue(dictionaryMap.get("car_types").get(carView.getCarTypes()));
        }

        //级联表的字典字段
    }


}

