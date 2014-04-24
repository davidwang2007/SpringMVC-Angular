/**
 * 
 */
package com.david.business.sale.web.vo;

import java.util.List;

/**
 * Office Left Menu
 * @author david
 *
 */
public class OfficeMenuVo {

	private int id;
	private String title;
	private String icon;
	private String state;
	private List children;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
}
