package com.entity.view;

import com.entity.DiaoduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆调度
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-24
 */
@TableName("diaodu")
public class DiaoduView extends DiaoduEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 排班的值
		*/
		private String schedulingValue;



		//级联表 car
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
				* 车辆类型的值
				*/
				private String carValue;
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

	public DiaoduView() {

	}

	public DiaoduView(DiaoduEntity diaoduEntity) {
		try {
			BeanUtils.copyProperties(this, diaoduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 排班的值
			*/
			public String getSchedulingValue() {
				return schedulingValue;
			}
			/**
			* 设置： 排班的值
			*/
			public void setSchedulingValue(String schedulingValue) {
				this.schedulingValue = schedulingValue;
			}




				//级联表的get和set car
					/**
					* 获取： 车辆名字
					*/
					public String getCarName() {
						return carName;
					}
					/**
					* 设置： 车辆名字
					*/
					public void setCarName(String carName) {
						this.carName = carName;
					}
					/**
					* 获取： 司机
					*/
					public String getCarDriver() {
						return carDriver;
					}
					/**
					* 设置： 司机
					*/
					public void setCarDriver(String carDriver) {
						this.carDriver = carDriver;
					}
					/**
					* 获取： 车辆描述
					*/
					public String getRepairContent() {
						return repairContent;
					}
					/**
					* 设置： 车辆描述
					*/
					public void setRepairContent(String repairContent) {
						this.repairContent = repairContent;
					}
					/**
					* 获取： 车辆类型
					*/
					public Integer getCarTypes() {
						return carTypes;
					}
					/**
					* 设置： 车辆类型
					*/
					public void setCarTypes(Integer carTypes) {
						this.carTypes = carTypes;
					}


						/**
						* 获取： 车辆类型的值
						*/
						public String getCarValue() {
							return carValue;
						}
						/**
						* 设置： 车辆类型的值
						*/
						public void setCarValue(String carValue) {
							this.carValue = carValue;
						}
					/**
					* 获取： 车牌号
					*/
					public String getCarNumber() {
						return carNumber;
					}
					/**
					* 设置： 车牌号
					*/
					public void setCarNumber(String carNumber) {
						this.carNumber = carNumber;
					}
					/**
					* 获取： 始发站
					*/
					public String getStart() {
						return start;
					}
					/**
					* 设置： 始发站
					*/
					public void setStart(String start) {
						this.start = start;
					}
					/**
					* 获取： 终点站
					*/
					public String getEnd() {
						return end;
					}
					/**
					* 设置： 终点站
					*/
					public void setEnd(String end) {
						this.end = end;
					}
					/**
					* 获取： 车票金额
					*/
					public Double getSellMoney() {
						return sellMoney;
					}
					/**
					* 设置： 车票金额
					*/
					public void setSellMoney(Double sellMoney) {
						this.sellMoney = sellMoney;
					}










}
