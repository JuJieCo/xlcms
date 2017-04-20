package com.jujie.xlcms.model.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.jujie.xlcms.model.dao.CwtzglDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Cwtzgl;
import com.jujie.xlcms.struts.bean.Ghsgl;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class CwtzglService {
	
	private CwtzglDAO cwtzglDAOSer;

	public void setCwtzglDAOSer(CwtzglDAO cwtzglDAOSer) {
		this.cwtzglDAOSer = cwtzglDAOSer;
	}

	
	/**
	 * 营业收入
	 * */
	//查询营业收入 明细
	public List<ShiGongDan> queryShiGongDanList(ShiGongDan sgd , Page page , String gddjrqb , String gddjrqe) throws Exception{
		Object[] objs = new Object[2];
		if(null!=sgd&&!"0".equals(sgd.getWxzt())){
			objs[0] = sgd.getWxzt();
		}
		if(null!=sgd&&!"0".equals(sgd.getWxlx())){
			objs[1] = sgd.getWxlx();
		}
		return cwtzglDAOSer.queryShiGongDanList(objs, page ,  gddjrqb ,  gddjrqe);
	}
	
	//统计-- 查询营业收入 应收实收
	public Cwtzgl queryYYSR(ShiGongDan sgd , String gddjrqb , String gddjrqe) throws Exception{
		Cwtzgl tongji = new Cwtzgl();
		Cwtzgl ybsr = cwtzglDAOSer.queryYBSR(sgd , gddjrqb , gddjrqe);
		Cwtzgl kpsr = cwtzglDAOSer.queryKPSR(sgd , gddjrqb , gddjrqe);
		Cwtzgl xysr = cwtzglDAOSer.queryXYSR(sgd , gddjrqb , gddjrqe);
		
		tongji.setYbzfy(ybsr.getYbzfy());
		tongji.setYbsjzfy(ybsr.getYbsjzfy());
		tongji.setKpzfy(kpsr.getKpzfy());
		tongji.setKpsjzfy(kpsr.getKpsjzfy());
		tongji.setXyzfy(xysr.getXyzfy());
		tongji.setXysjzfy(xysr.getXysjzfy());
		
		return tongji;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 其他收入
	 * */
	//其他收入
	public List<Cwtzgl> queryCwtzglListQTSR(Cwtzgl cwtzgl, Page page , String bfsdate , String efsdate) throws Exception {
		Object[] objs = new Object[1];
		if (null != cwtzgl && !"".equals(cwtzgl)) {  
			objs[0] = cwtzgl.getKmname().trim();
		}
		return cwtzglDAOSer.queryCwtzglListQTSR(objs, page , bfsdate , efsdate);
	}
	
	//查询其他收入 统计
	public Cwtzgl  queryQTSR(Cwtzgl cwtzgl , String bfsdate , String efsdate) throws Exception{
//		Object[] objs = new Object[1];
//		if (null != cwtzgl && !"".equals(cwtzgl)) {  
//			objs[0] = cwtzgl.getKmname().trim();
//		}
		Cwtzgl qtsr =  cwtzglDAOSer.queryQTSR(cwtzgl , bfsdate , efsdate);
		Cwtzgl tongji = new Cwtzgl();
		tongji.setQtsr(qtsr.getQtsr());
		 return tongji;
	}
	
	//进入 新增修改其他收入 页面
	public Cwtzgl queryCwtzglQTSRByID(String cwid) throws Exception{
		Cwtzgl cwtzgl;
		if(null!=cwid&&!"".equals(cwid)){ /**修改 */
			cwtzgl = cwtzglDAOSer.queryCwtzglByID(cwid);
		}else{ /**新建 */
			Calendar cal = Calendar.getInstance();// 取当前日期。
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			 cwtzgl = new Cwtzgl();
			 cwtzgl.setFsdate(sdf.format(cal.getTime()));
			 cwtzgl.setSztype("0"); //收支类型 0收入 1 支出 
		}
		return cwtzgl;
	}
	
	//执行新增修改 其他收入 
	public void modifyCwtzglQTSR(Cwtzgl cwtzgl) throws Exception{
		if(null!=cwtzgl.getCwid()&&!"".equals(cwtzgl.getCwid())){
			cwtzglDAOSer.modifyCwtzglFroUpdate(cwtzgl);
		}else{
			cwtzglDAOSer.modifyCwtzglForSave(cwtzgl);
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 营业支出
	 * */
	//获取供货商列表
	public List<Ghsgl> queryGhsglList() throws Exception{
		return cwtzglDAOSer.queryGhsglList();
	}
	
	//查询营业(物料)支出
	public List<Rkjl> queryRkjlList(Rkjl rkjl, Page page , String rkrqb , String rkrqe) throws Exception{
		Object[] objs = new Object[2];
		if(null!=rkjl&&0!=rkjl.getGhs().getGhsid()){
			objs[0] = rkjl.getGhs().getGhsid();
		}
		if(null!=rkjl&&0!=rkjl.getSfzf()){
			objs[1] = rkjl.getSfzf();
		}
		return cwtzglDAOSer.queryRkjlList(objs, page, rkrqb, rkrqe);
	}
	
	
	//统计 -- 查询营业支出(物料) 已付款 未付款
	public Cwtzgl queryYYZC(Rkjl rkjl , String rkrqb , String rkrqe){
		Cwtzgl tongji = new Cwtzgl();
		Cwtzgl yyzcyf = cwtzglDAOSer.queryYYZCYF(rkjl, rkrqb, rkrqe); //应付
		Cwtzgl yyzcsf = cwtzglDAOSer.queryYYZCSF(rkjl, rkrqb, rkrqe); //实付
		Cwtzgl zcth = cwtzglDAOSer.queryZcth(rkjl, rkrqb, rkrqe);//退货款
				
		tongji.setYyzcyf(yyzcyf.getYyzcyf());
		tongji.setYyzcsf(yyzcsf.getYyzcsf());
		tongji.setZcth(zcth.getZcth());
		
		return tongji;
	}
	
	//设置 营业支出(物料)已支付 未支付  1未付货款  2已付货款
		public void modifyRkjlforZHIFU(String sfzfStr , String rkidStr)throws Exception{
			if(null!=sfzfStr&&!"".equals(sfzfStr)&&null!=rkidStr&&!"".equals(rkidStr)){
				int sfzf = Integer.parseInt(sfzfStr);
				int rkid = Integer.parseInt(rkidStr);
				cwtzglDAOSer.modifyRkjlforZHIFU(sfzf , rkid);
			 }
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * 其他支出
		 * */
 
		//其他支出 明细
		public List<Cwtzgl> queryCwtzglListQTZC(Cwtzgl cwtzgl, Page page , String bfsdate , String efsdate) throws Exception {
			Object[] objs = new Object[1];
			if (null != cwtzgl && !"".equals(cwtzgl)) {  
				objs[0] = cwtzgl.getKmname().trim();
			}
			return cwtzglDAOSer.queryCwtzglListQTZC(objs, page , bfsdate , efsdate);
		}
		
		//查询其他支出 统计
		public Cwtzgl  queryQTZC(Cwtzgl cwtzgl , String bfsdate , String efsdate) throws Exception{
//			Object[] objs = new Object[1];
//			if (null != cwtzgl && !"".equals(cwtzgl)) {  
//				objs[0] = cwtzgl.getKmname().trim();
//			}
			Cwtzgl qtzc =  cwtzglDAOSer.queryQTZC(cwtzgl , bfsdate , efsdate);
			Cwtzgl tongji = new Cwtzgl();
			tongji.setQtzc(qtzc.getQtzc());
			 return tongji;
		}
		
		//进入 新增修改其他收入 页面
		public Cwtzgl queryCwtzglQTZCByID(String cwid) throws Exception{
			Cwtzgl cwtzgl;
			if(null!=cwid&&!"".equals(cwid)){ /**修改 */
				cwtzgl = cwtzglDAOSer.queryCwtzglByID(cwid);
			}else{ /**新建 */
				Calendar cal = Calendar.getInstance();// 取当前日期。
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
				 cwtzgl = new Cwtzgl();
				 cwtzgl.setFsdate(sdf.format(cal.getTime()));
				 cwtzgl.setSztype("1"); //收支类型 0收入 1 支出 
			}
			return cwtzgl;
		}
		
		//执行新增修改 其他收入 
		public void modifyCwtzglQTZC(Cwtzgl cwtzgl) throws Exception{
			if(null!=cwtzgl.getCwid()&&!"".equals(cwtzgl.getCwid())){
				cwtzglDAOSer.modifyCwtzglFroUpdate(cwtzgl);
			}else{
				cwtzglDAOSer.modifyCwtzglForSave(cwtzgl);
			}
		}

}
