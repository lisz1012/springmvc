package com.lisz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PathVariableController {

	// @PathVariable 可以获取请求路径中的值，在路径中要使用 {变量名称} 的方式做标识。
	// 在方法参数中可以添加@PathVariable做识别，如果路径中的名称跟参数中的不一致，可以添加路径中的冰凉名称，推荐添加
	@RequestMapping("/testPathVariable/{id}/{name}")
	public String testPathVariable(Map<String, String> map, @PathVariable("id") int id, @PathVariable String name) {
		System.out.println(name);
		map.put("hello", "name:" +  name + "  id: " + id);
		return "hello";
	}
}
