package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;
import com.javaclimb.music.entity.ListSong;
import com.javaclimb.music.service.ListSongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/6 12:53
 */
@Api(tags="后台歌单歌曲相关操作")
@RestController
@RequestMapping("/listsong")
public class ListSongController
{
	@Autowired
	private ListSongService listSongService;
	/**
	 * 给歌单添加歌曲
	 */
	@ApiOperation("给歌单添加歌曲")
	@PostMapping("/add")
	public Result add(@RequestBody ListSong listSong)
	{
		ListSong add = listSongService.add(listSong);
		return Result.success("新增成功",add);
	}

	/**
	 * 根据歌单id查询歌曲
	 */
	@ApiOperation("根据歌单id查询歌曲")
	@GetMapping("/query")
	public Result query(@RequestParam("id") Integer songlistid)
	{
		List<ListSong> bySongListid = listSongService.findBySongListid(songlistid);
		return Result.success("查询成功",bySongListid);
	}

	/**
	 * 根据歌曲id和歌单id删除歌单里的歌曲
	 */
	@ApiOperation("根据歌曲id和歌单id删除歌单里的歌曲")
	@GetMapping("/delete")
	public Result delete(@RequestParam("songid") Integer songid,@RequestParam("songlistid") Integer songlistid )
	{
		listSongService.deleteBySongIdAndSongListId(songid,songlistid);
		return Result.success("删除成功",true);
	}

	/**
	 * 根据id删除歌单里的歌曲
	 */
	@ApiOperation("根据id删除歌单里的歌曲")
	@GetMapping("/deletebyid")
	public Result deletebyid(@RequestParam("id")Integer id)
	{
		listSongService.deleteById(id);
		return Result.success("删除成功",true);
	}
}
