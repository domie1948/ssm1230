package com.entity.vo;

import com.entity.CarEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("car")
public class CarVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车辆名字
     */

    @TableField(value = "car_name")
    private String carName;


    /**
     * 司机
     */

    @TableField(value = "car_driver")
    private String carDriver;


    /**
     * 车辆描述
     */

    @TableField(value = "repair_content")
    private String repairContent;


    /**
     * 车辆类型
     */

    @TableField(value = "car_types")
    private Integer carTypes;


    /**
     * 车牌号
     */

    @TableField(value = "car_number")
    private String carNumber;


    /**
     * 始发站
     */

    @TableField(value = "start")
    private String start;


    /**
     * 终点站
     */

    @TableField(value = "end")
    private String end;


    /**
     * 车票金额
     */

    @TableField(value = "sell_money")
    private Double sellMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：车辆名字
	 */
    public String getCarName() {
        return carName;
    }


    /**
	 * 获取：车辆名字
	 */

    public void setCarName(String carName) {
        this.carName = carName;
    }
    /**
	 * 设置：司机
	 */
    public String getCarDriver() {
        return carDriver;
    }


    /**
	 * 获取：司机
	 */

    public void setCarDriver(String carDriver) {
        this.carDriver = carDriver;
    }
    /**
	 * 设置：车辆描述
	 */
    public String getRepairContent() {
        return repairContent;
    }


    /**
	 * 获取：车辆描述
	 */

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }
    /**
	 * 设置：车辆类型
	 */
    public Integer getCarTypes() {
        return carTypes;
    }


    /**
	 * 获取：车辆类型
	 */

    public void setCarTypes(Integer carTypes) {
        this.carTypes = carTypes;
    }
    /**
	 * 设置：车牌号
	 */
    public String getCarNumber() {
        return carNumber;
    }


    /**
	 * 获取：车牌号
	 */

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    /**
	 * 设置：始发站
	 */
    public String getStart() {
        return start;
    }


    /**
	 * 获取：始发站
	 */

    public void setStart(String start) {
        this.start = start;
    }
    /**
	 * 设置：终点站
	 */
    public String getEnd() {
        return end;
    }


    /**
	 * 获取：终点站
	 */

    public void setEnd(String end) {
        this.end = end;
    }
    /**
	 * 设置：车票金额
	 */
    public Double getSellMoney() {
        return sellMoney;
    }


    /**
	 * 获取：车票金额
	 */

    public void setSellMoney(Double sellMoney) {
        this.sellMoney = sellMoney;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
