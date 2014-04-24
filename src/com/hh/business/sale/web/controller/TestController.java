/**
 * 
 */
package com.hh.business.sale.web.controller;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hh.business.sale.web.util.Constants;
import com.hh.business.sale.web.vo.IpPortUserVo;

/**
 * @author david
 *
 */
@Controller
@SessionAttributes(Constants.SESSION_USER_KEY)
public class TestController extends BaseController {
	
	@RequestMapping("/test")
	@ResponseBody
	public IpPortUserVo test(@ModelAttribute(Constants.SESSION_USER_KEY) String user,
			@RequestHeader("x-real-ip") String ip,
			@RequestHeader("x-real-port") int port){
		IpPortUserVo vo = new IpPortUserVo();
		vo.setIp(ip);
		vo.setPort(port);
		vo.setUser(user);
		try {
			vo.setRemoteIp(getLocalIps());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	protected static String getLocalIps() throws Exception{
		Enumeration<NetworkInterface> faces = NetworkInterface.getNetworkInterfaces();
		StringBuilder all = new StringBuilder();
		while(faces.hasMoreElements()){
			NetworkInterface face = faces.nextElement();
			Enumeration<InetAddress> addrs = face.getInetAddresses();
			if(!addrs.hasMoreElements() || face.isLoopback()) continue;
			StringBuilder sb = new StringBuilder("");
			while(addrs.hasMoreElements()){
				InetAddress addr = addrs.nextElement();
				if(addr.getHostAddress().contains(":")) continue;
				sb.append(addr.getHostAddress()).append("; ");
			}
			if(sb.length()>0)
				all.append(String.format("%s: %s",face.getName(),sb.toString())).append("\n");
		}
		
		return all.toString();
	}
}
