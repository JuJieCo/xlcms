package com.jujie.xlcms.model.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.jujie.xlcms.model.dao.KuCunDAO;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Ckgl;
import com.jujie.xlcms.struts.bean.Ghsgl;
import com.jujie.xlcms.struts.bean.KuCun;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.Thgl;

public class KuCunService {

	private KuCunDAO kuCunDAOSer;

	public void setKuCunDAOSer(KuCunDAO kuCunDAOSer) {
		this.kuCunDAOSer = kuCunDAOSer;
	}


	
	 

	 //查询通用配件列表
	public List<KuCun> queryKuCunTYList(KuCun kuCun, Page page , String kclx) throws Exception {
		Object[] objs = new Object[3];
		if (null != kuCun && !"".equals(kuCun)) {
			objs[0] = kuCun.getWlmc();
		}
		if (null != kuCun && !"".equals(kuCun)) {
			objs[1] = kuCun.getWllx();
		}
		return kuCunDAOSer.queryKuCunList(objs, page , kclx);
	}
	
	
	 //查询油漆辅料列表
		public List<KuCun> queryKuCunYFList(KuCun kuCun, Page page , String kclx) throws Exception {
			Object[] objs = new Object[2];
			if (null != kuCun && !"".equals(kuCun)) {
				objs[0] = kuCun.getWlmc();
			}
			if (null != kuCun && !"".equals(kuCun)) {
				objs[1] = kuCun.getWllx();
			}
			return kuCunDAOSer.queryKuCunList(objs, page , kclx);
		}
		
		
		 //查询专用配件列表
		public List<KuCun> queryKuCunZYList(KuCun kuCun, Page page , String kclx) throws Exception {
			Object[] objs = new Object[2];
			if (null != kuCun && !"".equals(kuCun)) {
				objs[0] = kuCun.getWlmc();
			}
			if (null != kuCun && !"".equals(kuCun)) {
				objs[1] = kuCun.getWllx();
			}
			return kuCunDAOSer.queryKuCunList(objs, page , kclx);
		}
	
	
/***************************************************************************************************************/		
		
		//新增 库存
		public void modifyKuCunForSave(Rkjl rkjl) throws Exception {
			String dqsl = rkjl.getKuCun().getDqsl();
			String bcsl = rkjl.getBcsl();
			int dqslint = 0;
			int bcslint = 0;
			int conut = 0;
			if(null!=dqsl&&!"".equals(dqsl)){
				 dqslint =   Integer.valueOf(dqsl);
			}
			if(null!=bcsl&&!"".equals(bcsl)){
				bcslint =   Integer.valueOf(bcsl);
			}
			 conut = dqslint+bcslint;
			 rkjl.getKuCun().setDqsl(String.valueOf(conut));
			
			if (null !=  rkjl.getKuCun().getKcid()&& !"".equals( rkjl.getKuCun().getKcid())) {
				kuCunDAOSer.modifyKuCunDqslForUpdate(rkjl);//id不为空修改一条 后 插入记录(增加入库记录的时候修改库存当前数量)
				this.modifyRkjlAsSave(rkjl);
			} else if(null!= rkjl.getKuCun().getWlmc()&&!"".equals(rkjl.getKuCun().getWlmc())){
				int kcid = kuCunDAOSer.modifyKuCunForSave(rkjl);//id为空新增一条 后 插入记录
				rkjl.getKuCun().setKcid(kcid);
				this.modifyRkjlAsSave(rkjl);
			}
		}
		
		
		// TODO 修改库存 改成 修改记录
		
