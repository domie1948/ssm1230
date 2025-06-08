package com.entity.vo;

import com.entity.DiaoduEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆调度
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("diaodu")
public class DiaoduVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车辆id
     */

    @TableField(value = "car_id")
    private String carId;


    /**
     * 排班
     */

    @TableField(value = "scheduling_types")
    private Integer schedulingTypes;


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
	 * 设置：车辆id
	 */
    public String getCarId() {
        return carId;
    }


    /**
	 * 获取：车辆id
	 */

    public void setCarId(String carId) {
        this.carId = carId;
    }
    /**
	 * 设置：排班
	 */
    public Integer getSchedulingTypes() {
        return schedulingTypes;
    }


    /**
	 * 获取：排班
	 */

    public void setSchedulingTypes(Integer schedulingTypes) {
        this.schedulingTypes = schedulingTypes;
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
