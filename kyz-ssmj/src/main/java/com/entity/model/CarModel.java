package com.entity.model;

import com.entity.CarEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-24
 */
public class CarModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆名字
     */
    private String carName;


    /**
     * 司机
     */
    private String carDriver;


    /**
     * 车辆描述
     */
    private String repairContent;


    /**
     * 车辆类型
     */
    private Integer carTypes;


    /**
     * 车牌号
     */
    private String carNumber;


    /**
     * 始发站
     */
    private String start;


    /**
     * 终点站
     */
    private String end;


    /**
     * 车票金额
     */
    private Double sellMoney;


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
	 * 获取：车辆名字
	 */
    public String getCarName() {
        return carName;
    }


    /**
	 * 设置：车辆名字
	 */
    public void setCarName(String carName) {
        this.carName = carName;
    }
    /**
	 * 获取：司机
	 */
    public String getCarDriver() {
        return carDriver;
    }


    /**
	 * 设置：司机
	 */
    public void setCarDriver(String carDriver) {
        this.carDriver = carDriver;
    }
    /**
	 * 获取：车辆描述
	 */
    public String getRepairContent() {
        return repairContent;
    }


    /**
	 * 设置：车辆描述
	 */
    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }
    /**
	 * 获取：车辆类型
	 */
    public Integer getCarTypes() {
        return carTypes;
    }


    /**
	 * 设置：车辆类型
	 */
    public void setCarTypes(Integer carTypes) {
        this.carTypes = carTypes;
    }
    /**
	 * 获取：车牌号
	 */
    public String getCarNumber() {
        return carNumber;
    }


    /**
	 * 设置：车牌号
	 */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    /**
	 * 获取：始发站
	 */
    public String getStart() {
        return start;
    }


    /**
	 * 设置：始发站
	 */
    public void setStart(String start) {
        this.start = start;
    }
    /**
	 * 获取：终点站
	 */
    public String getEnd() {
        return end;
    }


    /**
	 * 设置：终点站
	 */
    public void setEnd(String end) {
        this.end = end;
    }
    /**
	 * 获取：车票金额
	 */
    public Double getSellMoney() {
        return sellMoney;
    }


    /**
	 * 设置：车票金额
	 */
    public void setSellMoney(Double sellMoney) {
        this.sellMoney = sellMoney;
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
