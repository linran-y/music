package com.javaclimb.music.entity;

import lombok.Data;


import javax.persistence.*;


/*
 *@auther ykw
 *@date 2021/1/31 21:04
 */

@Entity
@Table(name = "admin")
@Data
public class Admin
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column( name="name")
	private String username;
	private String password;
}
