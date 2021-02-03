package com.javaclimb.music.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 歌手
 */
@Entity
@Table(name="singer")

@Data
public class Singer{
    /*主键*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*账号*/
    private String name;
    /*性别*/
    private int sex;
    /*头像*/
    private String pic;
    /*生日*/
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date birth;
    /*地区*/
    private String location;
    /*简介*/
    private String introduction;
}
