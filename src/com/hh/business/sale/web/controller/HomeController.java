/**
 * 
 */
package com.hh.business.sale.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author david
 *
 */
@Controller
public class HomeController extends BaseController {
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
}
