package com.jujie.xlcms.struts.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.xlcms.model.utils.BaseBean;

public class Rygl extends BaseBean {

	private Integer ryid;
	private String name;// 姓名
	private String sex;// 性别
	private String birthday;// 出生年月
	private String idcard;// 身份证号
	private String address;// 家庭住址
	private String education;// 最高学历
	private String dept; //部门
	private String duty;// 职务
	private String level;// 级别
	private String workType;// 工种
	private String entryDate;// 入职时间
	private String leaveDate;// 离职时间
	private String status;// 状态
	private String remark;// 备注

 
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
		rygl.setName(rst.getString("name"));// 姓名
		rygl.setSex(rst.getString("sex"));// 性别
		rygl.setBirthday(rst.getString("birthday"));// 出生年月
		rygl.setIdcard(rst.getString("idcard"));// 身份证号
		rygl.setAddress(rst.getString("address"));// 家庭住址
		rygl.setEducation(rst.getString("education"));// 最高学历
		rygl.setDept(rst.getString("dept"));//部门
		rygl.setDuty(rst.getString("duty"));// 职务
		rygl.setLevel(rst.getString("level"));// 级别
		rygl.setWorkType(rst.getString("work_type"));// 工种
		rygl.setEntryDate(rst.getString("entry_date"));// 入职时间
		rygl.setLeaveDate(rst.getString("leave_date"));// 离职时间
		rygl.setStatus(rst.getString("status"));// 状态
		rygl.setRemark(rst.getString("remark"));// 备注
		return rygl;
	}

}
