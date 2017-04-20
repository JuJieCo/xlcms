package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.KuCunService;
import com.jujie.xlcms.model.service.KuCunService.TongJi;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Ckgl;
import com.jujie.xlcms.struts.bean.Ghsgl;
import com.jujie.xlcms.struts.bean.KuCun;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.Thgl;

public class KuCunAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private KuCun kuCun;
	private List<KuCun> kuCunList;
	private Rkjl rkjl;
	private List<Rkjl> rkjlList;
	private Ckgl ckgl;
	private List<Ckgl> ckglList;
	private Thgl thgl;
	private List<Thgl> thglList;
	
	private TongJi tongJi;
	
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

	public KuCun getKuCun() {
		return kuCun;
	}

	public void setKuCun(KuCun kuCun) {
		this.kuCun = kuCun;
	}

	public List<KuCun> getKuCunList() {
		return kuCunList;
	}

	public void setKuCunList(List<KuCun> kuCunList) {
		this.kuCunList = kuCunList;
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
	
	public Ckgl getCkgl() {
		return ckgl;
	}

	public void setCkgl(Ckgl ckgl) {
		this.ckgl = ckgl;
	}

	public List<Ckgl> getCkglList() {
		return ckglList;
	}

	public void setCkglList(List<Ckgl> ckglList) {
		this.ckglList = ckglList;
	}

	public TongJi getTongJi() {
		return tongJi;
	}

	public void setTongJi(TongJi tongJi) {
		this.tongJi = tongJi;
	}

	public List<Ghsgl> getGhsglList() {
		return ghsglList;
	}

	public void setGhsglList(List<Ghsgl> ghsglList) {
		this.ghsglList = ghsglList;
	}
	
	public Thgl getThgl() {
		return thgl;
	}

	public void setThgl(Thgl thgl) {
		this.thgl = thgl;
	}

	public List<Thgl> getThglList() {
		return thglList;
	}

	public void setThglList(List<Thgl> thglList) {
		this.thglList = thglList;
	}

	/******************************************************************************************************************************************************/
	// 查询通用配件列表
	public String showKuCunTYList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "1";
		kuCunList = kuCunService.queryKuCunTYList(kuCun, page , kclx);
		return "listty";
	}
	
	public String showKuCunTYListReturn() throws Exception {//新增后跳转不带条件
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "1";
		kuCun =null;
		kuCunList = kuCunService.queryKuCunTYList(kuCun, page , kclx);
		return "listty";
	}
	
	// 进入通用配件 新增
	public String showKuCunTYForModifyAsSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		ghsglList=kuCunService.queryGhsglList(); //查询供货商列表
		return "addty";
	}

	// 新增通用配件
	public String modifyKuCunTYForSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
			rkjl.getKuCun().setKclx("1");
			kuCunService.modifyKuCunForSave(rkjl);  
		}
		if (null != rkjlList) {
			for (Rkjl rkjl : rkjlList) {
				if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
					rkjl.getKuCun().setKclx("1");
					kuCunService.modifyKuCunForSave(rkjl);  
				}
			}
		}
		return this.showKuCunTYListReturn();
	}
	
	
 
	
	/******************************************************************************************************************************************************/
	// 查询油漆辅料列表
	public String showKuCunYFList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "2";
		kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
		return "listyf";
	}
	
	public String showKuCunYFListReturn() throws Exception {//新增后跳转不带条件
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "2";
		kuCun =null;
		kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
		return "listyf";
	}
	
	// 进入油漆辅料
	public String showKuCunYFForModifyAsSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		ghsglList=kuCunService.queryGhsglList(); //查询供货商列表
		return "addyf";
	}
	
	
	// 新增油漆辅料
		public String modifyKuCunYFForSave() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
				rkjl.getKuCun().setKclx("2");
				kuCunService.modifyKuCunForSave(rkjl);  
			}
			if (null != rkjlList) {
				for (Rkjl rkjl : rkjlList) {
					if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
						rkjl.getKuCun().setKclx("2");
						kuCunService.modifyKuCunForSave(rkjl);  
					}
				}
			}
			return this.showKuCunYFListReturn();
		}
	
		
 
	
	/******************************************************************************************************************************************************/
	// 查询专用配件列表
	public String showKuCunZYList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "3";
		kuCunList = kuCunService.queryKuCunZYList(kuCun, page ,kclx);
		return "listzy";
	}
	
	public String queryKuCunZYListReturn() throws Exception {//新增后跳转不带条件
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "3";
		kuCun = null;
		kuCunList = kuCunService.queryKuCunZYList(kuCun, page, kclx);
		return "listzy";
	}
	
	// 进入专用配件
	public String showKuCunZYForModifyAsSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		ghsglList=kuCunService.queryGhsglList(); //查询供货商列表
		return "addzy";
	}
	
	
	// 新增专用配件
		public String modifyKuCunZYForSave() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
				rkjl.getKuCun().setKclx("3");
				kuCunService.modifyKuCunForSave(rkjl);  
			}
			if (null != rkjlList) {
				for (Rkjl rkjl : rkjlList) {
					if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
						rkjl.getKuCun().setKclx("3");
						kuCunService.modifyKuCunForSave(rkjl);  
					}
				}
			}
			return this.queryKuCunZYListReturn();
		}
		
		
