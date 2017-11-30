package com.anzy.freemarker.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 过滤器
 * 
 * ①拦截器是基于java的反射机制的，而过滤器是基于函数回调。
 * ②拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
 * ③拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
 * ④拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
 * ⑤在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
 * ⑥拦截器可以获取IOC容器中的各个bean，而过滤器就不行，这点很重要，在拦截器里注入一个service，可以调用业务逻辑。
 * @author anzy  
 * 20171009
 *
 */
@Component("myFilter")
public class MyFilter implements Filter {
	private static final Logger LOG = Logger.getLogger(MyFilter.class);

	/**
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		LOG.info("MyFilter destroy...");
	}

	/**
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		LOG.info("MyFilter doFilter...");
		// 获取访问URL
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		LOG.info("访问的URL： servletPath = " + servletPath);
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");
		chain.doFilter(request, response);

//		if (servletPath != null && (servletPath.equals("/03/index.jsp") || servletPath.equals("/03/login.jsp")
//				|| servletPath.equals("/loginServlet17"))) {
//			chain.doFilter(request, response);
//		} else {
//			if (flag != null && flag.equals("login_success")) {
//				chain.doFilter(request, response);
//			} else if (flag != null && flag.equals("login_error")) {
//				req.setAttribute("msg", "登录失败，请重新登录");
//				req.setAttribute("return_uri", servletPath);
//				RequestDispatcher rd = req.getRequestDispatcher("/index/init");
//				rd.forward(req, resp);
//			} else {
//				req.setAttribute("msg", "你尚未登录");
//				req.setAttribute("return_uri", servletPath);
//				RequestDispatcher rd = request.getRequestDispatcher("/views/index.jsp");
//				rd.forward(req, resp);
//
//			}
//		}

	}

	/**
	 * @param arg0
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOG.info("MyFilter init...");
	}

}
