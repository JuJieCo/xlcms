package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.CwtzglService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Cwtzgl;
import com.jujie.xlcms.struts.bean.Ghsgl;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class CwtzglAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private Cwtzgl cwtzgl;
	private Cwtzgl tongji;
	private List<Cwtzgl> cwtzglList;
	private ShiGongDan sgd;
	private List<ShiGongDan> sgdList;
	private Rkjl rkjl;
	private List<Rkjl>rkjlList;
	private List<Ghsgl> ghsList;
	
	
	
	
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
	public Cwtzgl getCwtzgl() {
		return cwtzgl;
	}
	public void setCwtzgl(Cwtzgl cwtzgl) {
		this.cwtzgl = cwtzgl;
	}
	public List<Cwtzgl> getCwtzglList() {
		return cwtzglList;
	}
	public void setCwtzglList(List<Cwtzgl> cwtzglList) {
		this.cwtzglList = cwtzglList;
	}
	public ShiGongDan getSgd() {
		return sgd;
	}
	public void setSgd(ShiGongDan sgd) {
		this.sgd = sgd;
	}
	public List<ShiGongDan> getSgdList() {
		return sgdList;
	}
	public void setSgdList(List<ShiGongDan> sgdList) {
		this.sgdList = sgdList;
	}
	public Cwtzgl getTongji() {
		return tongji;
	}
	public void setTongji(Cwtzgl tongji) {
		this.tongji = tongji;
	}
	public Rkjl getRkjl() {
		return rkjl;
	}
	public void setRkjl(Rkjl rkjl) {
		this.rkjl = rkjl;
	}
	public List<Rkjl> getRkjlList() {
		return rkjlList;
	}
	public void setRkjlList(List<Rkjl> rkjlList) {
		this.rkjlList = rkjlList;
	}
	public List<Ghsgl> getGhsList() {
		return ghsList;
	}
	public void setGhsList(List<Ghsgl> ghsList) {
		this.ghsList = ghsList;
	}
	
	/**
	 * 经营收入
	 * */
	//经营收入 明细
	public  String showCwtzglListJYSR() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		String gddjrqb = request.getParameter("gddjrqb");
		String gddjrqe = request.getParameter("gddjrqe");
		
		sgdList = cwtzglService.queryShiGongDanList(sgd, page , gddjrqb , gddjrqe);
		tongji = cwtzglService.queryYYSR(sgd , gddjrqb , gddjrqe);
		//经营收入  应收实收
		
		request.setAttribute("gddjrqb", gddjrqb);
		request.setAttribute("gddjrqe", gddjrqe);
		return "yysrlist";
	}
	
	
	
	
	
	
	
	
	
	
	
	 /**
	  * 其他收入 
	  * */
	//其他收入 明细
	public  String showCwtzglListQTSR() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		String bfsdate = request.getParameter("bfsdate");
		String efsdate = request.getParameter("efsdate");
		
		cwtzglList = cwtzglService.queryCwtzglListQTSR(cwtzgl , page , bfsdate , efsdate);
		tongji = cwtzglService.queryQTSR(cwtzgl , bfsdate , efsdate);
		
		request.setAttribute("bfsdate", bfsdate);
		request.setAttribute("efsdate", efsdate);
		return "qtsrlist";
	}
	//进入其他收入 新增 修改页面
	public String showCwtzglQTSRForModify() throws Exception {
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		String cwid = request.getParameter("cwid");
		cwtzgl = cwtzglService.queryCwtzglQTSRByID(cwid);
		return "qtsrmodify";
	}
	// 执行新增修改其他收入
	public String modifyCwtzglQTSR() throws Exception {
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		cwtzglService.modifyCwtzglQTSR(cwtzgl);
		return this.showCwtzglListQTSR();
	}
	//查看其他收入
	public String showCwtzglQTSR() throws Exception {
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		String cwid = request.getParameter("cwid");
		cwtzgl = cwtzglService.queryCwtzglQTSRByID(cwid);
		return "qtsrshow";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 经营支出 (物料)
	 * */
	//经营支出 
	public  String showCwtzglListJYZC() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		
		String rkrqb = request.getParameter("rkrqb");
		String rkrqe = request.getParameter("rkrqe");
		
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		ghsList = cwtzglService.queryGhsglList();
		rkjlList = cwtzglService.queryRkjlList(rkjl, page, rkrqb, rkrqe);
		tongji = cwtzglService.queryYYZC(rkjl, rkrqb, rkrqe);
		request.setAttribute("rkrqb", rkrqb);
		request.setAttribute("rkrqe", rkrqe);
		return "yyzclist";
	}
	
	//设置 营业支出(物料)已支付 未支付  1未付货款  2已付货款
		public String modifyRkjlforZHIFU()throws Exception{
			CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
			String sfzfStr = request.getParameter("sfzf");
			String rkidStr = request.getParameter("rkid");
			
			cwtzglService.modifyRkjlforZHIFU(sfzfStr , rkidStr);
			
			return this.showCwtzglListJYZC();
		}

		 
		//营业退款(物料退款)
		
//		public  String showCwtzglListJYTK() throws Exception {
//			if (page == null) {
//				page = new Page(1);
//			}
//			
//			CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
//			ghsList = cwtzglService.queryGhsglList();
//			rkjlList = cwtzglService.queryRkjlList(rkjl, page, rkrqb, rkrqe);
//			tongji = cwtzglService.queryYYZC(rkjl, rkrqb, rkrqe);
//			request.setAttribute("rkrqb", rkrqb);
//			request.setAttribute("rkrqe", rkrqe);
//			return "yytklist";
//		}
		
	
		
		
		
		
		
		
		
		
	/**
	 * 其他支出
	 * */
	//其他支出 明细
	public  String showCwtzglListQTZC() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		if (page == null) {
			page = new Page(1);
		}
		CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
		String bfsdate = request.getParameter("bfsdate");
		String efsdate = request.getParameter("efsdate");
		
		cwtzglList = cwtzglService.queryCwtzglListQTZC(cwtzgl , page , bfsdate , efsdate);
		tongji = cwtzglService.queryQTZC(cwtzgl , bfsdate , efsdate);
		
		request.setAttribute("bfsdate", bfsdate);
		request.setAttribute("efsdate", efsdate);

		return "qtzclist";
	}
		//进入其他支出 新增 修改页面
		public String showCwtzglQTZCForModify() throws Exception {
			CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
			String cwid = request.getParameter("cwid");
			cwtzgl = cwtzglService.queryCwtzglQTZCByID(cwid);
			return "qtzcmodify";
		}
		// 执行新增修改其他收入
		public String modifyCwtzglQTZC() throws Exception {
			CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
			cwtzglService.modifyCwtzglQTZC(cwtzgl);
			return this.showCwtzglListQTZC();
		}
		//查看其他收入
		public String showCwtzglQTZC() throws Exception {
			CwtzglService cwtzglService = (CwtzglService)this.getService("cwtzglService");
			String cwid = request.getParameter("cwid");
			cwtzgl = cwtzglService.queryCwtzglQTZCByID(cwid);
			return "qtzcshow";
		}
	
	

}
