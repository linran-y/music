package com.javaclimb.music.service;

import com.javaclimb.music.entity.Admin;

/*
 *@auther ykw
 *@date 2021/1/31 21:07
 */
public interface AdminService
{
	/*
	* 验证密码是否成功
	* */
	Admin verifyPassword(String name, String password);
}