		public void modifyRkjlForUpdate(Rkjl rkjl) throws Exception {
			if(null!=rkjl.getRkid()&&!"".equals(rkjl.getRkid())){
				String rkid = rkjl.getRkid().toString();
				Rkjl  rkjl1 = kuCunDAOSer.queryRkjlByID(rkid);
				if(null!=rkjl.getBcsl()&&!"".equals(rkjl.getBcsl())&&rkjl1.getBcsl().trim()!=rkjl.getBcsl().trim()){
					String scsl = rkjl1.getBcsl().trim();
					if("".equals(scsl)){
						scsl ="0";
					}
					kuCunDAOSer.modifyJiLuShuliangForUpdate(rkjl , scsl);
				}
			}
			kuCunDAOSer.modifyRkjlForUpdate(rkjl);
		}
		
		
		//插入入库记录
		public void modifyRkjlAsSave(Rkjl rkjl) throws Exception {
			Calendar cal = Calendar.getInstance();// 取当前日期。插入入库日期
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			rkjl.setRkrq(sdf.format(cal.getTime()));
			kuCunDAOSer.modifyRkjlForSave(rkjl);
			
		}
		
		
		//初始化库存
		public KuCun queryKuCunByID(String kcid) throws Exception {
			return kuCunDAOSer.queryKuCunByID(kcid);
		}
		
		//查询库存对应的入库记录明细
		public List<Rkjl> queryRkjlList(String kcid) throws Exception {
			return kuCunDAOSer.queryRkjlList( kcid );
		}
		
		//查询库存对应的退货记录明细
		public List<Thgl> queryThglList(String kcid) throws Exception {
			return kuCunDAOSer.queryThglList( kcid );
		}
		
		//查询入库出库退货统计
		  public TongJi queryTongJi(String kcid ,String tag) throws Exception{
			  List<Rkjl> rkjlList = kuCunDAOSer.queryRkjlList(kcid);  //入库记录明细  
			  List<Ckgl> ckglList = kuCunDAOSer.queryCkglList(null, null , tag , kcid); //出库记录明细
			  List<Thgl> thglList =  kuCunDAOSer.queryThglList(kcid);
			  TongJi tongJi = new TongJi();
			  //统计入库次数
			  if(null!=rkjlList&&rkjlList.size()>0){
				  	tongJi.setRkcs(rkjlList.size());
				}else{
					tongJi.setRkcs(0);
				}
//			  //统计入库数量
//			  int rksl = 0 ;
//			  for(Rkjl  rkjl : rkjlList){
//				  if(null!=rkjl.getBcsl()&&!"".equals(rkjl.getBcsl())){
//					  rksl = Integer.valueOf(rkjl.getBcsl());
//				  }
//				  rksl += rksl;
//			  }
//			  tongJi.setRksl(rksl);
			  
			  //统计出库次数
			  if(null!=ckglList&&ckglList.size()>0){
				  tongJi.setCkcs(ckglList.size());
			  }else{
				  tongJi.setCkcs(0);
			  }
//			  //统计出库数量
//			  int cksl = 0 ;
//			  for(Ckgl ckgl : ckglList){
//				  if(null!=ckgl.getCksl()&&!"".equals(ckgl.getCksl())){
//					  cksl = Integer.valueOf(ckgl.getCksl());
//				  }
//				  cksl += cksl;
//			  }
//			  tongJi.setCksl(cksl);
			  
			  //统计退货次数
			  if(null!=thglList&&thglList.size()>0){
				  tongJi.setThcs(thglList.size());
			  }else{
				  tongJi.setThcs(0);
			  }
//			  //统计退货数量
//			  int thsl = 0;
//			  for(Thgl thgl : thglList){
//				  if(null!=thgl.getBcsl()&&!"".equals(thgl.getBcsl())){
//					  thsl = Integer.valueOf(thgl.getBcsl());
//				  }
//				  thsl += thsl;
//			  }
//			  tongJi.setThsl(thsl);
			  return tongJi;
		  }
		
		
		//查询入库记录信息明细(退货用)
		public Rkjl queryRkjlByID(String rkid) throws Exception {
			return kuCunDAOSer.queryRkjlByID(rkid);
		}
			
			
		//查询油漆辅料出库记录
		public List<Ckgl> queryCkglList(Ckgl ckgl , Page page  ,String tag , String kcid) throws Exception {
			Object[] objs = new Object[3];
			if (null != ckgl && !"".equals(ckgl)) {
				objs[0] = ckgl.getCphm();
			}
			if (null != ckgl && !"".equals(ckgl)) {
				objs[1] = ckgl.getWlmc();
			}
			if (null != ckgl && !"".equals(ckgl)) {
				objs[2] = ckgl.getRemark();
			}
			return kuCunDAOSer.queryCkglList(objs , page , tag , kcid);
		}
		
		
		//新增油漆辅料出库记录专用
		public void modifyCkglForSave(Ckgl ckgl) throws Exception {
			Calendar cal = Calendar.getInstance(); 
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			ckgl.setCkrq(sdf.format(cal.getTime()));
			if(null!=ckgl.getWlmc()&&!"".equals(ckgl.getWlmc())){
				kuCunDAOSer.modifyCkglForSave(ckgl); //增加出库记录
				kuCunDAOSer.modifyShuliangForUpdate(ckgl);//修改库存数量
			}
		}
		
		
		
		
		//退货
		public void modifyThglForUpdate(Rkjl rkjl , String thsl) throws Exception {
			kuCunDAOSer.modifyThglForUpdate(rkjl, thsl); //退货修改库存数量  
			//增加一条退货记录
			Calendar cal = Calendar.getInstance(); 
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			Thgl thgl = new Thgl();
			thgl.setRkid(rkjl.getRkid());
			thgl.setThrq(sdf.format(cal.getTime()));
			thgl.setBcsl(thsl);
			thgl.setDanjia(rkjl.getDanjia());
			thgl.setGhs(rkjl.getGhs().getGhsid());
			thgl.setWlzl(rkjl.getWlzl());
			thgl.setRemark(rkjl.getRemark());
			kuCunDAOSer.modifyThglForSave(thgl);
		}
		
		
		
		
		//获取供货商列表
		public List<Ghsgl> queryGhsglList() throws Exception{
			return kuCunDAOSer.queryGhsglList();
		}

		
		
