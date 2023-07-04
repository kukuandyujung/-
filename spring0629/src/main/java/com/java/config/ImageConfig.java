package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//내가 필요한 부분에 객체선언, 디아이 ? 된다. 
public class ImageConfig implements WebMvcConfigurer{

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("upload/**")
		.addResourceLocations("file:///c:/upload/");
	}

}
