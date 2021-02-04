package com.javaclimb.music.service.Impl;

import com.javaclimb.music.entity.Song;
import com.javaclimb.music.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongServiceImplTest
{
	@Autowired
	private SongService songService;
	@Test
	void add()//测试歌曲插入
	{
		Song song= new Song();
		song.setName("凤凰传奇");
		songService.add(song);
	}

	@Test
	void update()//测试歌曲更新
	{
		Song song=songService.findById(2);
		song.setName("模特");
		Song song1 = songService.update(song);
		System.out.println(song1);
	}

	@Test
	void deleteById()//测试根据id删除
	{
		songService.deleteById(1);
	}

	@Test
	void findById()//测试根据id查询
	{
		Song byId = songService.findById(1);
		System.out.println(byId);
	}

	@Test
	void findAll()//测试查出所有
	{
		List<Song> all = songService.findAll();
		System.out.println(all);
	}

	@Test
	void findByNameLike()//根据歌曲名字模糊查询
	{
		List<Song> all = songService.findByNameLike("凤凰传奇");
		System.out.println(all);
	}

	@Test
	void findBySingerId()//根据歌手id来查询
	{
		List<Song> all = songService.findBySingerId(1);
		System.out.println(all);
	}
}
