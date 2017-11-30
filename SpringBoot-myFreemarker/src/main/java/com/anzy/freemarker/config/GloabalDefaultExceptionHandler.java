package com.anzy.freemarker.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1 新建一个class   
 * 2 在class上添加注解  @ControllerAdvice
 * 3 在class中添加方法
 * 4 在方法上添加@ExcetionHandler拦截相应的异常信息
 * 5 如果返回view   --- 方法返回只是ModelAndView
 * 6 如果返回的是String或Json 数据，，那么需要在方法上添加RequestBody注解
 * 
 * @author anzy
 *
 */
@ControllerAdvice
public class GloabalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String defaultExceptionHandler(){
		return "服务器繁忙";
	}
}
