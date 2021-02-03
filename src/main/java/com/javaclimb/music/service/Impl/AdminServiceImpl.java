package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.Admindao;
import com.javaclimb.music.entity.Admin;
import com.javaclimb.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@auther ykw
 *@date 2021/1/31 21:07
 * 管理员表实现类，实现管理员的相关操作
 */
@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private Admindao admindao;
	@Override
	public Admin verifyPassword(String name, String password)
	{
		return admindao.findByUsernameAndPassword(name,password);
	}
}
