package com.javaclimb.music.entity;

/*
 *@auther ykw
 *@date 2021/2/7 14:28
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 前端用户
 */
@Table(name="consumer")
@Data
@Entity
public class Consumer
{
	/*主键*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	/*账号*/
	private String username;
	/*密码*/
	private String password;
	/*性别*/
	private Integer sex;
	/*手机号*/
	private String phoneNum;
	/*电子邮箱*/
	private String email;
	/*生日*/
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date birth;
	/*签名*/
	private String introduction;
	/*地区*/
	private String location;
	/*头像*/
	private String avator;
	/*创建时间*/
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:dd")
	private Date createTime;
	/*更新时间*/
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:dd")
	private Date updateTime;
}
