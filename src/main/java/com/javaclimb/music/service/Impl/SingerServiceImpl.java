package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.Singerdao;
import com.javaclimb.music.entity.Singer;
import com.javaclimb.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/2 11:50
 */
@Service
public class SingerServiceImpl implements SingerService
{

	@Autowired
	private Singerdao singerdao;
	/**
	 * 增加
	 *
	 * @param singer
	 */
	@Override
	public Singer insert(Singer singer)
	{
		Singer saver = singerdao.save(singer);
		return saver;
	}

	/**
	 * 修改
	 *
	 * @param singer
	 */
	@Override
	public Singer update(Singer singer)
	{
		Singer saver = singerdao.save(singer);
		return saver;
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean delete(Integer id)
	{
		singerdao.deleteById(id);
		return true;
	}

	/**
	 * 根据主键查询整个对象
	 *
	 * @param id
	 */
	@Override
	public Singer findById(Integer id)
	{
		return singerdao.findById(id).get();
	}

	/**
	 * 查询所有歌手
	 */
	@Override
	public List<Singer> allSinger()
	{
		return singerdao.findAll();
	}

	/**
	 * 根据歌手名字模糊查询列表
	 *
	 * @param name
	 */
	@Override
	public List<Singer> singerOfName(String name)
	{
		return singerdao.findByNameLike(name);
	}

	/**
	 * 根据性别查询
	 *
	 * @param sex
	 */
	@Override
	public List<Singer> singerOfSex(Integer sex)
	{
		return singerdao.findBySex(sex);
	}
}
