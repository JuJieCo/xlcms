package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Rygl extends BaseBean {

	private Integer ryid;
	private String name;// ����
	private String sex;// �Ա�
	private String birthday;// ��������
	private String idcard;// ���֤��
	private String address;// ��ͥסַ
	private String education;// ���ѧ��
	private String dept; //����
	private String duty;// ְ��
	private String level;// ����
	private String workType;// ����
	private String entryDate;// ��ְʱ��
	private String leaveDate;// ��ְʱ��
	private String status;// ״̬
	private String remark;// ��ע

 
	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
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
	public Object mapRow(ResultSet rst, int rowNum) throws SQLException {
		Rygl rygl = new Rygl();
		rygl.setRyid(rst.getInt("ryid"));
		rygl.setName(rst.getString("name"));// ����
		rygl.setSex(rst.getString("sex"));// �Ա�
		rygl.setBirthday(rst.getString("birthday"));// ��������
		rygl.setIdcard(rst.getString("idcard"));// ���֤��
		rygl.setAddress(rst.getString("address"));// ��ͥסַ
		rygl.setEducation(rst.getString("education"));// ���ѧ��
		rygl.setDept(rst.getString("dept"));//����
		rygl.setDuty(rst.getString("duty"));// ְ��
		rygl.setLevel(rst.getString("level"));// ����
		rygl.setWorkType(rst.getString("work_type"));// ����
		rygl.setEntryDate(rst.getString("entry_date"));// ��ְʱ��
		rygl.setLeaveDate(rst.getString("leave_date"));// ��ְʱ��
		rygl.setStatus(rst.getString("status"));// ״̬
		rygl.setRemark(rst.getString("remark"));// ��ע
		return rygl;
	}

}
