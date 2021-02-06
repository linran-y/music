package com.javaclimb.music.service;

/*
 *@auther ykw
 *@date 2021/2/5 16:28
 */

import com.javaclimb.music.entity.SongList;

import java.util.List;

/**
 * 歌单service接口
 */
public interface SongListService
{
	/**
	 *增加
	 */
	public SongList addSongList(SongList songList);

	/**
	 *修改
	 */
	public SongList updateSongList(SongList songList);

	/**
	 * 删除
	 */
	public boolean deleteById(Integer id);

	/**
	 * 根据主键查询整个对象
	 */
	public SongList findById(Integer id);

	/**
	 * 查询所有歌单
	 */
	public List<SongList> findAll();

	/**
	 * 根据标题精确查询歌单列表
	 */
	public List<SongList> findByTitle(String title);

	/**
	 * 根据标题模糊查询歌单列表
	 */
	public List<SongList> findByTitleLike(String title);

	/**
	 * 根据风格模糊查询歌单列表
	 */
	public List<SongList> findByStyleLike(String style);
}
