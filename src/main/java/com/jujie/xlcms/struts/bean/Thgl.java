package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Thgl  extends BaseBean{
	private Integer thid;
	private Integer rkid;
	private String thrq; //退货日期
	private String bcsl; //本次退货数量
	private String danjia; //本次退货单价
	private Integer ghs; // 供货商
	private String wlzl; // 物料质量
	private String remark; 
	
	
	

	public Integer getThid() {
		return thid;
	}
	
	public void setThid(Integer thid) {
		this.thid = thid;
	}
	
	public Integer getRkid() {
		return rkid;
	}

	public void setRkid(Integer rkid) {
		this.rkid = rkid;
	}

	public String getThrq() {
		return thrq;
	}
	public void setThrq(String thrq) {
		this.thrq = thrq;
	}
	public String getBcsl() {
		return bcsl;
	}

	public void setBcsl(String bcsl) {
		this.bcsl = bcsl;
	}

	public String getDanjia() {
		return danjia;
	}

	public void setDanjia(String danjia) {
		this.danjia = danjia;
	}

	public Integer getGhs() {
		return ghs;
	}

	public void setGhs(Integer ghs) {
		this.ghs = ghs;
	}

	public String getWlzl() {
		return wlzl;
	}

	public void setWlzl(String wlzl) {
		this.wlzl = wlzl;
	}
	
	 
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public Thgl mapRow(ResultSet rst, int rowNum) throws SQLException {
		Thgl rkjl = new Thgl();
		rkjl.setThid(rst.getInt("thid"));
		rkjl.setRkid(rst.getInt("rkid"));
		rkjl.setThrq(rst.getString("thrq"));
		rkjl.setBcsl(rst.getString("bcsl"));
		rkjl.setDanjia(rst.getString("danjia"));
		rkjl.setGhs(rst.getInt("ghs"));
		rkjl.setWlzl(rst.getString("wlzl"));
		rkjl.setRemark(rst.getString("remark"));
		return rkjl;
	}
	
	
}
