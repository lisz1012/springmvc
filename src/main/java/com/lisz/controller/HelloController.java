package com.lisz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * springmvc处理过程
 * 1. 浏览器要发送一个请求：http://localhost:8080/springmvc_war_exploded/hello
 * 2。首先教给Tomcat容器
 * 3。在web.xml文件中配置了DispatcherServlet类，此时会由当前的DispatcherServlet来接受请求
 * 4。接收到请求之后找到对应的Controller，去Controller中寻找@Get/RequestMapping注解标识的方法
 * 5。找到匹配的方法后，执行方法的逻辑
 * 6。处理完成之后需要返回一个前端页面的名称
 * 7。由视图处理器来根据名称映射到对应的jsp页面的路径
 * 8。DispatcherServlet拿到对应的路径地址之后，返回给浏览器
 */

@Controller
/* @RequestMapping 可以添加在类上，也可以添加在方法上。当添加在类上的时候，表示给所有的当前类的方法前加一个访问路径
 什么时候需要在类上添加此注解？包含多个Controller，通过在不同的Controller中包含相同的请求的时候。
 value表示匹配的请求（路径）
 method表示请求的方式
 params表示请求中必须要包含的参数，是个数组，有参数一定要在请求的时候加参数. params={!参数名} 的意思是不可以包含某个参数，如果传了这个参数
 则报400错误.
 params = {"username=zhangsan", "age"} 表示必须有username和age两个参数，并且username的取值必须是zhangsan

 headers = {"User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"}
 会限制访问这个URL的浏览器必须是Chrome才可以，否则404
 */
@RequestMapping("/hello")
public class HelloController {
	/**
	 * @GetMapping 表示用来匹配当前方法要处理的请求，其中/可以省略，推荐写上
	 * @param map
	 * @return
	 */
	/* @RequestMapping 可以添加在类上，也可以添加在方法上。当添加在类上的时候，表示给所有的当前类的方法前加一个访问路径
		 什么时候需要在类上添加此注解？包含多个Controller，通过在不同的Controller中包含相同的请求的时候。
		 value表示匹配的请求（路径）
		 method表示请求的方式
		 params表示请求中必须要包含的参数，是个数组，有参数一定要在请求的时候加参数. params={!参数名} 的意思是不可以包含某个参数，如果传了这个参数
		 则报400错误.
		 params = {"username=zhangsan", "age"} 表示必须有username和age两个参数，并且username的取值必须是zhangsan

		 headers = {"User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"}
		 会限制访问这个URL的浏览器必须是Chrome才可以，否则404
		 produces:限制请求中的Content-Type
		 consumer：限制响应中的Content-Type
		 @RequestMapping可以进行模糊匹配：
		   ?:一个字符
		   *：多个字符
		   **：多层路径
		 如果能匹配多个，则有限匹配精准的匹配，其次是模糊匹配
    */
	@GetMapping(value = "/hello", headers = {"User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"}) //斜杠可以不用加, 有参数一定要在请求的时候加参数
	public String hello(Map<String, String> map){
		map.put("hello", "hello spring MVC");
		return "hello";
	}

	@GetMapping(value = "/hello?") //斜杠可以不用加, 有参数一定要在请求的时候加参数
	public String hello2(Map<String, String> map){
		map.put("hello", "😂");
		return "hello";
	}
}
