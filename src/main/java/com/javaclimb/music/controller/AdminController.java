package com.javaclimb.music.controller;

import com.javaclimb.music.common.Result;
import com.javaclimb.music.entity.Admin;
import com.javaclimb.music.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 *@auther ykw
 *@date 2021/1/31 21:35
 */

@Api(tags="后台管理员相关操作")
@RestController
@RequestMapping("admin")
public class AdminController
{
	@Autowired
	AdminService adminService;
	/*
	* 验证账号密码
	* */
	@ApiOperation("验证账号密码")
	@PostMapping("/login")
	Result Login(@RequestBody Admin admin)
	{
		String username=admin.getUsername();
		String password=admin.getPassword();
		Admin queryadmin = adminService.verifyPassword(username, password);
		if(queryadmin!=null)
			return Result.success("登录成功",admin);
		return Result.fail("账户或密码错误",null);
	}
}
