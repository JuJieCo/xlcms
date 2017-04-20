package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class KuCun extends BaseBean {
	
	private Integer kcid;
	private String clpp; // ����Ʒ��
	private String clxh; // �����ͺ�
	private String wlmc; // ��������
	private String wllx; // ��������  1��ˮ  2��о  3��ϴ��   4ɲ��Ƭ   5����   6���   7����  8����  9���� 10����
	private String dqsl; //��ǰ�������
	private String huowei; // ��λ
	private String kclx; //�������  1ͨ����� 2���Ḩ�� 3ר����� 4 ����
	private String remark; // ��ע
	
	public KuCun() {
		 
	}
	

	public Integer getKcid() {
		return kcid;
	}

	public void setKcid(Integer kcid) {
		this.kcid = kcid;
	}

	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
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

	public String getDqsl() {
		return dqsl;
	}

	public void setDqsl(String dqsl) {
		this.dqsl = dqsl;
	}

	public String getHuowei() {
		return huowei;
	}

	public void setHuowei(String huowei) {
		this.huowei = huowei;
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
	public KuCun mapRow(ResultSet rst, int rowNum) throws SQLException {
		KuCun kuCun = new KuCun();
		kuCun.setKcid(rst.getInt("kcid"));
		kuCun.setClpp(rst.getString("clpp"));
		kuCun.setClxh(rst.getString("clxh"));
		kuCun.setWlmc(rst.getString("wlmc"));
		kuCun.setWllx(rst.getString("wllx"));
		kuCun.setDqsl(rst.getString("dqsl"));
		kuCun.setHuowei(rst.getString("huowei"));
		kuCun.setKclx(rst.getString("kclx"));
		kuCun.setRemark(rst.getString("remark"));
		return kuCun;
	}

}
