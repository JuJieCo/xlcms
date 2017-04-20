package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Rkjl  extends BaseBean{
	private Integer rkid;
	private KuCun kuCun;
	private Ghsgl ghs; // ������
	private String rkrq; //�������
	private String bcsl; //���ν�������
	private String danjia; //���ν�������
	private String wlzl; // ��������
	private int sfzf; //�Ƿ�֧������  1δ������  2�Ѹ�����
	private String remark; 
	
	//��������֧��̨��
	private String thsl;//�˻�����
	private String thdj;//�˻�����
	
	public Rkjl() {
		this.ghs = new Ghsgl();
		this.kuCun= new KuCun();
	}
	
	
	public Integer getRkid() {
		return rkid;
	}
	public void setRkid(Integer rkid) {
		this.rkid = rkid;
	}
	 
	public KuCun getKuCun() {
		return kuCun;
	}

	public void setKuCun(KuCun kuCun) {
		this.kuCun = kuCun;
	}

	public String getRkrq() {
		return rkrq;
	}
	public void setRkrq(String rkrq) {
		this.rkrq = rkrq;
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

	public Ghsgl getGhs() {
		return ghs;
	}
	public void setGhs(Ghsgl ghs) {
		this.ghs = ghs;
	}
	public String getWlzl() {
		return wlzl;
	}

	public void setWlzl(String wlzl) {
		this.wlzl = wlzl;
	}
	
	public int getSfzf() {
		return sfzf;
	}

	public void setSfzf(int sfzf) {
		this.sfzf = sfzf;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getThsl() {
		return thsl;
	}


	public void setThsl(String thsl) {
		this.thsl = thsl;
	}

	public String getThdj() {
		return thdj;
	}

	public void setThdj(String thdj) {
		this.thdj = thdj;
	}


	@Override
	public Rkjl mapRow(ResultSet rst, int rowNum) throws SQLException {
		Rkjl rkjl = new Rkjl();
		rkjl.setRkid(rst.getInt("rkid"));
		rkjl.getKuCun().setKcid(rst.getInt("kcid"));
		rkjl.getGhs().setGhsid(rst.getInt("ghsid"));
		rkjl.getGhs().setName(rst.getString("ghsname"));
		rkjl.setRkrq(rst.getString("rkrq"));
		rkjl.setBcsl(rst.getString("bcsl"));
		rkjl.setDanjia(rst.getString("danjia"));
		rkjl.setWlzl(rst.getString("wlzl"));
		rkjl.setRemark(rst.getString("remark"));
		return rkjl;
	}
	
	
}
