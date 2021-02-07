package com.javaclimb.music.dao;

import com.javaclimb.music.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/7 14:32
 */
public interface Consumerdao extends JpaRepository<Consumer,Integer>
{
	public Consumer findByUsernameAndPassword(String username,String password);

	public Consumer findByUsername(String username);

	@Query("select t from Consumer t where t.username like %?1%")
	public List<Consumer> findByUsernameLike(String username);
}