		// 自动补全
		public List<Rkjl> queryKuCunListAuto(String q) throws Exception {
			return kuCunDAOSer.queryKuCunListAuto(q);
		}
		
		public List<Rkjl> queryKuCunWlmcListAuto(String q) throws Exception {
			return kuCunDAOSer.queryKuCunWlmcListAuto(q);
		}
		
		public List<Rkjl> queryKuCunTYListAuto(String q) throws Exception {
			return kuCunDAOSer.queryKuCunTYListAuto(q);
		}
		
		public List<Rkjl> queryKuCunYFListAuto(String q) throws Exception {
			return kuCunDAOSer.queryKuCunYFListAuto(q);
		}
		
		public List<Rkjl> queryKuCunZYListAuto(String q) throws Exception {
			return kuCunDAOSer.queryKuCunZYListAuto(q);
		}
		
	 
		
		public List<Rkjl> queryCkglListAuto(String q) throws Exception {
			return kuCunDAOSer.queryCkglListAuto(q);
		}
		
		
		
		
		
		
		
		
		
		//用于统计的内部类
		 public class TongJi {
		       public int rkcs; //入库次数
		       public int rksl; //入库数量
		       public int ckcs; //出库次数
		       public int cksl;//出库数量
		       public int thcs;//退货次数
		       public int thsl;//退货数量
			public int getRkcs() {
				return rkcs;
			}
			public void setRkcs(int rkcs) {
				this.rkcs = rkcs;
			}
			public int getRksl() {
				return rksl;
			}
			public void setRksl(int rksl) {
				this.rksl = rksl;
			}
			public int getCkcs() {
				return ckcs;
			}
			public void setCkcs(int ckcs) {
				this.ckcs = ckcs;
			}
			public int getCksl() {
				return cksl;
			}
			public void setCksl(int cksl) {
				this.cksl = cksl;
			}
			public int getThcs() {
				return thcs;
			}
			public void setThcs(int thcs) {
				this.thcs = thcs;
			}
			public int getThsl() {
				return thsl;
			}
			public void setThsl(int thsl) {
				this.thsl = thsl;
			}
		  }
		  
		
}
