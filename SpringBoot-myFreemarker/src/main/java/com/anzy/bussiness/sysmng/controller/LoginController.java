package com.anzy.bussiness.sysmng.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anzy.bussiness.sysmng.entity.Thing;
import com.anzy.bussiness.sysmng.service.impl.CacheDemoServiceImpl;
import com.anzy.freemarker.base.controller.AbstractController;
import com.anzy.freemarker.utils.R;

@Controller
@RequestMapping("/sysmng/login/")
public class LoginController extends AbstractController{
	
	@RequestMapping("init")
	public String init(){
		return "sysmng/login";
	}
	
	@Autowired
    private CacheDemoServiceImpl cacheDemoServiceImpl;
    
    @RequestMapping("add")
    public void add(@NotNull Long id) {
        Thing t=new Thing();
        t.setId(id);
        cacheDemoServiceImpl.create(t);
    
    }
    
    @RequestMapping("list")
    @ResponseBody
    public R list() {
        List<Thing> list=cacheDemoServiceImpl.findAll();
        return R.ok().put("record", list);
    }
    
    @RequestMapping("one")
    @ResponseBody
    public R one(@NotNull Long id) {
        Thing t=new Thing();
        t.setId(id);
        Thing tt=cacheDemoServiceImpl.findById(t);
        return R.ok().put("record", tt);
    
    }
    
    @RequestMapping("delete")
    @ResponseBody
    public void delete(@NotNull Long id) {
        cacheDemoServiceImpl.delete(id);
    
    }
	

}
