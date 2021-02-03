package com.javaclimb.music.service.Impl;

import com.javaclimb.music.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceImplTest
{
	@Autowired
	private AdminServiceImpl adminService;
	@Test
	void test1()
	{
		Admin admin = adminService.verifyPassword("admin", "123456");
		System.out.println(admin);
	}
}
