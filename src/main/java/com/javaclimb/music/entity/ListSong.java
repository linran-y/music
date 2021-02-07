package com.javaclimb.music.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@auther ykw
 *@date 2021/2/6 12:16
 * **
 * 歌单里面的歌曲
 */
@Table(name="list_song")
@Entity
@Data
public class ListSong
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;     //主键
	private Integer songId; //歌曲id
	private Integer songListId; //歌单id
}
