package com.javaclimb.music.service;

/*
 *@auther ykw
 *@date 2021/2/7 14:33
 */

import com.javaclimb.music.entity.Consumer;

import java.util.List;

/**
 * 前端用户service接口
 */
public interface ConsumerService
{
	/**
	 *增加
	 */
	public Consumer add(Consumer consumer);

	/**
	 *修改
	 */
	public Consumer update(Consumer consumer);

	/**
	 * 删除
	 */
	public boolean deleteById(Integer id);

	/**
	 * 根据主键查询整个对象
	 */
	public Consumer findById(Integer id);

	/**
	 * 查询所有用户
	 */
	public List<Consumer> findAll();

	/**
	 * check密码
	 */
	public Consumer verifyPassword(String username,String password);

	/**
	 * 根据用户名查询
	 */
	public Consumer findByUsername(String username);

	/**
	 * 根据用户名模糊
	 */
	public List<Consumer> findByUsernameLike(String username);
}
