package com.anzy.freemarker.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	private static final Logger LOG = Logger.getLogger(MyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOG.info("------preHandle------");
		// 获取session
		HttpSession session = request.getSession(true);
		// 判断用户ID是否存在，不存在就跳转到登录界面
//		if (session.getAttribute("userId") == null) {
//			LOG.info("------:跳转到login页面！");
//			response.sendRedirect(request.getContextPath() + "/login/login/init");
//			return false;
//		} else {
//			session.setAttribute("userId", session.getAttribute("userId"));
//			return true;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("------postHandle------");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		LOG.info("------afterCompletion------");

	}

}
