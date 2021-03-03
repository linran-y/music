package com.javaclimb.music.dao;

import com.javaclimb.music.entity.Rank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 *@auther ykw
 *@date 2021/3/2 16:27
 */
public interface Rankdao extends JpaRepository<Rank,Integer>
{
	@Query("select sum(t.score) from Rank t where t.songListId=?1")
	Integer findScoreSum(Integer songListId);
	@Query("select count(t) from Rank t where t.songListId=?1")
	Integer findRankNum(Integer songListId);

	Rank findByConsumerIdAndAndSongListId(Integer ConsumerId,Integer SongListId);

}
