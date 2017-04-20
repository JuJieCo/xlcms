package com.jujie.xlcms.struts.bean.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jujie.xlcms.model.utils.BaseBean;

public class SysRole extends BaseBean {

	private Integer roleID;
	private String roleName;
	private String remark;
	private List<SysResource> resourceList;
	
	public SysRole(){
		this.resourceList = new ArrayList<SysResource>();
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SysResource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<SysResource> resourceList) {
		this.resourceList = resourceList;
	}

	@Override
	public SysRole mapRow(ResultSet rs, int rownum) throws SQLException {
		SysRole role = new SysRole();
		role.setRoleID(rs.getInt("role_id"));
		role.setRoleName(rs.getString("role_name"));
		role.setRemark(rs.getString("remark"));
		return role;
	}
	
	
}
