/**
 * 
 */
package com.hh.business.sale.web.entity;

import java.util.Date;

/**
 * USER ENTITY
 * @author david
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private String realname;
	private Short age;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private Date createDate;
	private Date updateDate;
	private String description;
	
	public User(String username, String realname) {
		this.username = username;
		this.realname = realname;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 更新此用户的关键字段
	 * @param user
	 */
	public User updateUser(User user){
		realname = user.getRealname();
		address = user.getAddress();
		age = user.getAge();
		phone = user.getPhone();
		email = user.getEmail();
		description = user.getDescription();
		updateDate = new Date();
		gender = user.getGender();
		return this;
	}
}
