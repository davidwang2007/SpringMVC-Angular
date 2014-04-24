/**
 * 
 */
package com.david.business.sale.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.david.business.sale.web.vo.GeneralResultVo;

/**
 * global exception handler
 * @author david
 *
 */
@ControllerAdvice
public class ExceptionController extends BaseController {
	public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public GeneralResultVo defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        GeneralResultVo vo = new GeneralResultVo(1, e.getMessage());
        return vo;
    }
	
}
