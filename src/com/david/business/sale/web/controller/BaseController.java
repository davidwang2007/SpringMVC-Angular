/**
 * 
 */
package com.david.business.sale.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.business.sale.web.service.BaseService;
import com.david.business.sale.web.service.MemCacheService;
import com.david.business.sale.web.service.UserService;
import com.david.business.sale.web.vo.GeneralResultVo;

/**
 * @author david
 *
 */
@Component
public abstract class BaseController {

	@Autowired
	protected UserService userService;
	@Autowired
	protected BaseService baseService;
	@Autowired
	protected MemCacheService memCacheService;
	
	/**
	 * @param result
	 * @param reason
	 * @return
	 */
	protected GeneralResultVo createGeneralResult(int result,String reason){
		return new GeneralResultVo(result, reason);
	}
}
