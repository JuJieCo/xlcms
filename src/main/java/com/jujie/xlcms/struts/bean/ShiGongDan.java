package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class ShiGongDan extends BaseBean {

	private Integer gdid;
	private String danhao;
	private String cphm; // ���ƺ���
	private String cjh; // ���ܺ�
	private String clpp; // ����Ʒ��
	private String clxh; // �����ͺ�
	private String fdjh; // ��������
	private String fdjpx; // ����������
	private String cllc; // �������
	private String scrq; // ��������
	private String khmc; // �ͻ�����
	private String khdh; // �ͻ���ϵ�绰
	private String wxgw; // ά�޹���
	private String jxzxr; // ��������������
	private String jxzjr; // �����ռ�������
	private String bpzxr; // ��������������
	private String bpzjr; // �����ռ�������
	private String gddjrq; // �����Ǽ�����
	private String yjwgrq; // Ԥ���깤����
	private String sjwgrq; // ʵ���깤����
	
	
	private String khlx; // �ͻ�����   1�������� 2�������� 3�Ա����� 4Э�鵥λ 5�����ⵥ 6i�����ͻ� 
	private String sflx; // �շ�����    1����/ˢ��  2��Ա����  3�����⸶  4��λ����  5���շ���  6i�����ͻ� 
	private String wxlx; // ά������   1 ����ά��  2 �ӽ�����   3 ��������   4 ϴ������   5 ��Ʒ���� 
	private String wxzt; // ά��״̬   1����/���� 2ά��ʩ�� 3�ȴ�����  4������� 5���δ��/�޷��� 6Ƿ����� , 7��ʱ����
	
	
	private String dwmc; // Э�鵥λ���� 
	
	private String zfy; // �ܷ���
	private String sjzfy; //ʵ���տ���
	
	private String yjpf; //����Ԥ���⸶
	private String sjpf; //����ʵ���⸶
	
	private String wlzt;// 0δ���� 1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���,  7��ʱ����
	
	
	private String tbgs;//Ͷ����˾  1�˱�����,2ƽ������,3��������,4���Ᵽ��,5̫ƽ����,
												//  6��ر���,7�л����ϱ���,8���ٲƱ���,9�찲����,10�����,
												//  11̫ƽ����,12��̩����,13�������ñ���
	private String  bxdqrq;//���յ�������
	
	private String remark; // ��ע
	
	
	
	//��ѯ��ʱ���õ�ʱ��
	private String gddjrqb; //�����Ǽ����ڿ�ʼ
	private String gddjrqe; //�����Ǽ����ڽ���
	
	private String btimey;  //Ԥ���깤���ڿ�ʼ
	private String etimey;  //Ԥ���깤���ڽ���
	
	private String btimew; //ʵ���깤���ڿ�ʼ
	private String etimew; //ʵ���깤���ڽ���
	
	private String btimebx; //���յ������ڿ�ʼ
	private String etimebx; //���յ������ڽ���
	
	
	
	

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
