package com.javaclimb.music.dao;

import com.javaclimb.music.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/2 11:49
 */
public interface Singerdao extends JpaRepository<Singer, Integer>
{

	List<Singer>findBySex(Integer sex);
	@Query("select t from Singer t where t.name like %?1%")
	List<Singer>findByNameLike(String name);

}
