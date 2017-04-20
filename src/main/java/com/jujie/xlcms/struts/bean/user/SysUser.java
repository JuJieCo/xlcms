package com.jujie.xlcms.struts.bean.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jujie.xlcms.model.utils.BaseBean;
import com.jujie.xlcms.struts.bean.Rygl;

public class SysUser extends BaseBean {
	private Integer userID;
	private String username;
	private String password;
	private Integer tag;
	private Rygl rygl;
	private SysRole treeRole;
	private List<SysRole> roleList;
	
	public SysUser(){
		this.rygl = new Rygl();
		this.roleList = new ArrayList<SysRole>();
		this.treeRole = new SysRole();
	}


	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

	public Rygl getRygl() {
		return rygl;
	}

	public void setRygl(Rygl rygl) {
		this.rygl = rygl;
	}

	public SysRole getTreeRole() {
		return treeRole;
	}

	public void setTreeRole(SysRole treeRole) {
		this.treeRole = treeRole;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}


	@Override
	public SysUser mapRow(ResultSet rst, int rowNum) throws SQLException {
		SysUser user = new SysUser();
		user.setUserID(rst.getInt("user_id"));
		user.setUsername(rst.getString("username"));
		user.setPassword(rst.getString("password"));
		user.setTag(rst.getInt("tag"));
		user.getRygl().setRyid(rst.getInt("ryid"));
		user.getRygl().setName(rst.getString("name"));
		return user;
	}
	
	
}
