package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Xydwgl  extends BaseBean{
	
	private int xyid;
	private String dwname; //��λ����
	private String dwqyr; //�Է�ǩԼ��
	private String taishu; //����̨��
	private String qixian; //Э������
	private String qyrq; //ǩԼʱ��
	private String dqrq; //����ʱ��
	private String status;//״̬
	private String remark; //��ע
	
	
	public int getXyid() {
		return xyid;
	}
	public void setXyid(int xyid) {
		this.xyid = xyid;
	}
	public String getDwname() {
		return dwname;
	}
	public void setDwname(String dwname) {
		this.dwname = dwname;
	}
	public String getDwqyr() {
		return dwqyr;
	}
	public void setDwqyr(String dwqyr) {
		this.dwqyr = dwqyr;
	}
	public String getTaishu() {
		return taishu;
	}
	public void setTaishu(String taishu) {
		this.taishu = taishu;
	}
	public String getQixian() {
		return qixian;
	}
	public void setQixian(String qixian) {
		this.qixian = qixian;
	}
	public String getQyrq() {
		return qyrq;
	}
	public void setQyrq(String qyrq) {
		this.qyrq = qyrq;
	}
	public String getDqrq() {
		return dqrq;
	}
	public void setDqrq(String dqrq) {
		this.dqrq = dqrq;
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
	public Xydwgl mapRow(ResultSet rst, int rowNum) throws SQLException {
		Xydwgl xydwgl = new Xydwgl();
		xydwgl.setXyid(rst.getInt("xyid"));
		xydwgl.setDwname(rst.getString("dwname"));
		xydwgl.setDwqyr(rst.getString("dwqyr"));
		xydwgl.setTaishu(rst.getString("taishu"));
		xydwgl.setQixian(rst.getString("qixian"));
		xydwgl.setQyrq(rst.getString("qyrq"));
		xydwgl.setDqrq(rst.getString("dqrq"));
		xydwgl.setStatus(rst.getString("status"));
		xydwgl.setRemark(rst.getString("remark"));
		return xydwgl;
	}
	
	

}
