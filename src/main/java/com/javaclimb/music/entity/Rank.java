package com.javaclimb.music.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@auther ykw
 *@date 2021/3/2 16:01
 */
@Table(name="scorerank")
@Entity
@Data
public class Rank
{
	/*主键*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/*歌单id*/
	private Integer songListId;
	/*用户id*/
	private Integer consumerId;
	/*评分*/
	private Integer score;

}
