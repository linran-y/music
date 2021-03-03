package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;
import com.javaclimb.music.entity.Rank;
import com.javaclimb.music.service.RankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 *@auther ykw
 *@date 2021/3/2 17:09
 */
@Api(tags="前台歌单评分相关操作")
@RestController
@RequestMapping("/rank")
public class RankController
{
	@Autowired
	private RankService rankService;

	/**
	 * 新增评分
	 */
	@ApiOperation("新增评分")
	@PostMapping("/addscore")
	public Result addscore(@RequestBody Rank rank)
	{
		Rank add = rankService.add(rank);
		if(add!=null)
		{
			return Result.success("新增成功",add);
		}
		else {
			return Result.fail("新增失败",null);
		}

	}
	/**
	 * 查询歌单评分
	 */
	@ApiOperation("查询歌单评分")
	@GetMapping("/getscore")
	public Result addscore(@RequestParam Integer songlistid)
	{
		Integer getrank = rankService.getrank(songlistid);
		return Result.success("查询成功",getrank);
	}
}
