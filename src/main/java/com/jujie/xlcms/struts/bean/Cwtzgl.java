package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Cwtzgl extends BaseBean{
	
	private Integer cwid;
	private String jine;  // 金额
	private String zhaiyao; // 摘要
	private String kmname; // 科目名称 
	private String kmtype;  // 科目类型  //暂时没用
	private String sztype; //收支类型 0收入 1 支出 (查询条件 , 一个表用来区分收入和支出)
	private String fsdate; //发生日期 
	private String remark; //备注

	//表里没有的但要计算查出来的
	private Integer ybzfy;  //一般客户应收
	private Integer ybsjzfy;  //一般客户实收
	private Integer kpzfy;  //快赔客户应收
	private Integer kpsjzfy;  //快赔客户实收
	private Integer xyzfy;  //协议单位应收
	private Integer xysjzfy;  //协议单位实收
	
	private Integer qtsr; //其他收入统计
	private Integer qtzc; //其他支出统计
	
	private Integer yyzcyf; //营业支出应付(物料)
	private Integer yyzcsf; //营业支出实付(物料)
	
	private Integer zcth; //营业支出退货(物料)
	
	
	public Cwtzgl() {
		
	}
	
	public Integer getCwid() {
		return cwid;
	}

	public void setCwid(Integer cwid) {
		this.cwid = cwid;
	}

	public String getJine() {
		return jine;
	}

	public void setJine(String jine) {
		this.jine = jine;
	}

	public String getZhaiyao() {
		return zhaiyao;
	}

	public void setZhaiyao(String zhaiyao) {
		this.zhaiyao = zhaiyao;
	}

	public String getKmname() {
		return kmname;
	}

	public void setKmname(String kmname) {
		this.kmname = kmname;
	}

	public String getKmtype() {
		return kmtype;
	}

	public void setKmtype(String kmtype) {
		this.kmtype = kmtype;
	}

	public String getSztype() {
		return sztype;
	}

	public void setSztype(String sztype) {
		this.sztype = sztype;
	}
	
	public String getFsdate() {
		return fsdate;
	}

	public void setFsdate(String fsdate) {
		this.fsdate = fsdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getYbzfy() {
		return ybzfy;
	}

	public void setYbzfy(Integer ybzfy) {
		this.ybzfy = ybzfy;
	}

	public Integer getYbsjzfy() {
		return ybsjzfy;
	}

	public void setYbsjzfy(Integer ybsjzfy) {
		this.ybsjzfy = ybsjzfy;
	}

	public Integer getKpzfy() {
		return kpzfy;
	}

	public void setKpzfy(Integer kpzfy) {
		this.kpzfy = kpzfy;
	}

	public Integer getKpsjzfy() {
		return kpsjzfy;
	}

	public void setKpsjzfy(Integer kpsjzfy) {
		this.kpsjzfy = kpsjzfy;
	}

	public Integer getXyzfy() {
		return xyzfy;
	}

	public void setXyzfy(Integer xyzfy) {
		this.xyzfy = xyzfy;
	}

	public Integer getXysjzfy() {
		return xysjzfy;
	}

	public void setXysjzfy(Integer xysjzfy) {
		this.xysjzfy = xysjzfy;
	}
	
	public Integer getQtsr() {
		return qtsr;
	}

	public void setQtsr(Integer qtsr) {
		this.qtsr = qtsr;
	}
	
	public Integer getYyzcyf() {
		return yyzcyf;
	}

	public void setYyzcyf(Integer yyzcyf) {
		this.yyzcyf = yyzcyf;
	}

	public Integer getYyzcsf() {
		return yyzcsf;
	}

	public void setYyzcsf(Integer yyzcsf) {
		this.yyzcsf = yyzcsf;
	}
	
	public Integer getZcth() {
		return zcth;
	}

	public void setZcth(Integer zcth) {
		this.zcth = zcth;
	}

	public Integer getQtzc() {
		return qtzc;
	}

	public void setQtzc(Integer qtzc) {
		this.qtzc = qtzc;
	}

	@Override
	public Cwtzgl mapRow(ResultSet rst, int rowNum) throws SQLException {
		Cwtzgl cwtzgl = new Cwtzgl();
		cwtzgl.setCwid(rst.getInt("cwid"));
		cwtzgl.setJine(rst.getString("jine"));
		cwtzgl.setZhaiyao(rst.getString("zhaiyao"));
		cwtzgl.setKmname(rst.getString("kmname"));
		cwtzgl.setKmtype(rst.getString("kmtype"));
		cwtzgl.setSztype(rst.getString("sztype"));
		cwtzgl.setFsdate(rst.getString("fsdate"));
		cwtzgl.setRemark(rst.getString("remark"));
		return cwtzgl;
	}
	

}
