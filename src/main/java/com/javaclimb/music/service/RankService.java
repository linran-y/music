package com.javaclimb.music.service;

import com.javaclimb.music.entity.Rank;

/*
 *@auther ykw
 *@date 2021/3/2 16:02
 */
public interface RankService
{
	/**
	 *增加
	 */
	public Rank add(Rank rank);

	/**
	 * 查总分
	 */
	public Integer findScoreSum(Integer songListId);

	/**
	 * 查总评分人数
	 */
	public Integer findRankNum(Integer songListId);
	/**
	 * 计算平均分
	 */
	public Integer getrank(Integer songListId);
}
