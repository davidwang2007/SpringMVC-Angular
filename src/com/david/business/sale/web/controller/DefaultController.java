/**
 * 
 */
package com.david.business.sale.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.business.sale.web.annotation.FreeLogon;

/**
 * default mapping handler
 * @author david
 *
 */
@Controller
public class DefaultController extends BaseController {
	private static final Log logger = LogFactory.getLog("DefaultController");
	@RequestMapping("**")
	@FreeLogon
	public Object go(@RequestHeader("Accept") String ae,HttpServletRequest req){
		logger.info("default handler Encoding -->" + ae);
		return ae.startsWith("application/json") ? createGeneralResult(1, "请求地址不存在"+req.getRequestURI()) :"redirect:/home";
	}
}
