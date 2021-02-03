package com.javaclimb.music.service.Impl;

import com.javaclimb.music.entity.Singer;
import com.javaclimb.music.service.SingerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SingerServiceImplTest
{
	@Autowired
	SingerService singerService;

	@Test
	void test1()
	{
		Singer singer=new Singer();
		singer.setName("linranyyy");
		singer.setLocation("先");
		singer.setBirth(new Date());
		singer.setIntroduction("好声音");
		singer.setPic("1232131");
		singer.setSex(1);
		for(int i=0;i<9;i++)
		{
			singer.setName("linrany"+i);
			singerService.insert(singer);
		}

	}
	@Test
	void test2()
	{
		Singer singer = singerService.findById(3);
		singer.setSex(0);
		singer.setLocation("济南");
		singerService.update(singer);
	}

}
