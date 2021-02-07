package com.javaclimb.music.service;

import com.javaclimb.music.entity.Consumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsumerServiceTest
{
	@Autowired
	private ConsumerService consumerService;
	@Test
	void add()
	{
		Consumer consumer=new Consumer();
		consumer.setAvator("3123");
		Date a=new Date();
		consumer.setBirth(a);
		consumer.setCreateTime(a);
		consumer.setEmail("1312");
		consumer.setIntroduction("312");
		consumerService.add(consumer);
	}

	@Test
	void update()
	{
		Consumer consumer=consumerService.findById(1);
		consumer.setLocation("阿可视对讲");
		consumerService.update(consumer);
	}

	@Test
	void delete()
	{
		consumerService.deleteById(2);
	}


	@Test
	void findAll()
	{
		List<Consumer> all = consumerService.findAll();
		System.out.println(all);
	}

	@Test
	void verifyPassword()
	{
		Consumer zans = consumerService.verifyPassword("zns", "123456");
		System.out.println(zans);
	}

	@Test
	void findByUsername()
	{
		Consumer byUsername = consumerService.findByUsername("31");
		System.out.println(byUsername);
	}
}
