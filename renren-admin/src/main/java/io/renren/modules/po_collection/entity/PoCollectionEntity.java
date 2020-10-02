package io.renren.modules.po_collection.entity;

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
 * @date 2020-10-02 10:33:55
 */
@Data
@TableName("po_collection")
public class PoCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户id（外键用户表id）
	 */
	private Long userId;
	/**
	 * 文章id（外键文章表id）
	 */
	private Long articleId;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
