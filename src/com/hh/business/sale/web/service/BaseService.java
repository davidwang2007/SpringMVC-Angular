/**
 * 
 */
package com.hh.business.sale.web.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hh.business.sale.web.dao.BaseDao;
import com.hh.business.sale.web.dao.UserDao;

/**
 * @author david
 */
@Component
public class BaseService {
	@Autowired
	protected BaseDao baseDao;
	@Autowired
	protected UserDao userDao;
	
	/**
	 * 保存或更新实体类
	 * @version 1.0
	 * @param entity 需要持久化的实体
	 * @return void
	 * @notes
	 * @description 
	 * @author Wangweiwei
	 * */
	public void saveOrUpdate(Object entity){
		baseDao.saveOrUpdate(entity);
	}
	
	/**
	 * 持久化集合
	 * @version 1.0
	 * @params entities
	 * @return void
	 * @notes
	 * @description 
	 * @time 2014-4-22 上午09:58:59
	 * @author Wangweiwei
	 * */
	@SuppressWarnings("rawtypes")
	public void saveOrUpdateAll(Collection entities){
		baseDao.saveOrUpdateAll(entities);
	}
	/**
	 * 删除实体类
	 * @version 1.0
	 * @params entity
	 * @return void
	 * @notes
	 * @description 
	 * @time 2014-4-22 上午10:00:36
	 * @author Wangweiwei
	 * */
	public void delete(Object entity){
		baseDao.delete(entity);
	}

	/**
	 * 将一个持久化的集合删除掉
	 * @version 1.0
	 * @params entities
	 * @return void
	 * @notes
	 * @description 
	 * @time 2014-4-22 上午10:00:52
	 * @author Wangweiwei
	 * */
	@SuppressWarnings("rawtypes")
	public void deleteAll(Collection entities){
		baseDao.deleteAll(entities);
	}
	/**
	 * get class by id
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getEntity(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.getEntity(clazz, id);
	}
	
	/**
	 * DELETE ENTITY BY ID
	 * @param clazz
	 * @param id
	 */
	public void deleteEntity(Class clazz, Serializable id){
		baseDao.delete(baseDao.getEntity(clazz, id));
	}
}
