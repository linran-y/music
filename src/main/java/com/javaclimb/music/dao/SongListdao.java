package com.javaclimb.music.dao;

import com.javaclimb.music.entity.SongList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/5 16:27
 */
public interface SongListdao extends JpaRepository<SongList,Integer>
{
	List<SongList> findByTitle(String title);

	@Query("select t from SongList t where t.title like %?1%")
	List<SongList> findByTitleLike(String title);

	@Query("select t from SongList t where t.style like %?1%")
	List<SongList> findByStyleLike(String style);
}
