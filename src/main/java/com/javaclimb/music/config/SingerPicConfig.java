package com.javaclimb.music.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 *@auther ykw
 *@date 2021/2/2 19:22
 *
 */
@Configuration
public class SingerPicConfig implements WebMvcConfigurer
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/img/singerPic/**").addResourceLocations(
				"file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
						+System.getProperty("file.separator")+"singerPic"+System.getProperty("file.separator")
		);
	}
}
