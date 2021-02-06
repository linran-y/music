package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.SongListdao;
import com.javaclimb.music.entity.SongList;
import com.javaclimb.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/5 16:29
 */
@Service
public class SongListServiceImpl implements SongListService
{
	@Autowired
	SongListdao songListDao;

	/**
	 * 增加
	 *
	 * @param songList
	 */
	@Override
	public SongList addSongList(SongList songList)
	{
		SongList save = songListDao.save(songList);
		return save;
	}

	/**
	 * 修改
	 *
	 * @param songList
	 */
	@Override
	public SongList updateSongList(SongList songList)
	{
		SongList save = songListDao.save(songList);
		return save;
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean deleteById(Integer id)
	{
		songListDao.deleteById(id);
		return true;
	}

	/**
	 * 根据主键查询整个对象
	 *
	 * @param id
	 */
	@Override
	public SongList findById(Integer id)
	{
		return songListDao.findById(id).get();
	}

	/**
	 * 查询所有歌单
	 */
	@Override
	public List<SongList> findAll()
	{
		return songListDao.findAll();
	}

	/**
	 * 根据标题精确查询歌单列表
	 *
	 * @param title
	 */
	@Override
	public List<SongList> findByTitle(String title)
	{
		return songListDao.findByTitle(title);
	}

	/**
	 * 根据标题模糊查询歌单列表
	 *
	 * @param title
	 */
	@Override
	public List<SongList> findByTitleLike(String title)
	{
		return songListDao.findByTitleLike(title);
	}

	/**
	 * 根据风格模糊查询歌单列表
	 *
	 * @param style
	 */
	@Override
	public List<SongList> findByStyleLike(String style)
	{
		return songListDao.findByStyleLike(style);
	}
}
