package com.javaclimb.music.service;

import com.javaclimb.music.entity.SongList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongListServiceTest
{
	@Autowired
	private SongListService songListService;

	@Test
	void addSongList()
	{
		SongList songList= new SongList();
		songList.setStyle("欧美");
		songList.setIntroduction("1111");
		songList.setPic("/111");
		songList.setTitle("dwd213a");
		songListService.addSongList(songList);
	}

	@Test
	void updateSongList()
	{
		SongList byId = songListService.findById(1);
		byId.setTitle("123123");
		songListService.updateSongList(byId);
	}

	@Test
	void deleteById()
	{
		songListService.deleteById(1);
	}

	@Test
	void findById()
	{
		SongList byId = songListService.findById(2);
		System.out.println(byId);
	}

	@Test
	void findAll()
	{
		List<SongList> all = songListService.findAll();
		System.out.println(all);
	}

	@Test
	void findByTitle()
	{
		List<SongList> dwda = songListService.findByTitle("dwda");
		System.out.println(dwda);
	}

	@Test
	void findByTitleLike()
	{
		List<SongList> dwda = songListService.findByTitleLike("dw");
		System.out.println(dwda);
	}

	@Test
	void findByStyleLike()
	{
		List<SongList> dwda = songListService.findByStyleLike("美");
		System.out.println(dwda);
	}
}
