package com.javaclimb.music.service;

import com.javaclimb.music.entity.ListSong;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ListSongServiceTest
{
	@Autowired
	private ListSongService listSongService;
	@Test
	void add()
	{
		ListSong listSong =new ListSong();
		listSong.setSongId(1);
		listSong.setSongListId(3);
		listSongService.add(listSong);
	}

	@Test
	void update()
	{
		ListSong byId = listSongService.findById(5);
		byId.setSongListId(2311);
		listSongService.update(byId);
	}

	@Test
	void delete()
	{
		listSongService.deleteById(1);
	}

	@Test
	void deleteBySongIdAndSongListId()
	{
		listSongService.deleteBySongIdAndSongListId(21,2);
	}

	@Test
	void findById()
	{
		ListSong byId = listSongService.findById(3);
		System.out.println(byId);
	}

	@Test
	void findAll()
	{
		List<ListSong> bySongListid = listSongService.findAll();
		System.out.println(bySongListid);
	}

	@Test
	void findBySongListid()
	{
		List<ListSong> bySongListid = listSongService.findBySongListid(3);
		System.out.println(bySongListid);

	}
}
