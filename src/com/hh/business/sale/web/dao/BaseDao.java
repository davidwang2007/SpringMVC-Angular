/**
 * 
 */
package com.hh.business.sale.web.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author david
 *
 */
@Component
public class BaseDao {
	
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
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
		hibernateTemplate.saveOrUpdate(entity);
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
		hibernateTemplate.saveOrUpdateAll(entities);
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
		hibernateTemplate.delete(entity);
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
		hibernateTemplate.deleteAll(entities);
	}
	/**
	 * get class by id
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object getEntity(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(clazz, id);
	}
	/**
	 * execute DetachedCriteria
	 * @param dc
	 * @return
	 */
	public List getEntitiesByDetachedCriteria(final DetachedCriteria dc) {
		return hibernateTemplate.executeFind(new HibernateCallback<List>(){
			public List doInHibernate(Session session) throws HibernateException,
			SQLException {
				// TODO Auto-generated method stub
				return dc.getExecutableCriteria(session).list();
			}
		});
	}
	/**
	 * GET COUNT BY DC
	 * @param dc
	 * @return
	 */
	public int getCountByDetachedCriteria(final DetachedCriteria dc){
		return hibernateTemplate.execute(new HibernateCallback<Integer>(){
			public Integer doInHibernate(Session session)
			throws HibernateException, SQLException {
				Criteria c = dc.getExecutableCriteria(session);
				c.setProjection(Projections.rowCount());
				return (Integer)c.uniqueResult();
			}
		});
	}
	
	/**
	 * get entities by page
	 * @param dc
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List getEntitiesByDetachedCriteria(final DetachedCriteria dc,final int pageIndex,final int pageSize){
		return hibernateTemplate.executeFind(new HibernateCallback<List>(){
			public List doInHibernate(Session session) throws HibernateException,
			SQLException {
				Criteria c = dc.getExecutableCriteria(session);
				c.setFirstResult((pageIndex-1)*pageSize);
				c.setMaxResults(pageSize);
				return c.list();
			}
		});
	}
	
	
}
