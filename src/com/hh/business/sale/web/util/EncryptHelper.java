/**
 * @author DavidWang [www]
 * @version 1.0
 * @notes
 * @description 
 * @time 2013-12-6 下午12:14:32
 *
 */
package com.hh.business.sale.web.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 加密类
 * 主要用于加密密码明文
 * 采用SHA-1加密
 * @time 2013-12-6 下午12:14:52
 * @author DavidWang [www]
 */
public class EncryptHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(EncryptHelper.class);
	/**加密算法sha-1*/
	private String algorithm = "sha-1";
	private MessageDigest digest = null;
	private Charset charset = Charset.forName("UTF-8");
	
	/**单例模式*/
	private static EncryptHelper instance;
	private EncryptHelper(){
		if(digest == null){
			try{
				digest = MessageDigest.getInstance(algorithm);
			}catch(Exception ex){
				LOGGER.error("初始化加密类出现错误 !",ex);
			}
		}
	}
	public synchronized static EncryptHelper getInstance(){
		if(instance == null)
			instance = new EncryptHelper();
		return instance;
	}
	
	/**
	 * 将text进行sha-1加密
	 * 返回加密结果【40字符串长度】
	 * [md5为32字符串长度]
	 * @param text
	 * @return
	 */
	public String encrypt(String text){
		if(StringUtils.isEmpty(text)){
			LOGGER.error("加密时传入文本为空!请检查!");
			return null;
		}
		digest.reset();
		digest.update(text.getBytes(charset));
		byte[] result = digest.digest();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; ++i) {  
			sb.append(Integer.toHexString((result[i] & 0xFF) | 0x100).substring(1,  
					3));  
		}  
		return sb.toString();
	}
}
