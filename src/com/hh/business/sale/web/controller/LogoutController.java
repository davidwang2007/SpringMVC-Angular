/**
 * 
 */
package com.hh.business.sale.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hh.business.sale.web.util.Constants;

/**
 * logout controller
 * step:
 *  remove the uuid user map info from the memcache server
 * @author david
 *
 */
@Controller
public class LogoutController extends BaseController {

	private static final Log logger = LogFactory.getLog("LogoutController");
	
	@RequestMapping("/logout")
	public String logout(@CookieValue(Constants.SHARED_SESSION_KEY) String uuid,
			HttpServletRequest req){
		//should remove the uuid map from memcache
		memCacheService.delete(uuid);
		logger.info(String.format("try to remove %s's uuid %s from memcache", 
				req.getSession().getAttribute(Constants.SESSION_USER_KEY),uuid));
		return "redirect:/initLogon";
	}
}
