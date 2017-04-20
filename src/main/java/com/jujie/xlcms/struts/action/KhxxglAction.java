package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.KhxxglService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class KhxxglAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String s_token;
	private Page page;
	private ShiGongDan shiGongDan;
	private List<ShiGongDan> khxxList;
	private List<ShiGongDan> wxjlList;
	private List<Rygl> jdList;
	
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public ShiGongDan getShiGongDan() {
		return shiGongDan;
	}
	public void setShiGongDan(ShiGongDan shiGongDan) {
		this.shiGongDan = shiGongDan;
	}
	public List<ShiGongDan> getKhxxList() {
		return khxxList;
	}
	public void setKhxxList(List<ShiGongDan> khxxList) {
		this.khxxList = khxxList;
	}
	public List<ShiGongDan> getWxjlList() {
		return wxjlList;
	}
	public void setWxjlList(List<ShiGongDan> wxjlList) {
		this.wxjlList = wxjlList;
	}
	public List<Rygl> getJdList() {
		return jdList;
	}
	public void setJdList(List<Rygl> jdList) {
		this.jdList = jdList;
	}
	
	
	
	
	public String showKhxxList() throws Exception{
		if(page ==null ){
			page = new Page(1);
		}
		KhxxglService khxxService = (KhxxglService)this.getService("khxxService");
		khxxList = khxxService.queryKhxxList(shiGongDan, page);
		jdList = khxxService.queryAllJDList();
		return "list";
	}
	
	
	//Î¬ÐÞ¼ÇÂ¼  
	public String showWxjlList() throws Exception{
		KhxxglService khxxService = (KhxxglService)this.getService("khxxService");
		String cphm = request.getParameter("cphm");
		
		
		if(cphm!=null&&!"".equals(cphm)){
			cphm = new String(cphm.getBytes("ISO8859-1"),"UTF-8");
    	}

		
		wxjlList = khxxService.queryWxjlList(cphm);
		return "wxjllist";
	}

}
