package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.RyglService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Rygl;

public class RyglAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private  Rygl  rygl;
	private  List< Rygl>  ryglList;
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
	public Rygl getRygl() {
		return rygl;
	}
	public void setRygl(Rygl rygl) {
		this.rygl = rygl;
	}
	public List<Rygl> getRyglList() {
		return ryglList;
	}
	public void setRyglList(List<Rygl> ryglList) {
		this.ryglList = ryglList;
	}
	
	
	
	public String showRyglList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		RyglService ryglService = (RyglService) this.getService("ryglService");
		ryglList = ryglService.queryRyglList(rygl, page);
		return "list";
	}
	
	public String showRyglForModify() throws Exception {
		RyglService ryglService = (RyglService) this.getService("ryglService");
		String ryid = request.getParameter("ryid");
		rygl = ryglService.queryRyglByID(ryid);
		return "modify";
	}
	
	public String modifyRygl() throws Exception {
		RyglService ryglService = (RyglService) this.getService("ryglService");
		 ryglService.modifyRygl(rygl);
		return this.showRyglList();
	}
	
	public String showRyglByID() throws Exception {
		RyglService ryglService = (RyglService) this.getService("ryglService");
		String ryid = request.getParameter("ryid");
		rygl = ryglService.queryRyglByID(ryid);
		return "show";
	}
	

}
