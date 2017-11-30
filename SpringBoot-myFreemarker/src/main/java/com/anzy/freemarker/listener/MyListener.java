package com.anzy.freemarker.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

import com.anzy.freemarker.service.SystemService;
/**
 * 
 * @author anzy
 * @date 2017年10月25日
 */
@Component("myListener")
public class MyListener implements ServletContextListener {
	/**
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed...");
	}

	/**
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("listener contextInitialized...");
		SystemService.printKeyLoadMessage();
	}

}