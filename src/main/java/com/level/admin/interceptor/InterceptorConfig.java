package com.level.admin.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.level.admin.interceptor.AdminInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	/*
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new AdminInterceptor())
	 * .excludePathPatterns("/admin/login") .addPathPatterns("/admin/**");
	 * 
	 * }
	 */
	 
}
