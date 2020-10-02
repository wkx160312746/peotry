package io.renren.modules.sys_user.entity;

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
 * @date 2020-10-02 13:04:58
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户自增id
	 */
	@TableId
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码MD5
	 */
	private String password;
	/**
	 * 注册手机号
	 */
	private String phone;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 状态 1：正常 2：禁用
	 */
	private Integer status;
	/**
	 * 头像路径
	 */
	private String headImg;

}
