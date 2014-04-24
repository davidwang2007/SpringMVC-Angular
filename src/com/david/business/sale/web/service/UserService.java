/**
 * 
 */
package com.david.business.sale.web.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.david.business.sale.web.entity.User;

/**
 * @author david
 */
@Transactional
@Service
public class UserService extends BaseService {
	
	private static final Log LOGGER = LogFactory.getLog("UserService");
	
	/**
	 * 获取所有用户
	 * @return
	 * @author D.W.
	 */
	public List getAllUsers(){
		return userDao.getUsersByCondition(null, null, null);
	}
	/**
	 * 分页查询
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List getUsersByPage(int pageIndex,int pageSize){
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		return userDao.getEntitiesByDetachedCriteria(dc, pageIndex, pageSize);
	}
	
	/**
	 * 根据用户名与密码查找用户
	 * @param username
	 * @param password
	 * @return
	 * @author D.W.
	 */
	public User getUser(String username,String password){
		List<User> users = userDao.getUsersByCondition(username,null,null);
		if(users.size()>1){
			LOGGER.error(String.format("FIND %d USERS ACCORDING USERNAME: %s !  PLEASE CHECK", users.size(),username));
		}else if(users.size() == 1 && users.get(0).getPassword().equals(password))
			return users.get(0);
		return null;
	}
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 * @author D.W.
	 */
	public boolean isUsernameExists(String username){
		if(StringUtils.isEmpty(username)) return true;
		List<User> users = userDao.getUsersByCondition(username,null,null);
		return !users.isEmpty();
	}
	
}
