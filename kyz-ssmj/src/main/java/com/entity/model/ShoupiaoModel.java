package com.entity.model;

import com.entity.ShoupiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 售票
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-24
 */
public class ShoupiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆id
     */
    private String carId;


    /**
     * 售卖金额
     */
    private Double actualMoney;


    /**
     * 售票状态
     */
    private Integer shoupiaoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：车辆id
	 */
    public String getCarId() {
        return carId;
    }


    /**
	 * 设置：车辆id
	 */
    public void setCarId(String carId) {
        this.carId = carId;
    }
    /**
	 * 获取：售卖金额
	 */
    public Double getActualMoney() {
        return actualMoney;
    }


    /**
	 * 设置：售卖金额
	 */
    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }
    /**
	 * 获取：售票状态
	 */
    public Integer getShoupiaoTypes() {
        return shoupiaoTypes;
    }


    /**
	 * 设置：售票状态
	 */
    public void setShoupiaoTypes(Integer shoupiaoTypes) {
        this.shoupiaoTypes = shoupiaoTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
