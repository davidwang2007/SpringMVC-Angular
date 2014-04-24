/**
 * 
 */
package com.david.business.sale.web.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.david.business.sale.web.entity.User;

/**
 * USER DAO
 * @author david
 */
@Repository
public class UserDao extends BaseDao {
	
	/**
	 * GET USES BY CONDITION, BY PAGE
	 * @param username
	 * @param realname
	 * @param gender
	 * @param pageIndex
	 * @param pageSize
	 * @author D.W.
	 * @return
	 */
	public List getUsersByCondition(String username,String realname,String gender,int pageIndex,int pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(!StringUtils.isEmpty(username))
			dc.add(Restrictions.eq("username", username));
		if(!StringUtils.isEmpty(realname))
			dc.add(Restrictions.eq("realname", realname));
		if(!StringUtils.isEmpty(gender))
			dc.add(Restrictions.eq("gender", gender));
		return getEntitiesByDetachedCriteria(dc, pageIndex, pageSize);
	}
	/**
	 * GET USERS BY CONDITION
	 * @param username
	 * @param realname
	 * @param gender
	 * @author D.W.
	 * @return
	 */
	public List getUsersByCondition(String username,String realname,String gender){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(!StringUtils.isEmpty(username))
			dc.add(Restrictions.eq("username", username));
		if(!StringUtils.isEmpty(realname))
			dc.add(Restrictions.eq("realname", realname));
		if(!StringUtils.isEmpty(gender))
			dc.add(Restrictions.eq("gender", gender));
		return getEntitiesByDetachedCriteria(dc);
	}
	
	
	
}
