package cn.tedu.cloudnotes.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.cloudnotes.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor hadler = new LoginInterceptor();
		InterceptorRegistration interceptor = registry.addInterceptor(hadler);
		interceptor.addPathPatterns("/**");
		List<String> patterns = new ArrayList<String>();
		patterns.add("/images/**");
		patterns.add("/web/header.html");
		patterns.add("/web/reg.html");
		patterns.add("/web/login.html");
		patterns.add("/web/adminLogin.html");
		
		patterns.add("/jquery-3.4.1.min.js");
		
		patterns.add("/user/reg");
		patterns.add("/user/login");
		patterns.add("/admin/login");
		interceptor.excludePathPatterns(patterns);
	}

}
