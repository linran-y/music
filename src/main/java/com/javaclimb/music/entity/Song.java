package com.javaclimb.music.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
 *@auther ykw
 *@date 2021/2/4 11:17
 */
@Table(name = "song")
@Entity
@Data
public class Song
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//歌手id
	@Column(name="singer_id")
	private Integer singerId;
	/*歌名*/
	private String name;
	/*简介*/
	private String introduction;
	/*创建时间*/
	@Column(name="create_time")
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:dd")
	private Date createTime;
	/*更新时间*/
	@DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:dd")
	private Date updateTime;
	/*歌曲图片*/
	private String pic;
	/*歌词*/
	private String lyric;
	/*歌曲地址*/
	private String url;
}
