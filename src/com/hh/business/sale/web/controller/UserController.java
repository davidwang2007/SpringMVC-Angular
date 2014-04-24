/**
 * 
 */
package com.hh.business.sale.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.business.sale.web.entity.User;
import com.hh.business.sale.web.util.EncryptHelper;
import com.hh.business.sale.web.vo.GeneralResultVo;

/**
 * USER CONTROLLER
 * @author david
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final Log logger = LogFactory.getLog("UserController");

	/**
	 * 查找所有用户
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody 
	public List<User> query(@RequestParam int pageIndex, @RequestParam int pageSize){
		return userService.getUsersByPage(pageIndex,pageSize);
	}

	/**
	 * 根据ID查找用户
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public User queryById(@PathVariable int id){
		return (User) userService.getEntity(User.class, id);
	}

	/**
	 * 更新用户
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public GeneralResultVo updateUser(@PathVariable int id,@RequestBody User user){
		User userOld = (User) userService.getEntity(User.class, id);
		baseService.saveOrUpdate(userOld.updateUser(user));
		return createGeneralResult(0, null);
	}

	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public GeneralResultVo createUser(@RequestBody User user){
		if(userService.isUsernameExists(user.getUsername())){
			return createGeneralResult(1, "用户名已存在,请更换名称");
		}
		user.setCreateDate(new Date());
		user.setPassword(EncryptHelper.getInstance().encrypt(user.getPassword()));
		baseService.saveOrUpdate(user);
		return createGeneralResult(0, null);
	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public GeneralResultVo deleteUser(@PathVariable int id){
		baseService.deleteEntity(User.class, id);
		return createGeneralResult(0, null);
	}
	
}
