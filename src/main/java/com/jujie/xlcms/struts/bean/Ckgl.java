package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Ckgl extends BaseBean {

	private int ckid;
	private Rkjl rkjl;
	private String cphm;  //车牌号码
	private String ckrq; //出库日期
	private String cksl; //出库数量
	private String wlmc; //物料名称
	private String wllx; //物料类型
	private String kclx; //库存类型  1通用配件 2油漆辅料 3专用配件
	private String remark; //领用人
 
	public Ckgl(){
		this.rkjl = new Rkjl();
	}
	
	public int getCkid() {
		return ckid;
	}

	public void setCkid(int ckid) {
		this.ckid = ckid;
	}

	public Rkjl getRkjl() {
		return rkjl;
	}

	public void setRkjl(Rkjl rkjl) {
		this.rkjl = rkjl;
	}

	public String getCphm() {
		return cphm;
	}

	public void setCphm(String cphm) {
		this.cphm = cphm;
	}

	public String getCkrq() {
		return ckrq;
	}

	public void setCkrq(String ckrq) {
		this.ckrq = ckrq;
	}

	public String getCksl() {
		return cksl;
	}

	public void setCksl(String cksl) {
		this.cksl = cksl;
	}
	
	public String getWlmc() {
		return wlmc;
	}

	public void setWlmc(String wlmc) {
		this.wlmc = wlmc;
	}

	public String getWllx() {
		return wllx;
	}

	public void setWllx(String wllx) {
		this.wllx = wllx;
	}

	public String getKclx() {
		return kclx;
	}

	public void setKclx(String kclx) {
		this.kclx = kclx;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public Ckgl mapRow(ResultSet rst, int rowNum) throws SQLException {
		Ckgl ckgl = new Ckgl();
		ckgl.setCkid(rst.getInt("ckid"));
		ckgl.getRkjl().setRkid(rst.getInt("rkid"));
		ckgl.setCphm(rst.getString("cphm"));
		ckgl.setCkrq(rst.getString("ckrq"));
		ckgl.setCksl(rst.getString("cksl"));
		ckgl.setWlmc(rst.getString("wlmc"));
		ckgl.setWllx(rst.getString("wllx"));
		ckgl.setKclx(rst.getString("kclx"));
		ckgl.setRemark(rst.getString("remark"));
		return ckgl;
	}

}
