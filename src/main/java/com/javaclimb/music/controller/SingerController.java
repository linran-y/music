package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;
import com.javaclimb.music.entity.Singer;
import com.javaclimb.music.service.SingerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/2 12:22
 */
@Api(tags="后台歌手相关操作")
@RestController
@RequestMapping("/singer")
public class SingerController
{
	@Autowired
	private SingerService singerService;

	/**
	 * 添加歌手
	 */
	@ApiOperation("添加歌手")
	@PostMapping(value = "/add")
	public Result addSinger(@RequestBody Singer singer)
	{
		singer.setPic("/img/singerPic/default.jpg");//设置默认图片
		Singer resinger = singerService.insert(singer);
		return Result.success("歌手信息新增成功",resinger);
	}
	/**
	 * 修改歌手
	 */
	@ApiOperation("修改歌手")
	@PostMapping(value = "/update")
	public Result updateSinger(@RequestBody Singer singer)
	{
		Singer resinger = singerService.update(singer);
		return Result.success("歌手信息修改成功",resinger);
	}
	/**
	 * 删除歌手
	 */
	@ApiOperation("根据主键删除歌手")
	@GetMapping(value = "/delete")
	public Result deleteSinger(@RequestParam("id")Integer id)
	{
		String filename=singerService.findById(id).getPic();
		if(!filename.equals("/img/singerPic/default.jpg"))//如果不是默认照片，就一起删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+filename;
			File file=new File(filePath);
			file.delete();
		}
		singerService.delete(id);
		return Result.success("歌手信息删除成功",1);
	}
	/**
	 * 根据主键查询整个对象
	 */
	@ApiOperation("根据主键查询整个对象")
	@GetMapping(value = "/findById")
	public Result findById(@RequestParam("id") Integer id)
	{
		Singer singer = singerService.findById(id);
		return Result.success("歌手信息查询成功",singer);
	}
	/**
	 * 查询所有歌手
	 */
	@ApiOperation("查询所有歌手")
	@GetMapping(value = "/allSinger")
	public Result allSinger()
	{
		List<Singer> singers = singerService.allSinger();
		return Result.success("所有歌手信息查询成功",singers);
	}
	/**
	 * 根据歌手名字模糊查询列表
	 */
	@ApiOperation("根据歌手名字模糊查询列表")
	@GetMapping(value = "/singerOfName")
	public Result singerOfName(@RequestParam("name")String name)
	{
		List<Singer> singers = singerService.singerOfName(name);
		return Result.success("歌手信息查询成功",singers);
	}
	/**
	* 根据性别查询
	*/
	@ApiOperation("根据性别查询")
	@PostMapping(value = "/singerOfSex")
	public Result singerOfSex(@RequestBody Integer id)
	{
		List<Singer> singers = singerService.singerOfSex(id);
		return Result.success("歌手信息查询成功",singers);
	}
	/**
	 * 更新歌手图片
	 */
	@PostMapping(value = "/updateSingerPic")
	public Result updateSingerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id)
	{
		//如果文件是空
		if(avatorFile.isEmpty())
		{
			return Result.fail("上传失败");
		}
		String filename=singerService.findById(id).getPic();
		if(!filename.equals("/img/singerPic/default.jpg"))//如果不是默认照片，就现将旧照片删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+filename;
			File file=new File(filePath);
			file.delete();
		}
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
				+System.getProperty("file.separator")+"singerPic";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath+System.getProperty("file.separator")+fileName);
		//存储到数据库里的相对文件地址

		String storeAvatorPath = "/img/singerPic/"+fileName;
		try {
			avatorFile.transferTo(dest);
			Singer singer = singerService.findById(id);
			singer.setPic(storeAvatorPath);
			boolean flag = singerService.update(singer)!=null;
			if(flag)
			{
				return Result.success("上传成功");
			}
			else
			{
				return Result.fail("上传失败");
			}
		} catch (IOException e) {
			return Result.fail("上传失败"+e.getMessage());
		}
	}
}
