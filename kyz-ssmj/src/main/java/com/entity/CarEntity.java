package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 车辆
 *
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("car")
public class CarEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CarEntity() {

	}

	public CarEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Car{" +
            "id=" + id +
            ", carName=" + carName +
            ", carDriver=" + carDriver +
            ", repairContent=" + repairContent +
            ", carTypes=" + carTypes +
            ", carNumber=" + carNumber +
            ", start=" + start +
            ", end=" + end +
            ", sellMoney=" + sellMoney +
            ", createTime=" + createTime +
        "}";
    }
}
