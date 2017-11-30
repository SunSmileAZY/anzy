package com.anzy.bussiness.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 1 在thymeleaf模板中，标签需要闭合，thymeleaf3.0之前需要闭合，之后不强制要求
 * 
 * @author anzy
 *	测试
 */
@Controller
@RequestMapping("/templates/")
public class TemplatesController {

	@RequestMapping("test1")
	public String hello(Map<String,String> map){
		map.put("name", "anzy");
		return "test/test1";
	}
	@RequestMapping("helloFtl")
	public String helloFtl(Map<String,String> map){
		map.put("name", "anzy");
		return "helloFtl";
	}
	
	
}
