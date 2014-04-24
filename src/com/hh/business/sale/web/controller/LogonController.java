/**
 * 
 */
package com.hh.business.sale.web.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.business.sale.web.annotation.FreeLogon;
import com.hh.business.sale.web.entity.User;
import com.hh.business.sale.web.util.Constants;
import com.hh.business.sale.web.vo.GeneralResultVo;

/**
 * 用户登录控制器
 * @author david
 *
 */
@Controller
public class LogonController extends BaseController {
	private static final Log logger = LogFactory.getLog("LogonController");
	
	@RequestMapping(value="/logon",method=RequestMethod.POST)
	@ResponseBody
	@FreeLogon
	public GeneralResultVo logon(@RequestBody User user,HttpServletResponse resp) throws Exception{
		GeneralResultVo vo  =new GeneralResultVo();
		logger.info(String.format("%s try to logon with pass %s", user.getUsername(),user.getPassword()));
		//generate uuid to store as the cookie session id key
		String uuid = String.valueOf(UUID.randomUUID());
		//store the uuid -> user to memcache
		memCacheService.set(uuid, user.getUsername());
		Cookie cookie = new Cookie(Constants.SHARED_SESSION_KEY,uuid);
		resp.addCookie(cookie);
		return vo;
	}
	
	@RequestMapping(value="/logon",method=RequestMethod.GET)
	@ResponseBody
	@FreeLogon
	public GeneralResultVo logonGet(@RequestParam String username,
			@RequestParam String password,HttpServletResponse resp){
		GeneralResultVo vo  =new GeneralResultVo();
		logger.info(String.format("%s try to logon with pass %s", username,password));
		//generate uuid to store as the cookie session id key
		String uuid = String.valueOf(UUID.randomUUID());
		//store the uuid -> user to memcache
		memCacheService.set(uuid, username);
		Cookie cookie = new Cookie(Constants.SHARED_SESSION_KEY,uuid);
		resp.addCookie(cookie);
		return vo;
	}
}
