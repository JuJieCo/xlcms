package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Cwtzgl extends BaseBean{
	
	private Integer cwid;
	private String jine;  // ���
	private String zhaiyao; // ժҪ
	private String kmname; // ��Ŀ���� 
	private String kmtype;  // ��Ŀ����  //��ʱû��
	private String sztype; //��֧���� 0���� 1 ֧�� (��ѯ���� , һ�����������������֧��)
	private String fsdate; //�������� 
	private String remark; //��ע

	//����û�еĵ�Ҫ����������
	private Integer ybzfy;  //һ��ͻ�Ӧ��
	private Integer ybsjzfy;  //һ��ͻ�ʵ��
	private Integer kpzfy;  //����ͻ�Ӧ��
	private Integer kpsjzfy;  //����ͻ�ʵ��
	private Integer xyzfy;  //Э�鵥λӦ��
	private Integer xysjzfy;  //Э�鵥λʵ��
	
	private Integer qtsr; //��������ͳ��
	private Integer qtzc; //����֧��ͳ��
	
	private Integer yyzcyf; //Ӫҵ֧��Ӧ��(����)
	private Integer yyzcsf; //Ӫҵ֧��ʵ��(����)
	
	private Integer zcth; //Ӫҵ֧���˻�(����)
	
	
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
