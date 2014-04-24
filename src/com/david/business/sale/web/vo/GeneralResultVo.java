/**
 * 
 */
package com.david.business.sale.web.vo;

import org.springframework.util.StringUtils;

/**
 * @author david
 *
 */
public class GeneralResultVo {

	private int result;
	private String reason;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public GeneralResultVo() {
	}
	public GeneralResultVo(int result, String reason) {
		this.result = result;
		this.reason = StringUtils.isEmpty(reason)? "" : reason;
	}
	
	
}
