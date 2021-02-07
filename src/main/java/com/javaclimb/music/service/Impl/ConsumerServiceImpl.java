package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.Consumerdao;
import com.javaclimb.music.entity.Consumer;
import com.javaclimb.music.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/7 14:38
 */
@Service
public class ConsumerServiceImpl implements ConsumerService
{
	@Autowired
	private Consumerdao consumerdao;
	/**
	 * 增加
	 *
	 * @param consumer
	 */
	@Override
	public Consumer add(Consumer consumer)
	{
		Date a=new Date();
		consumer.setCreateTime(a);
		consumer.setUpdateTime(a);
		return consumerdao.save(consumer);
	}

	/**
	 * 修改
	 *
	 * @param consumer
	 */
	@Override
	public Consumer update(Consumer consumer)
	{
		Date a=new Date();
		consumer.setUpdateTime(a);
		return consumerdao.save(consumer);
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean deleteById(Integer id)
	{
		consumerdao.deleteById(id);
		return true;
	}

	/**
	 * 根据主键查询整个对象
	 *
	 * @param id
	 */
	@Override
	public Consumer findById(Integer id)
	{
		return consumerdao.findById(id).get();
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<Consumer> findAll()
	{
		return consumerdao.findAll();
	}

	/**
	 * check密码
	 *
	 * @param username
	 * @param password
	 */
	@Override
	public Consumer verifyPassword(String username, String password)
	{
		return consumerdao.findByUsernameAndPassword(username,password);
	}

	/**
	 * 根据用户名查询
	 *
	 * @param username
	 */
	@Override
	public Consumer findByUsername(String username)
	{
		return consumerdao.findByUsername(username);
	}

	/**
	 * 根据用户名模糊
	 *
	 * @param username
	 */
	@Override
	public List<Consumer> findByUsernameLike(String username)
	{
		return consumerdao.findByUsernameLike(username);
	}
}
