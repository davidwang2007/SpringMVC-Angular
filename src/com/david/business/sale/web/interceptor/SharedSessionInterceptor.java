/**
 * 
 */
package com.david.business.sale.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.david.business.sale.web.util.Constants;

/**
 * 共享session的拦截器
 * 达到共享目的
 * 实现方法：
 * 1. 从cookie中以SHARED_SESSION_KEY取出值
 * 2. 再从memcache中取出用户登录信息
 * 3. 将用户登录信息设置进session中
 * @time 2014-4-18 下午02:13:39
 * @author DavidWang [www]
 */
public class SharedSessionInterceptor extends BaseInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//在添加前把老的删除[特殊情况下会出错] 保证每一次请求都是重新设置
		request.getSession().removeAttribute(Constants.SESSION_USER_KEY);
		Cookie[] cookies = request.getCookies();
		if(cookies == null) return true;
		/**遍历所有cookie*/
		for(Cookie cookie : cookies){
			/**挑选出以SHARED_SESSION_KEY为名称的cookie*/
			if(!cookie.getName().equals(Constants.SHARED_SESSION_KEY)) continue;
			String user = memCacheService.get(cookie.getValue());
			if(!StringUtils.isEmpty(user)){
				/**将用户登录信息重新设置回session中*/
				request.getSession().setAttribute(Constants.SESSION_USER_KEY, user);
			}
		}
		return true;
	}
}
