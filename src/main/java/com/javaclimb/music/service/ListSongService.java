package com.javaclimb.music.service;

import com.javaclimb.music.entity.ListSong;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/6 12:19
 */
public interface ListSongService
{
	/**
	 *增加
	 */
	public ListSong add(ListSong listSong);

	/**
	 *修改
	 */
	public ListSong update(ListSong listSong);

	/**
	 * 删除
	 */
	public boolean deleteById(Integer id);

	/**
	 * 根据歌曲id和歌单id删除
	 */
	public boolean deleteBySongIdAndSongListId(Integer songId,Integer songListId);

	/**
	 * 根据主键查询整个对象
	 */
	public ListSong findById(Integer id);

	/**
	 * 查询所有歌单里面的歌曲
	 */
	public List<ListSong> findAll();

	/**
	 * 根据歌单id查询所有的歌曲
	 */
	public List<ListSong> findBySongListid(Integer songListId);
}
