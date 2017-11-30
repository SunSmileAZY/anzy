package com.anzy.bussiness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 测试
 * @author anzy
 * @date 2017年11月30日
 */
@Controller
@RequestMapping("/index/")
public class IndexController {

	@RequestMapping("init")
	public String init(){
		
		return "index";
	}
}
