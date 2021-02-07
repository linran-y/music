package com.javaclimb.music.dao;

import com.javaclimb.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/4 11:22
 */
public interface Songdao extends JpaRepository<Song,Integer>
{
	@Query("select t from Song t where t.name like %?1%")//手写查询语句
	List<Song> findByNameLike(String name);

	List<Song> findBySingerId(Integer id);//根据歌手ID来查询

	List<Song> findByName(String  name);
}
