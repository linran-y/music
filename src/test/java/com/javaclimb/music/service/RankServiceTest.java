package com.javaclimb.music.service;

import com.javaclimb.music.entity.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RankServiceTest
{
	@Autowired
	private RankService rankService;
	@Test
	void add()
	{
		Rank rank = new Rank();
		rank.setScore(1234);
		rank.setSongListId(111);
		rank.setConsumerId(123);
		rankService.add(rank);
	}

	@Test
	void findScoreSum()
	{
		Integer ranksum = rankService.findScoreSum(111);
		System.out.println(ranksum);
	}

	@Test
	void findRankNum()
	{
		Integer ranknum = rankService.findRankNum(111);
		System.out.println(ranknum);
	}

	@Test
	void rankOfSongListId()
	{
		Integer rank = rankService.getrank(111);
		System.out.println(rank);
	}
}
