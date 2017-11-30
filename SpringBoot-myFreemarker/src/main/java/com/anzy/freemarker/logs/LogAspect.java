package com.anzy.freemarker.logs;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.anzy.freemarker.utils.IpUtil;

/**
 * AOP 日志记录
 * @author anzy
 *
 */
@Aspect
@Component
@Order(1)
public class LogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
	/**
	 * 定义一个切入点
	 */
	@Pointcut("execution(public * com.anzy.bussiness.*.*.*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		// 接收到请求，记录请求内容
		LOGGER.info("WebLogAspect.doBefore()");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		LOGGER.info("URL : " + request.getRequestURL().toString());
		LOGGER.info("HTTP_METHOD : " + request.getMethod());
		String ip = IpUtil.getIpAddr(request);
		String ipInfo = IpUtil.getIpInfo(ip);
		LOGGER.info("IP = {},ipInfo = {} " , ip,ipInfo);
		LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		LOGGER.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

		// 获取所有参数方法一：
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			System.out.println(paraName + ": " + request.getParameter(paraName));
		}
	}

	@AfterReturning("webLog()")
	public void doAfterReturning(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		LOGGER.info("WebLogAspect.doAfterReturning()");

	}

}