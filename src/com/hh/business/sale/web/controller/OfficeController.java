/**
 * 
 */
package com.hh.business.sale.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.business.sale.web.vo.OfficeMenuVo;

/**
 * office controller
 * @author david
 * @date 2014-4-23 13:22:06
 *
 */
@Controller
@RequestMapping("/office")
public class OfficeController extends BaseController {

	private static final Log logger = LogFactory.getLog("OfficeController");

	@RequestMapping(value="/menus",method=RequestMethod.GET)
	@ResponseBody
	public List officeMenus(){
		List menus = new ArrayList();
		OfficeMenuVo vo = new OfficeMenuVo();
		vo.setId(1);
		vo.setState("office.home");
		vo.setTitle("我的首页");
		menus.add(vo);

		vo = new OfficeMenuVo();
		vo.setId(2);
		vo.setState("office.notice");
		vo.setTitle("我的通知");
		menus.add(vo);

		return menus;
	}

}
