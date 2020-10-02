package io.renren.modules.po_comment.entity;

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
 * @date 2020-10-02 10:35:35
 */
@Data
@TableName("po_comment")
public class PoCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 文章id（外键到文章表的id）
	 */
	private Long articleId;
	/**
	 * 用户id（外键到用户表的id）
	 */
	private Long userId;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 点赞数
	 */
	private Integer agreeSize;
	/**
	 * 状态:1.正常 2.禁用 
	 */
	private Integer stutas;

}
