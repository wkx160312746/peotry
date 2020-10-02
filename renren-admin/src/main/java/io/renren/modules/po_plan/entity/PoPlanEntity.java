package io.renren.modules.po_plan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:39:04
 */
@Data
@TableName("po_plan")
public class PoPlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	@TableId
	private Long id;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 地点
	 */
	private String site;
	/**
	 * 用户id（外键用户表id）
	 */
	private Integer uid;
	/**
	 * 交通方式
	 */
	private String traffic;
	/**
	 * 预估时间
	 */
	private Date time;

}
