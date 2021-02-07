package com.javaclimb.music.service;

import com.javaclimb.music.entity.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SongServiceTest
{
	@Autowired
	private SongService songService;
	@Test
	void findByname()
	{
		Song byname = songService.findByname("十年");
		System.out.println(byname);
	}
}
