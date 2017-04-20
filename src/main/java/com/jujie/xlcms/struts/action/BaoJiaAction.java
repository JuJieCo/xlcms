 package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.BaoJiaService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.BaoJia;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class BaoJiaAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private BaoJia baoJia;
	private List<BaoJia> baoJiaList;
	private ShiGongDan shiGongDan;
	private List<ShiGongDan> sgdList;;
	
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

	public BaoJia getBaoJia() {
		return baoJia;
	}

	public void setBaoJia(BaoJia baoJia) {
		this.baoJia = baoJia;
	}

	public List<BaoJia> getBaoJiaList() {
		return baoJiaList;
	}

	public void setBaoJiaList(List<BaoJia> baoJiaList) {
		this.baoJiaList = baoJiaList;
	}

	public ShiGongDan getShiGongDan() {
		return shiGongDan;
	}

	public void setShiGongDan(ShiGongDan shiGongDan) {
		this.shiGongDan = shiGongDan;
	}

	public List<ShiGongDan> getSgdList() {
		return sgdList;
	}

	public void setSgdList(List<ShiGongDan> sgdList) {
		this.sgdList = sgdList;
	}

	
	
	
	//查询报料工单
	public String showBaoliaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoliaoSGDList(shiGongDan, page);
		return "baoliaolist";
	}
	//查询报料工单(返回不带条件)
	public String showBaoliaoSGDListReturn() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoliaoSGDList(shiGongDan, page);
		return "baoliaolist";
	}
	
	
	//查询报价工单
	public String showBaoJiaSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoJiaSGDList(shiGongDan, page);
		return "baojialist";
	}
	
	
	//查询报价工单(返回不带条件)
	public String showBaoJiaSGDListReturn() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoJiaSGDList(shiGongDan, page);
		return "baojialist";
	}
	
	
	//查询备料工单
	public String showBeiLiaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBeiLiaoSGDList(shiGongDan, page);
		return "beiliaolist";
	}
	
	
	//查询备料工单(返回不带条件)
	public String showBeiLiaoSGDListReturn() throws Exception { //跳转不带条件用
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBeiLiaoSGDList(shiGongDan, page);
		return "beiliaolist";
	}
	
	
	//查询领料工单
	public String showLingLiaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryLingLiaoSGDList(shiGongDan, page);
		return "lingliaolist";
	}
	
	
	//查询领料工单(返回不带条件)
		public String showLingLiaoSGDListReturn() throws Exception {
			if (page == null) {
				page = new Page(1);
			}
			shiGongDan = null;
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			sgdList = baoJiaService.queryLingLiaoSGDList(shiGongDan, page);
			return "lingliaolist";
		}
	
		
	//查询补料工单
	public String showBuLiaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBuliaoSGDList(shiGongDan, page);
		return "buliaolist";
	}
	
