/**
 * 
 */
package com.david.business.sale.web.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alisoft.xplatform.asf.cache.memcached.client.ErrorHandler;
import com.alisoft.xplatform.asf.cache.memcached.client.MemCachedClient;
import com.alisoft.xplatform.asf.cache.memcached.client.SockIOPool;

/**
 * @author david
 *
 */
@Component
public class MemCacheService {
	private final static Log logger = LogFactory.getLog("MemCacheService");
	/**
	 * memcached 服务器列表
	 */
	@Value("${memcache.server}")
	private String[] servers;
	/**memcacheclient*/
	private MemCachedClient client;
	/**初始连接数*/
	@Value("${init.conn}")
	private int initConn;
	/**最小连接数*/
	@Value("${min.conn}")
	private int minConn;
	/**最大连接数*/
	@Value("${max.conn}")
	private int maxConn;
	/**读取超时 毫秒*/
	@Value("${socket.to}")
	private int socketTO;
	/**
	 * 初始化memcacheclient
	 */
	@PostConstruct
	public void init(){
		SockIOPool pool = SockIOPool.getInstance("sale_memcache_client");
		pool.setServers(servers);
		pool.setInitConn(initConn);
		pool.setMinConn(minConn);
		pool.setMaxConn(maxConn);
		pool.setAliveCheck(true);
		pool.setSocketTO(socketTO);
		//设置主线程睡眠时间 每隔30秒醒来开始维护连接数大小
		pool.setMaintSleep(30);
		//关闭nagle算法
		pool.setNagle(false);
		pool.initialize();
		client = new MemCachedClient("sale_memcache_client");
		client.setDefaultEncoding("UTF-8");
		client.setErrorHandler(errorHandler);
		client.setPrimitiveAsString(true);//所有基本类型作为字符串存储 
		logger.info("start MemCacheHelper success .....");
	}
	/**
	 * retrieve key's value from memcache
	 * @param key
	 * @return
	 * @author www
	 */
	public String get(String key){
		Object val = client.get(key);
		logger.info(String.format("memcache get %s=%s", key,val));
		return val == null ? null : String.valueOf(val);
	}
	/**
	 * set key/value to memcache
	 * @param key
	 * @param value  通常为字符串型
	 * @author www 
	 */
	public void set(String key,Object value){
		client.set(key, value);
		logger.info(String.format("memcache set %s=%s", key,value));
	}
	/**
	 * 删除一个
	 * @param key
	 */
	public void delete(String key){
		client.delete(key);
	}
	
	/**
	 * 错误处理器
	 */
	private ErrorHandler errorHandler = new ErrorHandler() {
		
		public void handleErrorOnStats(MemCachedClient client, Throwable err) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when start", err);
		}
		
		public void handleErrorOnSet(MemCachedClient client, Throwable err,
				String key) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when set " + key, err);
		}
		
		public void handleErrorOnInit(MemCachedClient client, Throwable err) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when init", err);
		}
		
		public void handleErrorOnGet(MemCachedClient client, Throwable err,
				String[] keys) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when get " + Arrays.toString(keys), err);
		}
		
		public void handleErrorOnGet(MemCachedClient client, Throwable err,
				String key) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when get " + key, err);
		}
		
		public void handleErrorOnFlush(MemCachedClient client, Throwable err) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when flush", err);
		}
		
		public void handleErrorOnDelete(MemCachedClient client, Throwable err,
				String key) {
			// TODO Auto-generated method stub
			logger.error("MemCacheClient throw Error when delete " + key, err);
		}
	};
	
	@PreDestroy
	public void destroy(){
		client = null;
		SockIOPool.removeInstance("sale_memcache_client");
		logger.info("destroy MemCacheHelper success .....");
	}
}
