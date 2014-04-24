/**
 * 
 */
package com.david.business.sale.web.vo;

/**
 * @author david
 *
 */
public class IpPortUserVo {
	/**
	 * IP地址
	 */
	private String ip;
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	/**
	 * 端口号
	 */
	private int port;
	/**
	 * 登录用户
	 */
	private String user;
	/**
	 * 服务器IP
	 */
	private String remoteIp;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
