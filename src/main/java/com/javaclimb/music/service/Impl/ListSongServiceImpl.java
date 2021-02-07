package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.ListSongdao;
import com.javaclimb.music.entity.ListSong;
import com.javaclimb.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/6 12:26
 */
@Service
public class ListSongServiceImpl implements ListSongService
{
	@Autowired
	private ListSongdao listSongdao;
	/**
	 * 增加
	 *
	 * @param listSong
	 */
	@Override
	public ListSong add(ListSong listSong)
	{
		return listSongdao.save(listSong);
	}

	/**
	 * 修改
	 *
	 * @param listSong
	 */
	@Override
	public ListSong update(ListSong listSong)
	{
		return listSongdao.save(listSong);
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean deleteById(Integer id)
	{
		listSongdao.deleteById(id);
		return true;
	}

	/**
	 * 根据歌曲id和歌单id删除
	 *
	 * @param songId
	 * @param songListId
	 */
	@Override
	public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId)
	{
		ListSong bySongIdAndSongListId = listSongdao.findBySongIdAndSongListId(songId, songListId).get(0);
		listSongdao.delete(bySongIdAndSongListId);
		return true;
	}

	/**
	 * 根据主键查询整个对象
	 *
	 * @param id
	 */
	@Override
	public ListSong findById(Integer id)
	{
		return listSongdao.findById(id).get();
	}

	/**
	 * 查询所有歌单里面的歌曲
	 */
	@Override
	public List<ListSong> findAll()
	{
		return listSongdao.findAll();
	}

	/**
	 * 根据歌单id查询所有的歌曲
	 *
	 * @param songListId
	 */
	@Override
	public List<ListSong> findBySongListid(Integer songListId)
	{
		return listSongdao.findBySongListId(songListId);
	}
}
