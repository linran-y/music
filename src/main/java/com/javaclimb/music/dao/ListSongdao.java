package com.javaclimb.music.dao;

import com.javaclimb.music.entity.ListSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/6 12:18
 */
public interface ListSongdao extends JpaRepository<ListSong,Integer>
{
	/*根据歌单id和歌曲id来查询*/
	@Query("select t from ListSong t where t.songId= ?1 and t.songListId = ?2")
	public List<ListSong> findBySongIdAndSongListId(Integer SongId,Integer SongListId);
	/*根据歌单id来查询歌曲*/
	public List<ListSong>findBySongListId(Integer id);
}
