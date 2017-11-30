package com.anzy.freemarker.utils;

import java.lang.reflect.Method;

import com.anzy.freemarker.base.controller.AbstractController;

/**
 * 
 * @author anzy
 * @date 2017年11月30日
 */
public class ClassUtils extends AbstractController{

	public static Method getSetMethodByMethodName(Class<?> oClass, String methodName) {
		try {
			Method m = oClass.getMethod(methodName);
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
