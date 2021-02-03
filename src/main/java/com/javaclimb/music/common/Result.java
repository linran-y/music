package com.javaclimb.music.common;

import lombok.Data;

/*
 *@auther ykw
 *@date 2021/1/31 21:08
 */
@Data
public class Result
{
	int code;
	String msg;
	Object data;
	public static Result success(String msg,Object data)
	{
		Result result=new Result();
		result.setCode(200);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	public static Result success(String msg)
	{
		Result result=new Result();
		result.setCode(200);
		result.setMsg(msg);
		return result;
	}
	public static Result fail(String msg,Object data)
	{
		Result result=new Result();
		result.setCode(400);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	public static Result fail(String msg)
	{
		Result result=new Result();
		result.setCode(400);
		result.setMsg(msg);
		return result;
	}
}
