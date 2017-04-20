package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class KuCun extends BaseBean {
	
	private Integer kcid;
	private String clpp; // 车辆品牌
	private String clxh; // 车辆型号
	private String wlmc; // 物料名称
	private String wllx; // 物料类型  1油水  2滤芯  3清洗剂   4刹车片   5火花塞   6配件   7辅料  8油漆  9玻璃 10其它
	private String dqsl; //当前库存数量
	private String huowei; // 货位
	private String kclx; //库存类型  1通用配件 2油漆辅料 3专用配件 4 调漆
	private String remark; // 备注
	
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
