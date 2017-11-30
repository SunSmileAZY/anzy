package com.anzy.bussiness.sysmng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anzy.bussiness.sysmng.entity.User;
import com.anzy.bussiness.sysmng.service.UserService;
import com.anzy.freemarker.utils.R;
import com.baomidou.mybatisplus.plugins.Page;
@Controller
@RequestMapping("/sysmng/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("init")
	public String init(){
		
		return "sysmng/user";
	}
	
	@ResponseBody
	@RequestMapping("listUser")
	public R listUser(){
        try {
			Page<User> page = new Page<User>(1, 100);
			page = userService.selectPage(page);
			return R.ok().put("records", page.getRecords()).put("total", page.getTotal())
		                .put("rows", page.getSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return R.error();
	}
	
}
