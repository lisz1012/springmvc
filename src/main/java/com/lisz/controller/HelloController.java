package com.lisz.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
		System.out.println(this.getClass().getName() + "------------");
		// 创建ModelAndView对象
		ModelAndView mv = new ModelAndView();
		// 跳转到哪个页面
		mv.setViewName("hello");
		// 设置属性
		mv.addObject("hw", "hello world");
		return mv;
	}
}
