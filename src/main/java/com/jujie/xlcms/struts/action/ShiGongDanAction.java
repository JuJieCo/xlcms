package com.jujie.xlcms.struts.action; 
import java.util.List;

import com.jujie.xlcms.model.service.BaoJiaService;
import com.jujie.xlcms.model.service.ShiGongDanService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.BaoJia;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class ShiGongDanAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private ShiGongDan shiGongDan;
	private List<ShiGongDan> shiGongDanList;
	private List<BaoJia> baoJiaList;
	private List<Rygl> ryList;
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

	public List<ShiGongDan> getShiGongDanList() {
		return shiGongDanList;
	}

	public void setShiGongDanList(List<ShiGongDan> shiGongDanList) {
		this.shiGongDanList = shiGongDanList;
	}

	public List<BaoJia> getBaoJiaList() {
		return baoJiaList;
	}

	public void setBaoJiaList(List<BaoJia> baoJiaList) {
		this.baoJiaList = baoJiaList;
	}

	public List<Rygl> getRyList() {
		return ryList;
	}

	public void setRyList(List<Rygl> ryList) {
		this.ryList = ryList;
	}

	public List<Rygl> getJdList() {
		return jdList;
	}

	public void setJdList(List<Rygl> jdList) {
		this.jdList = jdList;
	}

	/*******新增工单*****************************************************************************************************************************/
	// 查询施工单列表
	public String showShiGongDanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "list";
	}
	
	// 查询施工单列表(返回不带条件)
	public String showShiGongDanListRetuen() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "list";
	} 
	
	
	//跳转新增施工单页面
	public String showShiGongDanForModifyAsSave() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			shiGongDan = shiGongDanService.getShiGongDanForModifyAsSave();
		return "add";
	}
	//新增工单
	public String modifyShiGongDanForSave() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDan(shiGongDan);
		}
		return this.showShiGongDanListRetuen();
	}
	
	/**********临时工单**************************************************************************************************************************/
	// 查询临时施工单列表
	public String showShiGongDanTempList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanTempList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "templist";
	}
		
	// 查询临时施工单列表(返回不带条件)
	public String showShiGongDanTempListReturn() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanTempList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "templist";
	}
				
	
	//跳转新增/修改临时施工单页面
	public String showShiGongDanTempForModify() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			String gdid = request.getParameter("gdid");
			shiGongDan = shiGongDanService.getShiGongDanTempForModify(gdid);   
		return "tempmodify";
		}
	
	//新增修改临时工单
	public String modifyShiGongDanTemp() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDanTemp(shiGongDan);
		}
		return this.showShiGongDanTempListReturn(); 
	}
		
	//跳转临时工单到正常工单
	public String showShiGongDanTempTijiaoForModifyAsUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			String gdid = request.getParameter("gdid");
			shiGongDan = shiGongDanService.queryShiGongDanByID(gdid); 
		return "temptijiao";
	}
		
	//提交临时工单到正常工单
	public String modifyShiGongDanTempTijiaoForUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDanTempForUpdate(shiGongDan);
		}
		return this.showShiGongDanListRetuen();
	}
		
		
	/*********结账工单***************************************************************************************************************************/
	// 查询待结账施工单列表
	public String showShiGongDanJiesuanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		 
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanJiesuanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "jiesuanlist";
	}
	
	//进入结算页面(修改)
	public String showShiGongDanJiesuanForModifyAsUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			//进入修改页面
		String id = request.getParameter("gdid");
		shiGongDan = shiGongDanService.queryShiGongDanByID(id);
		baoJiaList = shiGongDanService.queryBaoJiaList(id);
		return "jiesuanupdate";
	}
	//修改操作(结算)
	public String modifyShiGongDanJiesuanForUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDan(shiGongDan);
		}
		return this.showShiGongDanJiesuanList();
	}
	
	
	/*********查看*******************************************************************************************************/
	//查看施工单与对应的料单
	public String showShiGongDanByID() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this.getService("shiGongDanService");
		String id = request.getParameter("gdid");
		shiGongDan = shiGongDanService.queryShiGongDanByID(id);
		baoJiaList = shiGongDanService.queryBaoJiaList(id);
		ryList = shiGongDanService.queryRYList();
		return "show";
	}
	
	/*********料单*******************************************************************************************************/
//	//工单进入备料页面
//	public String showBeiLiaoDan() throws Exception {
//		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
//		String gdid = request.getParameter("gdid");
//		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
//		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
//		return "beiliaoq";
//	}
	
	//申请备料
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
//	public String modifyBeiLiao() throws Exception {
//		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
//		String gdid = request.getParameter("gdid");
//		String zfy = request.getParameter("zfy");
//		if(null!=baoJiaList){
//			for (BaoJia baoJia : baoJiaList) {
//				if (null != baoJia) {
//					if(null!=gdid&&!"".equals(gdid)){
//						baoJiaService.modifyBeiLiaoForUpdate(baoJia); //申请备料
//					}
//				}
//			}
//			baoJiaService.modifySGDZfyForUpdate(zfy, gdid);//重新计算需要的物流的总费用
//			baoJiaService.modifySGDWlztForUpdate("3" , gdid);  
//		}
//		return this.showShiGongDanListRetuen();
//	}
//	
	/*********报价管理 查看待备料工单*******************************************************************************************************/	
	public String showBeiliaoShiGongDanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		 
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryBeiliaoShiGongDanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "beiliaolist"; 
	}
	
	//工单进入备料页面
	public String showBeiLiaoShiGongDan() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return "beiliaoqq";
	}
	
	//申请备料
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	public String modifyBeiLiaoShiGongDan() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		String zfy = request.getParameter("zfy");
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
				if (null != baoJia) {
					if(null!=gdid&&!"".equals(gdid)){
						baoJiaService.modifyBeiLiaoForUpdate(baoJia); //申请备料
					}
				}
			}
			baoJiaService.modifySGDZfyForUpdate(zfy, gdid);//重新计算需要的物流的总费用
			baoJiaService.modifySGDWlztForUpdate("3" , gdid);  
		}
		return this.showBeiliaoShiGongDanList();
	}
	
	/*********施工单信息 高级管理查询*******************************************************************************************************/	
	public String showShiGongDanInfoList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanInfoList(shiGongDan, page);
		jdList = shiGongDanService.queryAllJDList();
		return "infolist";
	}
	
	
	//跳转修改施工单信息页面
		public String showShiGongDanInfoForModify() throws Exception {
			ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
				String gdid = request.getParameter("gdid");
				shiGongDan = shiGongDanService.queryShiGongDanInfoForModify(gdid);   
				jdList = shiGongDanService.queryAllJDList();
			return "infomodify";
			}
	
		// 修改工单信息
		public String modifyShiGongDanInfo() throws Exception {
			ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			if (null != shiGongDan) {
				shiGongDanService.modifyShiGongDanInfo(shiGongDan);
			}
			return this.showShiGongDanInfoList(); 
		}
	
	
	 
}
