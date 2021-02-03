package com.javaclimb.music.dao;

import com.javaclimb.music.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *@auther ykw
 *@date 2021/1/31 21:03
 */
public interface Admindao extends JpaRepository<Admin, Integer>
{
	Admin findByUsernameAndPassword(String username, String password);
}