/*****************************************************************************************************************/	
	
	// 查询工单报料列表(工单对应的申请报料的物料单)
	public String  showBaoliaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		return "baoliao";
	}
	
	
	// 查询工单报价列表(工单对应的申请报价的物料单)
	public String showBaoJiaList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return "baojia";
	}
	
	
	// 查询工单备料列表(工单对应的申请备料的物料单)
	public String showBeiliaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBeiliaoList(gdid);
		return "beiliao";
	}
	
	
	// 查询工单领料列表(工单对应的等待领料的物料单)
	public String showLingLiaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryLingliaoList(gdid);
		return "lingliao";
	}
	
	// 查询工单补料列表(工单对应的申请报价的物料单)
	public String showBuLiaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return "buliao";
	}
	
	//  查询工单退料列表
	public String showTuiLiaoList() throws Exception{
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryTuiliaoList(gdid);
		return "tuiliao";
	}
	
	
	/*****************************************************************************************************************/	
	
	//提交报料
	public String modifyBaoliaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
			baoJia.getSgd().setGdid(Integer.valueOf(gdid));
			baoJiaService.modifyBeiliaoAndBaojia(baoJia); //申请报价
		}
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
				if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
						baoJia.getSgd().setGdid(Integer.valueOf(gdid));
						baoJiaService.modifyBeiliaoAndBaojia(baoJia); //申请报价
				}
			}
			baoJiaService.modifySGDWlztForUpdate("1" , gdid);  
		}
		 
		return this.showBaoliaoSGDListReturn();  //报料后跳到报价LIST
	}
	
	
	//提交报价
	public String modifyBaojiaForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		String zfy = request.getParameter("shiGongDan.zfy");
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
					if(null != baoJia&&"1".equals(baoJia.getBjzt())){ 
						baoJiaService.modifyBeiliaoAndBaojia(baoJia);
					}
			}
			baoJiaService.modifySGDWlztForUpdate("2" , gdid); 
			baoJiaService.modifySGDZfyForUpdate(zfy, gdid);//所有报价物品的总费用
		}
		//shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		//baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		request.setAttribute("zfy", zfy);
		return this.showBaoJiaSGDListReturn();
	}
	
	
	//提交备料
	public String modifyBeiLiaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
					if(null != baoJia&&"3".equals(baoJia.getBjzt())){
						baoJiaService.modifyBeiLiaoDoneForUpdate(baoJia);
					}
			}
		boolean tag = true;
		for (BaoJia baoJia : baoJiaList) {
			if(null != baoJia&&"1".equals(baoJia.getSfyh())){
				if(null==baoJia.getRkjl().getRkid()||0==baoJia.getRkjl().getRkid()){
					 tag = false ;
					break;
				}
			}
		}
		if(tag){
			baoJiaService.modifySGDWlztForUpdate("4" , gdid); 
		}
		}
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		//baoJiaList = baoJiaService.queryBeiliaoList(gdid);
		return this.showBeiLiaoSGDListReturn();
	}
	
	
	//领料出库 1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	public String modifyLingliaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
					if(null != baoJia&&"4".equals(baoJia.getBjzt())){
						baoJiaService.modifyLingliaoForUpdate(baoJia);
					}
			}
		boolean tag = true;
		for (BaoJia baoJia : baoJiaList) {
			if(null==baoJia.getRkjl().getRkid()||null==baoJia.getBjid()){
				 tag = false ;
				break;
			}
		}
		if(tag){
			baoJiaService.modifySGDWlztForUpdate("5" , gdid); 
		}
			baoJiaService.modifySGDWxztForUpdate("2", gdid);	//只要有一个领料修改工单维修状态
		}
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return this.showLingLiaoSGDListReturn();
	}
	
	
	
	//提交补料
	public String modifyBuliaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
			baoJia.getSgd().setGdid(Integer.valueOf(gdid));
			baoJiaService.modifyBeiliaoAndBaojia(baoJia); //补料申请报价
		}
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
				if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
						baoJia.getSgd().setGdid(Integer.valueOf(gdid));
						baoJiaService.modifyBeiliaoAndBaojia(baoJia); //补料申请报价
				}
			}
			baoJiaService.modifySGDWlztForUpdate("1" , gdid);  
		}
		return this.showBaoJiaSGDListReturn();  //爆料后跳到报价LIST
	}
	
	
	// 提交退料
	public String modifyTuiLiaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String bjid = request.getParameter("bjid");
		String gdid = request.getParameter("gdid");
		String kcid = request.getParameter("kcid");
		String ckid = request.getParameter("ckid");
		String shuliang = request.getParameter("shuliang");
		
		baoJiaService.modifyTuiLiaoForSave(gdid, bjid , shuliang , kcid , ckid );
		return this.showTuiLiaoList();
	}
		
	/*****************************************************************************************************************/	

	//备料时 可以修改 物料报价表和库存表的物料名称
		public String showWlmcByID() throws Exception {
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			String gdid = request.getParameter("gdid");
			String bjid = request.getParameter("bjid");
			shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
			baoJia = baoJiaService.queryWlmcByID(bjid);
			return "beiliaomodify";
		}
			
			
			
		//对料时可以修改物料名称
		public String modifyWlmcForUpdate() throws Exception {
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			String gdid = shiGongDan.getGdid().toString(); 
			baoJiaService.modifyWlmcForUpdate(baoJia);
			shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
			baoJiaList = baoJiaService.queryBeiliaoList(gdid);
			return "beiliao";
		}
		
		
		//报价时可以删除物料(包括补料后再次报价的时候也可以删除某个)
		public String modifyBaoJiaForDelete()throws Exception{
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			String gdid = request.getParameter("gdid");
			String bjid = request.getParameter("bjid");
			String tag = request.getParameter("tag");
			baoJiaService.modifyBaoJiaForDelete(bjid, gdid);
			request.setAttribute("gdid", gdid);
			if(null!=tag&&"baojia".equals(tag)){  //报价删除跳转
				return this.showBaoJiaList();
			}else if(null!=tag&&"beiliao".equals(tag)){ //备料删除跳转
				return this.showBeiliaoList();
			}else if(null!=tag&&"lingliao".equals(tag)){ //领料删除跳转
				return this.showLingLiaoList();
			}else{
				return "";
			}
		}
			
	
	
	
	
			
			

			
			
	

}
