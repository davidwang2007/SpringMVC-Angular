/**
 * 
 */
package com.hh.business.sale.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hh.business.sale.web.service.BaseService;
import com.hh.business.sale.web.service.MemCacheService;
import com.hh.business.sale.web.service.UserService;

/**
 * 过滤器的基类 
 * @author david
 */
@Component
public abstract class BaseInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	protected UserService userService;
	@Autowired
	protected BaseService baseService;
	
	@Autowired
	protected MemCacheService memCacheService;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}
	
	
}
