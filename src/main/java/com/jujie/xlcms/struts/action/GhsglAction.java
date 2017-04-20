package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.GhsglService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Ghsgl;

public class GhsglAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private Ghsgl ghsgl;
	private List<Ghsgl> ghsglList;

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

	public Ghsgl getGhsgl() {
		return ghsgl;
	}

	public void setGhsgl(Ghsgl ghsgl) {
		this.ghsgl = ghsgl;
	}

	public List<Ghsgl> getGhsglList() {
		return ghsglList;
	}

	public void setGhsglList(List<Ghsgl> ghsglList) {
		this.ghsglList = ghsglList;
	}

	
	
	public String showGhsglList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		GhsglService ghsglService = (GhsglService) this.getService("ghsglService");
		ghsglList = ghsglService.queryGhsglList(ghsgl, page);
		return "list";
	}
	
	public String showGhsglForModify() throws Exception{
		GhsglService ghsglService = (GhsglService)this.getService("ghsglService");
		String ghsid = request.getParameter("ghsid");
		ghsgl = ghsglService.queryGhsglByID(ghsid);
		return "modify";
	}
	
	public String modifyGhsgl()throws Exception{
		GhsglService ghsglService = (GhsglService)this.getService("ghsglService");
		ghsglService.modifyGhsgl(ghsgl);
		return this.showGhsglList();
	}
	
	public String showGhsglByID()throws Exception{
		GhsglService ghsglService = (GhsglService)this.getService("ghsglService");
		String ghsid = request.getParameter("ghsid");
		ghsgl = ghsglService.queryGhsglByID(ghsid);
		return "show";
	}

}
