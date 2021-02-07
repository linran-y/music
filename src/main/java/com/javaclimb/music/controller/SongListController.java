package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;
import com.javaclimb.music.entity.ListSong;
import com.javaclimb.music.entity.Song;
import com.javaclimb.music.entity.SongList;
import com.javaclimb.music.service.ListSongService;
import com.javaclimb.music.service.SongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 *@auther ykw
 *@date 2021/2/5 16:58
 */
@Api(tags="后台歌单相关操作")
@RestController
@RequestMapping("/songlist")
public class SongListController
{
	@Autowired
	SongListService songListService;
	@Autowired
	private ListSongService listSongService;
	final String defaultpicpath="/img/songListPic/default.jpg";
	/**
	 * 添加歌单
	 */
	@ApiOperation("新增歌单")
	@PostMapping("/add")
	Result add(@RequestBody SongList songList)
	{
		songList.setPic(defaultpicpath);//添加默认图片
		SongList songList1 = songListService.addSongList(songList);
		return Result.success("歌单新增成功",songList1);
	}
	/**
	* 修改歌单
	*/
	@ApiOperation("修改歌单")
	@PostMapping("/update")
	Result update(@RequestBody SongList songList)
	{
		SongList songList1 = songListService.updateSongList(songList);
		return Result.success("歌单修改成功",songList1);
	}

	/**
	 * 删除歌单
	 */
	@ApiOperation("通过id删除歌单")
	@GetMapping("/delete")
	Result delete(@RequestParam("id") Integer id)
	{
		String prePicpath=songListService.findById(id).getPic();//原图片路径
		if(!prePicpath.equals(defaultpicpath))//如果不是默认照片，就现将旧照片删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+prePicpath;
			File file=new File(filePath);
			file.delete();
		}
		List<ListSong> bySongListid = listSongService.findBySongListid(id);//将歌单里面的记录也全部删去
		for (ListSong listSong : bySongListid)
		{
			listSongService.deleteById(listSong.getId());
		}
		boolean b = songListService.deleteById(id);
		return Result.success("歌单删除成功",b);
	}


	/**
	 * 根据主键查询整个对象
	 */
	@ApiOperation("根据id查询歌单")
	@GetMapping("/querybyid")
	Result query(@RequestParam("id") Integer id)
	{
		SongList byId = songListService.findById(id);
		return Result.success("歌单查询成功",byId);
	}

	/**
	 * 查询所有歌单
	 */
	@ApiOperation("查询所有歌单")
	@GetMapping("/queryall")
	Result queryall()
	{
		List<SongList> all = songListService.findAll();
		return Result.success("歌单查询成功",all);
	}

	/**
	 * 根据标题精确查询歌单列表
	 */
	@ApiOperation("根据标题精确查询歌单列表")
	@GetMapping("/querybytitle")
	Result querybytitle(@RequestParam("title") String title)
	{
		List<SongList> byTitle = songListService.findByTitle(title);
		return Result.success("歌单查询成功",byTitle);
	}
	/**
	* 根据标题模糊查询歌单列表
	*/
	@ApiOperation("根据标题模糊查询歌单列表")
	@GetMapping("/querybytitlelike")
	Result querybytitlelike(@RequestParam("title") String title)
	{
		List<SongList> byTitle = songListService.findByTitleLike(title);
		return Result.success("歌单查询成功",byTitle);
	}
	/**
	 * 根据风格模糊查询歌单列表
	 */
	@ApiOperation("根据风格模糊查询歌单列表")
	@GetMapping("/querybystylelike")
	Result querybystylelike(@RequestParam("style") String style)
	{
		List<SongList> bystyle = songListService.findByStyleLike(style);
		return Result.success("歌单查询成功",bystyle);
	}
	/**
	 * 更新歌单图片
	 */
	@ApiOperation("更新歌单图片")
	@PostMapping("/updatepic")
	Result updatePic(@RequestParam("file") MultipartFile picfile,@RequestParam("id") Integer id)
	{
		//如果文件是空
		if(picfile.isEmpty())
		{
			return Result.fail("上传失败");
		}
		String prePicpath=songListService.findById(id).getPic();//原图片路径
		if(!prePicpath.equals(defaultpicpath))//如果不是默认照片，就现将旧照片删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+prePicpath;
			File file=new File(filePath);
			file.delete();
		}
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis()+picfile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
				+System.getProperty("file.separator")+"songListPic";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath+System.getProperty("file.separator")+fileName);
		//存储到数据库里的相对文件地址

		String storeAvatorPath = "/img/songListPic/"+fileName;
		try {
			picfile.transferTo(dest);
			SongList byId = songListService.findById(id);
			byId.setPic(storeAvatorPath);
			boolean flag = songListService.updateSongList(byId)!=null;
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
