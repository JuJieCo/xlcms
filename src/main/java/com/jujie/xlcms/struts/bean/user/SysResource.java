package com.jujie.xlcms.struts.bean.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jujie.xlcms.model.utils.BaseBean;

public class SysResource extends BaseBean {

	private Integer resourceID;
	private String resourceName;
	private String resourceUrl;
	private Integer resourcePID;  //ORDER BY resource_pid ASC  这样排序,把同一个菜单下的排在一起
	private String resourceSign;
	
	private List<SysResource> resourceList;

	public SysResource() {
		this.resourceList = new ArrayList<SysResource>();
	}

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public Integer getResourcePID() {
		return resourcePID;
	}

	public void setResourcePID(Integer resourcePID) {
		this.resourcePID = resourcePID;
	}

	public String getResourceSign() {
		return resourceSign;
	}

	public void setResourceSign(String resourceSign) {
		this.resourceSign = resourceSign;
	}

	public List<SysResource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<SysResource> resourceList) {
		this.resourceList = resourceList;
	}

	@Override
	public SysResource mapRow(ResultSet rst, int rownum) throws SQLException {
		SysResource resource = new SysResource();
		resource.setResourceID(rst.getInt("resource_id"));
		resource.setResourceName(rst.getString("resource_name"));
		resource.setResourcePID(rst.getInt("Resource_pid"));
		resource.setResourceUrl(rst.getString("resource_url"));
		resource.setResourceSign(rst.getString("resource_sign"));
		return resource;
	}

}
