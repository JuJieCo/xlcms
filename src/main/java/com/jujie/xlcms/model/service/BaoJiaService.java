package com.jujie.xlcms.model.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.jujie.xlcms.model.dao.BaoJiaDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.BaoJia;
import com.jujie.xlcms.struts.bean.Ckgl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class BaoJiaService {
	
	private BaoJiaDAO baoJiaDAOSer;

	public void setBaoJiaDAOSer(BaoJiaDAO baoJiaDAOSer) {
		this.baoJiaDAOSer = baoJiaDAOSer;
	}
	
	
	//初始化报料施工单
	public ShiGongDan queryBaojiaDanByID(String gdid) throws Exception {
		return baoJiaDAOSer.queryBaojiaDanByID(gdid);
	}
	
	//查询施工单对应的报料,报价,补料单
	public List<BaoJia> queryBaoJiaList(String gdid) throws Exception {
		return baoJiaDAOSer.queryBaoJiaList( gdid );
	}

	
	//查询备料工单对应的物料单
	//
	public List<BaoJia> queryBeiliaoList(String gdid) throws Exception {
		return baoJiaDAOSer.queryBeiliaoList( gdid );
	}
	
	//查询领料工单对应的物料单
		public List<BaoJia> queryLingliaoList(String gdid) throws Exception {
			return baoJiaDAOSer.queryLingliaoList( gdid );
		}
		
		//查询退料物料单  
		public List<BaoJia> queryTuiliaoList(String gdid) throws Exception{
			return baoJiaDAOSer.queryTuiliaoList(gdid);
		}
		
		
		
		
		
		
		
		
	//查询申请报料施工单
	public List<ShiGongDan> queryBaoliaoSGDList(ShiGongDan shiGongDan , Page page) throws Exception{
		
		Object[] objs = new Object[2];
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[0] = shiGongDan.getDanhao();
		}
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[1] = shiGongDan.getCphm();
		}
		return baoJiaDAOSer.queryBaoliaoSGDList(objs, page);
	}
	
	//查询申请报价施工单
	public List<ShiGongDan> queryBaoJiaSGDList(ShiGongDan shiGongDan , Page page) throws Exception{
		
		Object[] objs = new Object[2];
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[0] = shiGongDan.getDanhao();
		}
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[1] = shiGongDan.getCphm();
		}
		return baoJiaDAOSer.queryBaoJiaSGDList(objs, page);
	}
	
	//查询申请备料/领料施工单
	public List<ShiGongDan> queryBeiLiaoSGDList(ShiGongDan shiGongDan , Page page) throws Exception{
		
		Object[] objs = new Object[2];
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[0] = shiGongDan.getDanhao();
		}
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[1] = shiGongDan.getCphm();
		}
		return baoJiaDAOSer.queryBeiLiaoSGDList(objs, page);
	}
	
	
	//查询领料施工单
	public List<ShiGongDan> queryLingLiaoSGDList(ShiGongDan shiGongDan , Page page) throws Exception{
		
		Object[] objs = new Object[2];
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[0] = shiGongDan.getDanhao();
		}
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[1] = shiGongDan.getCphm();
		}
		return baoJiaDAOSer.queryLingLiaoSGDList(objs, page);
	}
	
	//查询施工单补料
	public List<ShiGongDan> queryBuliaoSGDList(ShiGongDan shiGongDan , Page page) throws Exception{
		
		Object[] objs = new Object[2];
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[0] = shiGongDan.getDanhao();
		}
		if (null != shiGongDan && !"".equals(shiGongDan)) { 
			objs[1] = shiGongDan.getCphm();
		}
		return baoJiaDAOSer.queryBuliaoSGDList(objs, page);
	}
	
	
		
	//提交报价
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	public void modifyBeiliaoAndBaojia(BaoJia baoJia) throws Exception { 
		Calendar cal = Calendar.getInstance();// 取当前日期。
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())) {
			baoJia.setBjzt("2");//2已报价(可以备料)(存在修改报价状态)
			baoJiaDAOSer.modifyBaojiaForUpdate(baoJia);
		} else {
			baoJia.setBjrq((sdf.format(cal.getTime())));//请求报价日期
			baoJia.setBjzt("1");//1申请报价(没有ID新增==报料)
			baoJiaDAOSer.modifyBaoliaoForSave(baoJia);
		}
	}
	
	
	
	//提交备料申请
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	public void modifyBeiLiaoForUpdate(BaoJia baoJia) throws Exception {
		Calendar cal = Calendar.getInstance();// 取当前日期。
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())) {
			if("1".equals(baoJia.getSfyh())){//是否要货
				if("2".equals(baoJia.getBjzt())){
					baoJia.setBjzt("3");//3请求备料(存在修改报价状态)
					baoJia.setFhrq((sdf.format(cal.getTime())));//请求发货日期
					baoJiaDAOSer.modifyBeiLiaoForUpdate(baoJia);
				}
			}else{
				baoJia.setBjzt("2");//2没有要货的保留报价状态为已报价
				baoJiaDAOSer.modifyBeiLiaoForUpdate(baoJia);
			}
			
		} 
	}
	

	//提交备料完成
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	public void modifyBeiLiaoDoneForUpdate(BaoJia baoJia) throws Exception {
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())&&null!=baoJia.getRkjl().getRkid()&&0!=baoJia.getRkjl().getRkid()) {
				baoJia.setBjzt("4");//4备料到货(存在修改报价状态)
			baoJiaDAOSer.modifyBeiLiaoDoneForUpdate(baoJia);
		} 
	}
	
	
	//提交领料出库
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货  5领料出库
	public void modifyLingliaoForUpdate(BaoJia baoJia) throws Exception {
		Calendar cal = Calendar.getInstance();// 取当前日期。
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())) {
			baoJia.setLlrq((sdf.format(cal.getTime())));
			baoJia.setBjzt("5");//5领料出库 
			
			Ckgl ckgl = new Ckgl();
			ckgl.getRkjl().setRkid(baoJia.getRkjl().getRkid());
			ckgl.setCphm(baoJia.getSgd().getCphm());
			ckgl.setCkrq(baoJia.getLlrq());
			ckgl.setCksl(baoJia.getShuliang());
			ckgl.setWlmc(baoJia.getWlmc());
			ckgl.setWllx(baoJia.getRkjl().getKuCun().getWllx());
			ckgl.setKclx(baoJia.getRkjl().getKuCun().getKclx());
			
			int ckid = 0;
			ckid = baoJiaDAOSer.modifyCkglForSave(ckgl);//新增出库信息
			if(!"".equals(ckid)&&ckid>0){
				baoJia.getCkgl().setCkid(ckid);
			}
			
			baoJiaDAOSer.modifyLingliaoForUpdate(baoJia);//修改领料出库时间 并插入出库记录ID
			baoJiaDAOSer.modifyShuliangForUpdateSubtract(baoJia);//修改库存数量
			
			
		}
	}
	
	//修改报价单物料名称
	public BaoJia queryWlmcByID(String bjid) throws Exception {
		return baoJiaDAOSer.queryWlmcByID(bjid);
	}
	public void modifyWlmcForUpdate(BaoJia baoJia) throws Exception {
		 baoJiaDAOSer.modifyWlmcForUpdate(baoJia);
	}
	
	//报价时可以删除物料(包括补料后再次报价的时候也可以删除某个) 删除了一个要把总费用重置
	public void modifyBaoJiaForDelete(String bjid , String gdid)throws Exception{
		
		BaoJia baojia = baoJiaDAOSer.queryBaojiaByID(bjid);//查报价物料的单价,数量,工时费
		ShiGongDan sgd = baoJiaDAOSer.queryBaojiaDanByID(gdid);//查当前施工单的总费用
	
		String shuliangStr = baojia.getShuliang();
		String danjiaStr = baojia.getDanjia();
		String gsfStr = baojia.getGsf();
		String zfyStr = sgd.getZfy();
		
		Integer jiage=0;
		Integer zfy = 0;
		
		//如果删除的是一个有数量有单价(或有工时费的)就要 计算后重置总费用 , 没有的话直接删除
		if(null!=shuliangStr&&!"".equals(shuliangStr)&&null!=danjiaStr&&!"".equals(danjiaStr)){
			Integer shuliang = 0;
			Integer danjia = 0;
			danjia = Integer.valueOf(danjiaStr);
			shuliang = Integer.valueOf(shuliangStr);
			jiage = danjia * shuliang;
			
			if(null!=gsfStr&&!"".equals(gsfStr)){
				Integer gsf = Integer.valueOf(gsfStr);
				jiage += gsf;
			}
			
			if(null!=zfyStr&&!"".equals(zfyStr)){
				 zfy = Integer.valueOf(zfyStr); 
				 zfy -= jiage;
			}
			baoJiaDAOSer.modifySGDZfyForUpdate(zfy.toString(),gdid);
		}
		baoJiaDAOSer.modifyBaoJiaForDelete(bjid);
	}
	
	
	
	//提交退料(要删除物料,并且给库存加上退去的数量,还要删除出库记录)
	public void modifyTuiLiaoForSave(String gdid , String bjid , String shuliang , String kcid , String ckid)throws Exception{
		this.modifyBaoJiaForDelete(bjid, gdid);// 修改总费用 删除报价
		if(null!=shuliang&&!"".equals(shuliang)&&null!=kcid&&!"".equals(kcid)){
			baoJiaDAOSer.modifyShuliangForUpdateAdd(shuliang, kcid); //修改库存
		}
		if(null!=ckid&&!"0".equals(ckid)){
			baoJiaDAOSer.modifyCkglForDelete(ckid);//删除出库记录
		}
	}
	
	
	
	//修改施工单物料状态
	//1申请报价 2已报价(可以备料) 3请求备料  4备料到货   5领料出库(施工单不体现是不是正在发货)
	public void modifySGDWlztForUpdate(String wlzt , String gdid) throws Exception {
		if(null!=wlzt&&"1".equals(wlzt)){ 
			wlzt="1";
		}
		if(null!=wlzt&&"2".equals(wlzt)){
			wlzt="2"; 
		}
		if(null!=wlzt&&"3".equals(wlzt)){
			wlzt="3"; 
		}
		if(null!=wlzt&&"4".equals(wlzt)){
			wlzt="4"; 
		}
		if(null!=wlzt&&"5".equals(wlzt)){
			wlzt="5"; 
		}
		baoJiaDAOSer.modifySGDWlztForUpdate(wlzt, gdid);
	}
	
	public void modifySGDZfyForUpdate(String zfy , String gdid) throws Exception {
		baoJiaDAOSer.modifySGDZfyForUpdate(zfy, gdid);
	}
	public void modifySGDWxztForUpdate(String wxzt , String gdid) throws Exception {
		baoJiaDAOSer.editSGDWxzt(wxzt, gdid);
	}
}


