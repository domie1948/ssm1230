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

import com.entity.ShoupiaoEntity;

import com.service.ShoupiaoService;
import com.entity.view.ShoupiaoView;
import com.service.CarService;
import com.entity.CarEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 售票
 * 后端接口
 * @author
 * @email
 * @date 2021-02-24
*/
@RestController
@Controller
@RequestMapping("/shoupiao")
public class ShoupiaoController {
    private static final Logger logger = LoggerFactory.getLogger(ShoupiaoController.class);

    @Autowired
    private ShoupiaoService shoupiaoService;


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
        PageUtils page = shoupiaoService.queryPage(params);

        //字典表数据转换
        List<ShoupiaoView> list =(List<ShoupiaoView>)page.getList();
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        dictionaryMap = (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        for(ShoupiaoView c:list){
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
        ShoupiaoEntity shoupiao = shoupiaoService.selectById(id);
        if(shoupiao !=null){
            //entity转view
            ShoupiaoView view = new ShoupiaoView();
            BeanUtils.copyProperties( shoupiao , view );//把实体数据重构到view中

            //级联表
            CarEntity car = carService.selectById(shoupiao.getCarId());
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
    public R save(@RequestBody ShoupiaoEntity shoupiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shoupiao:{}",this.getClass().getName(),shoupiao.toString());

            String role = String.valueOf(request.getSession().getAttribute("role"));
            if("售票管理员".equals(role)){
                shoupiao.setShoupiaoTypes(1);
            }
            shoupiao.setCreateTime(new Date());
            shoupiaoService.insert(shoupiao);
            return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/graph")
    public R graph(){
        List<HashMap<String, String>> graph = shoupiaoService.graph();
        return R.ok().put("data", graph);
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShoupiaoEntity shoupiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shoupiao:{}",this.getClass().getName(),shoupiao.toString());
            String role = String.valueOf(request.getSession().getAttribute("role"));
            if("检票管理员".equals(role)){
                shoupiao.setShoupiaoTypes(2);
            }
            shoupiaoService.updateById(shoupiao);//根据id更新
            return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        shoupiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    *字典表数据转换
    */
    public void dictionaryConvert(ShoupiaoView shoupiaoView){
        //当前表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(shoupiaoView.getShoupiaoTypes()))){
            shoupiaoView.setShoupiaoValue(dictionaryMap.get("shoupiao_types").get(shoupiaoView.getShoupiaoTypes()));
        }

        //级联表的字典字段
        if(StringUtil.isNotEmpty(String.valueOf(shoupiaoView.getCarTypes()))){
            shoupiaoView.setCarValue(dictionaryMap.get("car_types").get(shoupiaoView.getCarTypes()));
        }
    }


}

