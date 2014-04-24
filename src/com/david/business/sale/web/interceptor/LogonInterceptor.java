/**
 * 
 */
package com.david.business.sale.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import com.david.business.sale.web.annotation.FreeLogon;
import com.david.business.sale.web.util.Constants;

/**
 * 登录鉴权
 * @author david
 */
@Component
public class LogonInterceptor extends BaseInterceptor {
	
	private static final Log logger = LogFactory.getLog("LogonInterceptor");
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HandlerMethod method = (HandlerMethod)handler;
		
		FreeLogon fl = method.getMethodAnnotation(FreeLogon.class);
		//logger.info("尝试拦截方法"+method.getMethod().getName());
		if(fl != null ||//如果此方法声明了不用登陆
				request.getSession().getAttribute(Constants.SESSION_USER_KEY) != null){//或者已经登录
			//则直接放行
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/initLogon");
		//request.getRequestDispatcher("/"+request.getContextPath()+"/index.jsp").forward(request, response);
		return true;
	}
}
