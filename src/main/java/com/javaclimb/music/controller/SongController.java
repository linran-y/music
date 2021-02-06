package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;

import com.javaclimb.music.entity.Song;
import com.javaclimb.music.service.SongService;
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
 *@date 2021/2/4 12:17
 */
@Api(tags="后台歌曲相关操作")
@RestController()
@RequestMapping("/song")
public class SongController
{
	@Autowired
	private SongService songService;

	final private String defaultsongpicpath="/img/songPic/default.png";//歌曲的默认图片
	/**
	 * 上传歌曲资源
	 * 上传成功data返回歌曲文件的的地址
	 */
	@ApiOperation("添加歌曲资源")
	@PostMapping(value = "/addSongres")
	public Result addSong(@RequestParam("file") MultipartFile mpFile)
	{
		//如果文件是空
		if(mpFile.isEmpty())
		{
			return Result.fail("歌曲资源上传失败");
		}
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis()+mpFile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath+System.getProperty("file.separator")+fileName);
		//存储到数据库里的相对文件地址
		String mpfilesqlPath = "/song/"+fileName;
		try {
			mpFile.transferTo(dest);
			return Result.success("上传成功",mpfilesqlPath);
		} catch (IOException e) {
			return Result.fail("上传失败"+e.getMessage());
		}
	}
	/**
	 * 添加歌曲
	 */
	@ApiOperation("添加歌曲")
	@PostMapping(value = "/addsong")
	public Result addSong(@RequestBody Song song)
	{
		song.setPic(defaultsongpicpath);//设置默认图片
		Song addsong = songService.add(song);
		return Result.success("歌曲上传成功",addsong);
	}
	/**
	 * 根据歌手id查询所有歌曲
	 */
	@ApiOperation("根据歌手id查询所有歌曲")
	@GetMapping("/findSongbysingerid")
	public Result querySong(@RequestParam("id")Integer singerid)
	{
		List<Song> bySingerId = songService.findBySingerId(singerid);
		return Result.success("歌曲查询成功",bySingerId);
	}
	/**
	 *根据歌曲名来模糊查询
	 */
	@ApiOperation("根据歌曲名来模糊查询")
	@GetMapping("/findsongByNameLike")
	public Result findsongByNameLike(@RequestParam("name")String name)
	{
		List<Song> byNameLike = songService.findByNameLike(name);
		return Result.success("歌曲查询成功",byNameLike);
	}
	/**
	 * 删除歌曲
	 */
	@ApiOperation("根据歌曲id来删除歌曲")
	@GetMapping("/deletesongbyid")
	public Result deletesongbyid(@RequestParam("id")Integer id)
	{
		Song byId = songService.findById(id);
		String picfilename=byId.getPic();//获取图片
		if(!picfilename.equals(defaultsongpicpath))//如果不是默认照片，就一起删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+picfilename;
			File file=new File(filePath);
			file.delete();
		}
		String mpfilename=byId.getUrl();//获取歌曲文件路径
		String mpfilePath = System.getProperty("user.dir")+System.getProperty("file.separator")+mpfilename;
		File file=new File(mpfilePath);//找到文件
		file.delete();//删除歌曲文件
		songService.deleteById(id);
		return Result.success("歌曲信息删除成功",1);
	}
	/**
	 * 修改歌曲信息
	 */
	@ApiOperation("修改歌曲信息")
	@PostMapping("/updatesong")
	public Result updatesong(@RequestBody Song song)
	{
		Song update = songService.update(song);
		return Result.success("歌曲信息修改成功",update);
	}
	/**
	 * 根据id更新歌曲图片
	 */
	@ApiOperation("根据id更新歌曲图片")
	@PostMapping(value = "/updateSongPic")
	public Result updateSongPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id)
	{
		//如果文件是空
		if(avatorFile.isEmpty())
		{
			return Result.fail("上传失败");
		}
		String picPath=songService.findById(id).getPic();
		if(!picPath.equals(defaultsongpicpath))//如果不是默认照片，就现将旧照片删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+picPath;
			File file=new File(filePath);
			file.delete();
		}
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
				+System.getProperty("file.separator")+"songPic";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath+System.getProperty("file.separator")+fileName);
		//存储到数据库里的相对文件地址

		String storeAvatorPath = "/img/songPic/"+fileName;
		try {
			avatorFile.transferTo(dest);
			Song song = songService.findById(id);
			song.setPic(storeAvatorPath);
			boolean flag = songService.update(song)!=null;
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
	/**
	 * 更新根据id歌曲资源
	 */
	@ApiOperation("根据id更新歌曲资源")
	@PostMapping(value = "/updateSongurl")
	public Result updateSongurl(@RequestParam("file") MultipartFile mpFile, @RequestParam("id")int id)
	{
		//如果文件是空
		if(mpFile.isEmpty())
		{
			return Result.fail("资源更新失败");
		}
		String preurl=songService.findById(id).getUrl();
		//原文件路径
		String prefilePath = System.getProperty("user.dir")+preurl;
		File prefile=new File(prefilePath);
		//删除原文件
		prefile.delete();
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis()+mpFile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath+System.getProperty("file.separator")+fileName);
		//存储到数据库里的相对文件地址
		String storeurl = "/song/"+fileName;
		try {
			mpFile.transferTo(dest);
			Song song = songService.findById(id);
			song.setUrl(storeurl);
			boolean flag = songService.update(song)!=null;
			if(flag)
			{
				return Result.success("资源更新成功");
			}
			else
			{
				return Result.fail("资源更新失败");
			}
		} catch (IOException e) {
			return Result.fail("资源更新失败"+e.getMessage());
		}
	}
}
