/**
 * 
 */
package com.hh.business.sale.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hh.business.sale.web.annotation.FreeLogon;
import com.hh.business.sale.web.util.Constants;

/**
 * @author david
 *
 */
@Controller
@RequestMapping("/initLogon")
public class InitLogonController extends BaseController {

	@RequestMapping
	@FreeLogon
	public String page(HttpServletRequest req){
		
		return req.getSession().getAttribute(Constants.SESSION_USER_KEY) == null ? "logon" : "redirect:/home";
	}
}
