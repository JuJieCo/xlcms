package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class ShiGongDan extends BaseBean {

	private Integer gdid;
	private String danhao;
	private String cphm; // 车牌号码
	private String cjh; // 车架号
	private String clpp; // 车辆品牌
	private String clxh; // 车辆型号
	private String fdjh; // 发动机号
	private String fdjpx; // 发动机排量
	private String cllc; // 车辆里程
	private String scrq; // 生产日期
	private String khmc; // 客户名称
	private String khdh; // 客户联系电话
	private String wxgw; // 维修顾问
	private String jxzxr; // 机修主修责任人
	private String jxzjr; // 机修终检责任人
	private String bpzxr; // 钣喷主修责任人
	private String bpzjr; // 钣喷终检责任人
	private String gddjrq; // 工单登记日期
	private String yjwgrq; // 预计完工日期
	private String sjwgrq; // 实际完工日期
	
	
	private String khlx; // 客户类型   1自主进店 2快速理赔 3自报保险 4协议单位 5返工免单 6i保养客户 
	private String sflx; // 收费类型    1付现/刷卡  2会员消费  3保险赔付  4单位挂账  5免收费用  6i保养客户 
	private String wxlx; // 维修类型   1 保养维修  2 钣金喷漆   3 机电钣喷   4 洗车美容   5 商品零售 
	private String wxzt; // 维修状态   1报价/备料 2维修施工 3等待结账  4结账离店 5检查未修/无费用 6欠账离店 , 7临时工单
	
	
	private String dwmc; // 协议单位名称 
	
	private String zfy; // 总费用
	private String sjzfy; //实际收款金额
	
	private String yjpf; //保险预计赔付
	private String sjpf; //保险实际赔付
	
	private String wlzt;// 0未报料 1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库,  7临时工单
	
	
	private String tbgs;//投保公司  1人保保险,2平安保险,3永安保险,4阳光保险,5太平洋保险,
												//  6大地保险,7中华联合保险,8国寿财保险,9天安保险,10安邦保险,
												//  11太平保险,12华泰保险,13出口信用保险
	private String  bxdqrq;//保险到期日期
	
	private String remark; // 备注
	
	
	
	//查询的时候用的时间
	private String gddjrqb; //工单登记日期开始
	private String gddjrqe; //工单登记日期结束
	
	private String btimey;  //预计完工日期开始
	private String etimey;  //预计完工日期结束
	
	private String btimew; //实际完工日期开始
	private String etimew; //实际完工日期结束
	
	private String btimebx; //保险到期日期开始
	private String etimebx; //保险到期日期结束
	
	
	
	

	public Integer getGdid() {
		return gdid;
	}

	public void setGdid(Integer gdid) {
		this.gdid = gdid;
	}

	public String getDanhao() {
		return danhao;
	}

	public void setDanhao(String danhao) {
		this.danhao = danhao;
	}

	public String getCphm() {
		return cphm;
	}

	public void setCphm(String cphm) {
		this.cphm = cphm;
	}

	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
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

	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	public String getFdjpx() {
		return fdjpx;
	}

	public void setFdjpx(String fdjpx) {
		this.fdjpx = fdjpx;
	}

	public String getCllc() {
		return cllc;
	}

	public void setCllc(String cllc) {
		this.cllc = cllc;
	}

	public String getScrq() {
		return scrq;
	}

	public void setScrq(String scrq) {
		this.scrq = scrq;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getKhdh() {
		return khdh;
	}

	public void setKhdh(String khdh) {
		this.khdh = khdh;
	}

	public String getWxgw() {
		return wxgw;
	}

	public void setWxgw(String wxgw) {
		this.wxgw = wxgw;
	}

	public String getJxzxr() {
		return jxzxr;
	}

	public void setJxzxr(String jxzxr) {
		this.jxzxr = jxzxr;
	}

	public String getJxzjr() {
		return jxzjr;
	}

	public void setJxzjr(String jxzjr) {
		this.jxzjr = jxzjr;
	}

	public String getBpzxr() {
		return bpzxr;
	}

	public void setBpzxr(String bpzxr) {
		this.bpzxr = bpzxr;
	}

	public String getBpzjr() {
		return bpzjr;
	}

	public void setBpzjr(String bpzjr) {
		this.bpzjr = bpzjr;
	}

	public String getGddjrq() {
		return gddjrq;
	}

	public void setGddjrq(String gddjrq) {
		this.gddjrq = gddjrq;
	}

	public String getYjwgrq() {
		return yjwgrq;
	}

	public void setYjwgrq(String yjwgrq) {
		this.yjwgrq = yjwgrq;
	}

	public String getSjwgrq() {
		return sjwgrq;
	}

	public void setSjwgrq(String sjwgrq) {
		this.sjwgrq = sjwgrq;
	}

	public String getKhlx() {
		return khlx;
	}

	public void setKhlx(String khlx) {
		this.khlx = khlx;
	}

	public String getSflx() {
		return sflx;
	}

	public void setSflx(String sflx) {
		this.sflx = sflx;
	}

	public String getWxlx() {
		return wxlx;
	}

	public void setWxlx(String wxlx) {
		this.wxlx = wxlx;
	}

	public String getWxzt() {
		return wxzt;
	}

	public void setWxzt(String wxzt) {
		this.wxzt = wxzt;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getZfy() {
		return zfy;
	}

	public void setZfy(String zfy) {
		this.zfy = zfy;
	}

	public String getSjzfy() {
		return sjzfy;
	}

	public void setSjzfy(String sjzfy) {
		this.sjzfy = sjzfy;
	}

	public String getYjpf() {
		return yjpf;
	}

	public void setYjpf(String yjpf) {
		this.yjpf = yjpf;
	}

	public String getSjpf() {
		return sjpf;
	}

	public void setSjpf(String sjpf) {
		this.sjpf = sjpf;
	}

	public String getWlzt() {
		return wlzt;
	}

	public void setWlzt(String wlzt) {
		this.wlzt = wlzt;
	}

	public String getTbgs() {
		return tbgs;
	}

	public void setTbgs(String tbgs) {
		this.tbgs = tbgs;
	}

	public String getBxdqrq() {
		return bxdqrq;
	}

	public void setBxdqrq(String bxdqrq) {
		this.bxdqrq = bxdqrq;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getGddjrqb() {
		return gddjrqb;
	}

	public void setGddjrqb(String gddjrqb) {
		this.gddjrqb = gddjrqb;
	}

	public String getGddjrqe() {
		return gddjrqe;
	}

	public void setGddjrqe(String gddjrqe) {
		this.gddjrqe = gddjrqe;
	}

	public String getBtimey() {
		return btimey;
	}

	public void setBtimey(String btimey) {
		this.btimey = btimey;
	}

	public String getEtimey() {
		return etimey;
	}

	public void setEtimey(String etimey) {
		this.etimey = etimey;
	}

	public String getBtimew() {
		return btimew;
	}

	public void setBtimew(String btimew) {
		this.btimew = btimew;
	}

	public String getEtimew() {
		return etimew;
	}

	public void setEtimew(String etimew) {
		this.etimew = etimew;
	}

	public String getBtimebx() {
		return btimebx;
	}

	public void setBtimebx(String btimebx) {
		this.btimebx = btimebx;
	}

	public String getEtimebx() {
		return etimebx;
	}

	public void setEtimebx(String etimebx) {
		this.etimebx = etimebx;
	}

	@Override
	public ShiGongDan mapRow(ResultSet rst, int rowNum) throws SQLException {
		ShiGongDan shiGongDan = new ShiGongDan();
		shiGongDan.setGdid(rst.getInt("gdid"));
		shiGongDan.setDanhao(rst.getString("danhao"));
		shiGongDan.setCphm(rst.getString("cphm"));
		shiGongDan.setCjh(rst.getString("cjh"));
		shiGongDan.setClpp(rst.getString("clpp"));
		shiGongDan.setClxh(rst.getString("clxh"));
		shiGongDan.setFdjh(rst.getString("fdjh"));
		shiGongDan.setFdjpx(rst.getString("fdjpx"));
		shiGongDan.setCllc(rst.getString("cllc"));
		shiGongDan.setScrq(rst.getString("scrq"));
		shiGongDan.setKhmc(rst.getString("khmc"));
		shiGongDan.setKhdh(rst.getString("khdh"));
		shiGongDan.setWxgw(rst.getString("wxgw"));
		shiGongDan.setJxzjr(rst.getString("jxzjr"));
		shiGongDan.setJxzxr(rst.getString("jxzxr"));
		shiGongDan.setBpzjr(rst.getString("bpzjr"));
		shiGongDan.setBpzxr(rst.getString("bpzxr"));
		shiGongDan.setGddjrq(rst.getString("gddjrq"));
		shiGongDan.setYjwgrq(rst.getString("yjwgrq"));
		shiGongDan.setSjwgrq(rst.getString("sjwgrq"));
		shiGongDan.setKhlx(rst.getString("khlx"));
		shiGongDan.setSflx(rst.getString("sflx"));
		shiGongDan.setSflx(rst.getString("sflx"));
		shiGongDan.setWxlx(rst.getString("wxlx"));
		shiGongDan.setWxzt(rst.getString("wxzt"));
		shiGongDan.setDwmc(rst.getString("dwmc"));
		shiGongDan.setZfy(rst.getString("zfy"));
		shiGongDan.setSjzfy(rst.getString("sjzfy"));
		shiGongDan.setYjpf(rst.getString("yjpf"));
		shiGongDan.setSjpf(rst.getString("sjpf"));
		shiGongDan.setWlzt(rst.getString("wlzt"));
		shiGongDan.setTbgs(rst.getString("tbgs"));
		shiGongDan.setBxdqrq(rst.getString("bxdqrq"));
		shiGongDan.setRemark(rst.getString("remark"));
		return shiGongDan;
	}

}
