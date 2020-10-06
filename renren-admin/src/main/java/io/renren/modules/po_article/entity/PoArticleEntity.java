package io.renren.modules.po_article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-02 10:08:56
 */
@Data
@TableName("po_article")
public class PoArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 景区名
	 */
	private String name;
	/**
	 * 封面图路径
	 */
	private String coverImg;
	/**
	 * 介绍
	 */
	private String introduce;
	/**
	 * 详情（富文本）
	 */
	private String details;
	/**
	 * 景区评价、星级
	 */
	private Double evaluate;
	/**
	 * 所在区编码（外键 省市联动表code）
	 */
	private String areaId;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 类型 1、景区 2、美食
	 */
	private Integer type;
	/**
	 * 状态:1.顶置  2.正常  3.封禁 4.待修改
	 */
	private Integer status;

}