//		 
//		public String showKuCunZYForModifyAsUpdate() throws Exception {
//			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
//			String kcid = request.getParameter("kcid");
//			kuCun = kuCunService.queryKuCunByID(kcid); //改成查入库记录信息 
//			return "updatezy";
//		}
//		
//		
//		public String modifyKuCunZYForUpdate() throws Exception {
//			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
//			kuCunService.modifyKuCunForUpdate(kuCun);
//			return this.queryKuCunZYListReturn();
//		}
		
/******************************************************************************************************************************************************/	

		//出库记录(油漆辅料出库)
	public String showCkglList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		if (page == null) {
			page = new Page(1);
		}
		String tag = request.getParameter("tag");
		ckglList = kuCunService.queryCkglList(ckgl, page , tag , null); //油漆辅料
		return "listck";
		}
		
	
		public String showCkglForModifyAsSave() throws Exception {
			return "addck";
		}
		
		//(油漆辅料出库)
		public String modifyCkglForSave() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			if (null != ckgl) {
				ckgl.setKclx("2");
				kuCunService.modifyCkglForSave(ckgl);  
			}
			if (null != ckglList) {
				for (Ckgl ckgl : ckglList) {
					ckgl.setKclx("2");
					kuCunService.modifyCkglForSave(ckgl);  
				}
			}
			request.setAttribute("tag", "yfck");
			return this.showCkglList();
		}
		

		
		
/******************************************************************************************************************************************************/			
	
	//调漆用料登记
		public String showKuCunTQList() throws Exception {
			if (page == null) {
				page = new Page(1);
			}
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String kclx = "4";
			kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
			return "listtq";
		}
		
		public String showKuCunTQListReturn() throws Exception {//新增后跳转不带条件
			if (page == null) {
				page = new Page(1);
			}
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String kclx = "4";
			kuCun =null;
			kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
			return "listtq";
		}
		
		// 进入新增调漆
		public String showKuCunTQForModifyAsSave() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			ghsglList=kuCunService.queryGhsglList(); //查询供货商列表
			return "addtq";
		}
		
		
		// 新增调漆
			public String modifyKuCunTQForSave() throws Exception {
				KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
				if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
					rkjl.getKuCun().setKclx("4");
					kuCunService.modifyKuCunForSave(rkjl);  
				}
				if (null != rkjlList) {
					for (Rkjl rkjl : rkjlList) {
						if (null != rkjl&&null!=rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())) {
							rkjl.getKuCun().setKclx("4");
							kuCunService.modifyKuCunForSave(rkjl);  
						}
					}
				}
				return this.showKuCunTQList();
			}
		
/******************************************************************************************************************************************************/			
	// 查看记录---查询入库出库退货记录
	public String showJiluList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kcid = request.getParameter("kcid");
		String tag =  request.getParameter("tag");
		kuCun = kuCunService.queryKuCunByID(kcid); //库存信息
		tongJi = kuCunService.queryTongJi(kcid , tag);
		return "jilu";
	}
	
	
	// 查入库明细 (操作 退货 修改数量 数量修改后要更新库存数量)
	public String showRkjlList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kcid = request.getParameter("kcid");
		kuCun = kuCunService.queryKuCunByID(kcid); //库存信息
		rkjlList = kuCunService.queryRkjlList(kcid);   
		return "jilurk";
	}
	
	
	// 查出库明细  
	public String showCkjlList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kcid = request.getParameter("kcid");
		String tag =  request.getParameter("tag");
		kuCun = kuCunService.queryKuCunByID(kcid); //库存信息
		ckglList = kuCunService.queryCkglList(null, null, tag, kcid);
		return "jiluck";
	}
	
	
	
	//进入修改记录
	public String showRkjlForModifyAsUpdate() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String rkid = request.getParameter("rkid");
		rkjl = kuCunService.queryRkjlByID(rkid);   
		ghsglList=kuCunService.queryGhsglList(); //查询供货商列表
		return "updaterk";
	}
	
	//修改记录
	public String modifyRkjlForModifyAsUpdate() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		kuCunService.modifyRkjlForUpdate(rkjl);
		return this.showRkjlList();
	}
	
	
/******************************************************************************************************************************************************/			
	//查退货明细  
		public String showThjlList() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String kcid = request.getParameter("kcid");
			kuCun = kuCunService.queryKuCunByID(kcid); //库存信息
			thglList =  kuCunService.queryThglList(kcid);
			return "jiluth";
		}
	
	//进入退货信息操作页面 
		public String showThglForModifyAsUpdate() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String rkid = request.getParameter("rkid");
			
			rkjl = kuCunService.queryRkjlByID(rkid);
			kuCun = kuCunService.queryKuCunByID(rkjl.getKuCun().getKcid().toString()); //找到库存表中的当前库存数量
			rkjl.getKuCun().setDqsl(kuCun.getDqsl());
			return"tuihuo";
	}
		
		
	// 提交退货记录
	public String modifyThglForUpdate() throws Exception {
		String thsl = request.getParameter("thsl");
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		kuCunService.modifyThglForUpdate(rkjl , thsl);
		return this.showRkjlList();
	}
		


		
		
/******************************************************************************************************************************************************/	
		
	
		

}
