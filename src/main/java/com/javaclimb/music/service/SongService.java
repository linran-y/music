package com.javaclimb.music.service;

/*
 *@auther ykw
 *@date 2021/2/4 11:24
 */

import com.javaclimb.music.entity.Song;

import java.util.List;

/**
 * 歌曲service接口
 */
public interface SongService
{
	/**
	 *增加
	 */
	public Song add(Song song);
	/**
	 *修改
	 */
	public Song update(Song song);

	/**
	 * 删除
	 */
	public boolean deleteById(Integer id);

	/**
	 * 根据主键查询整个对象
	 */
	public Song findById(Integer id);

	/**
	 * 根据歌曲名查询整个对象
	 */
	public Song findByname(String name);
	/**
	 * 查询所有歌曲
	 */
	public List<Song> findAll();

	/**
	 * 根据歌名模糊查询列表
	 */
	public List<Song> findByNameLike(String name);

	/**
	 * 根据歌手id查询
	 */
	public List<Song> findBySingerId(Integer singerId);
}
