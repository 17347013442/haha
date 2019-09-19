package com.yc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
@Component
public class SysExceptionResolve implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		SysException e=null;
		if(ex instanceof SysException) {
			e=(SysException)ex;
		}else {
			e=new SysException("系统维护!!!");
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg",ex.getMessage());
		mv.setViewName("error");
		return mv;
	}

}
