package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.Songdao;
import com.javaclimb.music.entity.Song;
import com.javaclimb.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/4 11:34
 */
@Service
public class SongServiceImpl implements SongService
{
	@Autowired
	private Songdao songdao;
	/**
	 * 增加
	 *
	 * @param song
	 */
	@Override
	public Song add(Song song)
	{
		Date a=new Date();
		song.setUpdateTime(a);
		song.setCreateTime(a);//新增插入和创建时间
		Song sqlsong = songdao.save(song);
		return sqlsong;
	}

	/**
	 * 修改
	 *
	 * @param song
	 */
	@Override
	public Song update(Song song)
	{
		Date a=new Date();
		song.setUpdateTime(a);
		Song sqlsong = songdao.save(song);
		return sqlsong;
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean deleteById(Integer id)
	{
		songdao.deleteById(id);
		return true;
	}

	/**
	 * 根据主键查询整个对象
	 *
	 * @param id
	 */
	@Override
	public Song findById(Integer id)
	{
		Song song = songdao.findById(id).get();
		return song;
	}

	/**
	 * 查询所有歌曲
	 */
	@Override
	public List<Song> findAll()
	{
		return songdao.findAll();
	}

	/**
	 * 根据歌名模糊查询列表
	 *
	 * @param name
	 */
	@Override
	public List<Song> findByNameLike(String name)
	{
		return songdao.findByNameLike(name);
	}

	/**
	 * 根据歌手id查询
	 *
	 * @param singerId
	 */
	@Override
	public List<Song> findBySingerId(Integer singerId)
	{
		return songdao.findBySingerId(singerId);
	}
}
