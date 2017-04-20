package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Ghsgl extends BaseBean {

	private Integer ghsid;
	private String name;
	private String lxdh1;
	private String lxdh2;
	private String address;
	private String status;
	private String remark;

	public Integer getGhsid() {
		return ghsid;
	}

	public void setGhsid(Integer ghsid) {
		this.ghsid = ghsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLxdh1() {
		return lxdh1;
	}

	public void setLxdh1(String lxdh1) {
		this.lxdh1 = lxdh1;
	}

	public String getLxdh2() {
		return lxdh2;
	}

	public void setLxdh2(String lxdh2) {
		this.lxdh2 = lxdh2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public Ghsgl mapRow(ResultSet rst, int rowNum) throws SQLException {
		Ghsgl ghsgl= new Ghsgl();
		ghsgl.setGhsid(rst.getInt("ghsid"));
		ghsgl.setName(rst.getString("name"));
		ghsgl.setLxdh1(rst.getString("lxdh1"));
		ghsgl.setLxdh2(rst.getString("lxdh2"));
		ghsgl.setAddress(rst.getString("address"));
		ghsgl.setStatus(rst.getString("status"));
		ghsgl.setRemark(rst.getString("remark"));
		return ghsgl;
	}

}
