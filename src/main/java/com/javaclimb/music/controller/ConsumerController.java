package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;
import com.javaclimb.music.entity.Consumer;
import com.javaclimb.music.entity.Singer;
import com.javaclimb.music.service.ConsumerService;
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
 *@date 2021/2/7 14:58
 */
@Api(tags ="后台前端用户相关操作")
@RestController
@RequestMapping("/consumer")
public class ConsumerController
{
	@Autowired
	private ConsumerService consumerService;

	final String defaultavatorpath="/avatorImages/default.jpg";//设置默认头像路径

	/**
	 * 添加前端用户
	 */
	@ApiOperation("添加前端用户")
	@PostMapping(value = "/add")
	public Result add(@RequestBody Consumer consumer)
	{
		consumer.setAvator(defaultavatorpath);//设置一个默认头像
		Consumer add = consumerService.add(consumer);
		return Result.success("新增成功",add);
	}

	/**
	 * 修改前端用户
	 */
	@ApiOperation("修改前端用户")
	@PostMapping(value = "/update")
	public Result update(@RequestBody Consumer consumer)
	{
		Consumer update = consumerService.update(consumer);
		return Result.success("修改成功",update);
	}
	/*
	 * 根据id删除前端用户
	 */
	@ApiOperation("根据id删除前端用户")
	@GetMapping("/delete")
	public Result delete(@RequestParam("id") Integer id)
	{
		String Avatorfilepath=consumerService.findById(id).getAvator();
		if(!Avatorfilepath.equals(defaultavatorpath))//如果不是默认照片，就一起删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+Avatorfilepath;
			File file=new File(filePath);
			file.delete();
		}
		consumerService.deleteById(id);
		return Result.success("用户信息删除成功",1);
	}
	/**
	 * 根据id查询整个对象
	 */
	@ApiOperation("根据id查询整个对象")
	@GetMapping("/findbyid")
	public Result findbyid(@RequestParam("id") Integer id)
	{
		Consumer byId = consumerService.findById(id);
		return Result.success("用户信息查询成功",byId);
	}
	/**
	 * 查询所有前端用户
	 */
	@ApiOperation("查询所有前端用户")
	@GetMapping("/findall")
	public Result findall()
	{
		List<Consumer> all = consumerService.findAll();
		return Result.success("用户信息查询成功",all);
	}
	/**
	 * 根据用户名模糊查询
	 */
	@ApiOperation("根据用户名模糊查询")
	@GetMapping("/findbyusernamelike")
	public Result findbyusernamelike(@RequestParam("username") String username)
	{
		List<Consumer> byUsernameLike = consumerService.findByUsernameLike(username);
		return Result.success("用户信息查询成功",byUsernameLike);
	}
	/**
	 * 更新前端用户图片
	 */
	@ApiOperation("更新前端用户图片")
	@PostMapping(value = "/updateavator")
	public Result updateavator(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id)
	{
		//如果文件是空
		if(avatorFile.isEmpty())
		{
			return Result.fail("上传失败");
		}
		String avatorpath=consumerService.findById(id).getAvator();
		if(!avatorpath.equals(defaultavatorpath))//如果不是默认照片，就现将旧照片删除
		{
			//文件路径
			String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+avatorpath;
			File file=new File(filePath);
			file.delete();
		}
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"avatorImages";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if(!file1.exists()){
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath+System.getProperty("file.separator")+fileName);
		//存储到数据库里的相对文件地址

		String storeAvatorPath = "/avatorImages/"+fileName;
		try {
			avatorFile.transferTo(dest);
			Consumer byId = consumerService.findById(id);
			byId.setAvator(storeAvatorPath);
			boolean flag = consumerService.update(byId)!=null;
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
	 * 前台登录验证
	 */
	@ApiOperation("前台登录验证")
	@GetMapping(value = "/login")
	public Result login(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		Consumer consumer = consumerService.verifyPassword(username, password);
		if(consumer != null)
		{
			return Result.success("登录成功",consumer);
		}
		else {
			return Result.fail("账号或密码错误");
		}
	}
}
