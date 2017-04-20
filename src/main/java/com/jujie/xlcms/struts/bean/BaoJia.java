package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class BaoJia extends BaseBean {

	private Integer bjid;
	private ShiGongDan sgd;
	private Rkjl rkjl;
	private Ckgl ckgl;
	private String wlmc; // 物料名称
	private String wlzl; // 物料质量
	private String bjrq; // 申请报价日期
	private String fhrq; // 申请发货日期
	private String rkrq;// 物料入库日期
	private String llrq; // 车间领料日期
	private String shuliang; // 数量
	private String danjia; // 单价
	private String gsf; // 工时费
	private String bjzt; // 报价状态  1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	private String sfyh;//是否要货
	private String remark; // 备注

	public BaoJia() {
		this.sgd = new ShiGongDan();
		this.rkjl = new Rkjl();
		this.ckgl = new Ckgl();
	}

	public Integer getBjid() {
		return bjid;
	}

	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}

	public ShiGongDan getSgd() {
		return sgd;
	}

	public void setSgd(ShiGongDan sgd) {
		this.sgd = sgd;
	}


	public Rkjl getRkjl() {
		return rkjl;
	}

	public void setRkjl(Rkjl rkjl) {
		this.rkjl = rkjl;
	}
	
	public Ckgl getCkgl() {
		return ckgl;
	}

	public void setCkgl(Ckgl ckgl) {
		this.ckgl = ckgl;
	}

	public String getRkrq() {
		return rkrq;
	}

	public void setRkrq(String rkrq) {
		this.rkrq = rkrq;
	}

	public String getWlmc() {
		return wlmc;
	}

	public void setWlmc(String wlmc) {
		this.wlmc = wlmc;
	}

	public String getWlzl() {
		return wlzl;
	}

	public void setWlzl(String wlzl) {
		this.wlzl = wlzl;
	}

	public String getBjrq() {
		return bjrq;
	}

	public void setBjrq(String bjrq) {
		this.bjrq = bjrq;
	}

	public String getFhrq() {
		return fhrq;
	}

	public void setFhrq(String fhrq) {
		this.fhrq = fhrq;
	}

	public String getLlrq() {
		return llrq;
	}

	public void setLlrq(String llrq) {
		this.llrq = llrq;
	}

	public String getShuliang() {
		return shuliang;
	}

	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}

	public String getDanjia() {
		return danjia;
	}

	public void setDanjia(String danjia) {
		this.danjia = danjia;
	}

	public String getGsf() {
		return gsf;
	}

	public void setGsf(String gsf) {
		this.gsf = gsf;
	}

	public String getBjzt() {
		return bjzt;
	}

	public void setBjzt(String bjzt) {
		this.bjzt = bjzt;
	}

	public String getSfyh() {
		return sfyh;
	}

	public void setSfyh(String sfyh) {
		this.sfyh = sfyh;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

 

	@Override
	public BaoJia mapRow(ResultSet rst, int rowNum) throws SQLException {
		BaoJia baoJia = new BaoJia();
		baoJia.setBjid(rst.getInt("bjid"));
		baoJia.getSgd().setGdid(rst.getInt("gdid"));
		baoJia.getRkjl().setRkid(rst.getInt("rkid"));
		baoJia.getCkgl().setCkid(rst.getInt("ckid"));
		baoJia.setWlmc(rst.getString("wlmc"));
		
		baoJia.setWlzl(rst.getString("wlzl"));
		baoJia.setBjrq(rst.getString("bjrq"));
		baoJia.setFhrq(rst.getString("fhrq"));
		baoJia.setRkrq(rst.getString("rkrq"));
		
		baoJia.setLlrq(rst.getString("llrq"));
		baoJia.setDanjia(rst.getString("danjia"));
		baoJia.setShuliang(rst.getString("shuliang"));
		baoJia.setGsf(rst.getString("gsf"));
		baoJia.setBjzt(rst.getString("bjzt"));
		baoJia.setSfyh(rst.getString("sfyh"));
		baoJia.setRemark(rst.getString("remark"));
		
		baoJia.getSgd().setDanhao(rst.getString("danhao"));
		baoJia.getSgd().setClpp(rst.getString("clpp"));
		baoJia.getSgd().setClxh(rst.getString("clxh"));
		baoJia.getSgd().setCjh(rst.getString("cjh"));
		baoJia.getSgd().setKhlx(rst.getString("khlx"));
		
		
		return baoJia;
	}

}
