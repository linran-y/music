package com.javaclimb.music.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@auther ykw
 *@date 2021/2/5 16:23
 */
@Table(name="song_list")
@Entity
@Data
public class SongList
{
	/*主键*/
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	/*歌单标题*/
	private String title;
	/*歌单图片*/
	private String pic;
	/*简介*/
	private String introduction;
	/*风格*/
	private String style;
}
