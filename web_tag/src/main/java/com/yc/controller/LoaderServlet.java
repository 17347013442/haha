package com.yc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class LoaderServlet extends HttpServlet{
private static ApplicationContext context;

@Override
public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
}

@Override
public void init() throws ServletException {
	System.out.println("IOC 初始化。。。。");
	if(context == null) {
		context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
	}
	
}

//获取ioc容器创建的bean对象（biz）
public static Object getBean(String beanName) {
	return context.getBean("beanName");
}
}
