package com.javaclimb.music.service.Impl;

import com.javaclimb.music.dao.Rankdao;
import com.javaclimb.music.entity.Rank;
import com.javaclimb.music.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@auther ykw
 *@date 2021/3/2 16:06
 */
@Service
public class RankServiceImpl implements RankService
{

	@Autowired
	private Rankdao rankDao;
	/**
	 * 增加
	 *
	 * @param rank
	 */
	@Override
	public Rank add(Rank rank)
	{
		if(rankDao.findByConsumerIdAndAndSongListId(rank.getConsumerId(),rank.getSongListId())!=null)
		{
			return null;
		}
		Rank save = rankDao.save(rank);
		return save;
	}

	/**
	 * 查总分
	 *
	 * @param songListId
	 */
	@Override
	public Integer findScoreSum(Integer songListId)
	{
		return rankDao.findScoreSum(songListId);
	}

	/**
	 * 查总评分人数
	 *
	 * @param songListId
	 */
	@Override
	public Integer findRankNum(Integer songListId)
	{
		return rankDao.findRankNum(songListId);
	}

	/**
	 * 计算平均分
	 *
	 * @param songListId
	 */
	@Override
	public Integer  getrank(Integer songListId)
	{
		int rankNum = rankDao.findRankNum(songListId);
		if(rankNum==0){
			return 5;
		}
		return rankDao.findScoreSum(songListId)/rankNum;

	}
}
