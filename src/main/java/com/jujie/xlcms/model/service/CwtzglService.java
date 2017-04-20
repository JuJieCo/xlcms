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
	 * Ӫҵ����
	 * */
	//��ѯӪҵ���� ��ϸ
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
	
	//ͳ��-- ��ѯӪҵ���� Ӧ��ʵ��
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
	 * ��������
	 * */
	//��������
	public List<Cwtzgl> queryCwtzglListQTSR(Cwtzgl cwtzgl, Page page , String bfsdate , String efsdate) throws Exception {
		Object[] objs = new Object[1];
		if (null != cwtzgl && !"".equals(cwtzgl)) {  
			objs[0] = cwtzgl.getKmname().trim();
		}
		return cwtzglDAOSer.queryCwtzglListQTSR(objs, page , bfsdate , efsdate);
	}
	
	//��ѯ�������� ͳ��
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
	
	//���� �����޸��������� ҳ��
	public Cwtzgl queryCwtzglQTSRByID(String cwid) throws Exception{
		Cwtzgl cwtzgl;
		if(null!=cwid&&!"".equals(cwid)){ /**�޸� */
			cwtzgl = cwtzglDAOSer.queryCwtzglByID(cwid);
		}else{ /**�½� */
			Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			 cwtzgl = new Cwtzgl();
			 cwtzgl.setFsdate(sdf.format(cal.getTime()));
			 cwtzgl.setSztype("0"); //��֧���� 0���� 1 ֧�� 
		}
		return cwtzgl;
	}
	
	//ִ�������޸� �������� 
	public void modifyCwtzglQTSR(Cwtzgl cwtzgl) throws Exception{
		if(null!=cwtzgl.getCwid()&&!"".equals(cwtzgl.getCwid())){
			cwtzglDAOSer.modifyCwtzglFroUpdate(cwtzgl);
		}else{
			cwtzglDAOSer.modifyCwtzglForSave(cwtzgl);
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Ӫҵ֧��
	 * */
	//��ȡ�������б�
	public List<Ghsgl> queryGhsglList() throws Exception{
		return cwtzglDAOSer.queryGhsglList();
	}
	
	//��ѯӪҵ(����)֧��
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
	
	
	//ͳ�� -- ��ѯӪҵ֧��(����) �Ѹ��� δ����
	public Cwtzgl queryYYZC(Rkjl rkjl , String rkrqb , String rkrqe){
		Cwtzgl tongji = new Cwtzgl();
		Cwtzgl yyzcyf = cwtzglDAOSer.queryYYZCYF(rkjl, rkrqb, rkrqe); //Ӧ��
		Cwtzgl yyzcsf = cwtzglDAOSer.queryYYZCSF(rkjl, rkrqb, rkrqe); //ʵ��
		Cwtzgl zcth = cwtzglDAOSer.queryZcth(rkjl, rkrqb, rkrqe);//�˻���
				
		tongji.setYyzcyf(yyzcyf.getYyzcyf());
		tongji.setYyzcsf(yyzcsf.getYyzcsf());
		tongji.setZcth(zcth.getZcth());
		
		return tongji;
	}
	
	//���� Ӫҵ֧��(����)��֧�� δ֧��  1δ������  2�Ѹ�����
		public void modifyRkjlforZHIFU(String sfzfStr , String rkidStr)throws Exception{
			if(null!=sfzfStr&&!"".equals(sfzfStr)&&null!=rkidStr&&!"".equals(rkidStr)){
				int sfzf = Integer.parseInt(sfzfStr);
				int rkid = Integer.parseInt(rkidStr);
				cwtzglDAOSer.modifyRkjlforZHIFU(sfzf , rkid);
			 }
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * ����֧��
		 * */
 
		//����֧�� ��ϸ
		public List<Cwtzgl> queryCwtzglListQTZC(Cwtzgl cwtzgl, Page page , String bfsdate , String efsdate) throws Exception {
			Object[] objs = new Object[1];
			if (null != cwtzgl && !"".equals(cwtzgl)) {  
				objs[0] = cwtzgl.getKmname().trim();
			}
			return cwtzglDAOSer.queryCwtzglListQTZC(objs, page , bfsdate , efsdate);
		}
		
		//��ѯ����֧�� ͳ��
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
		
		//���� �����޸��������� ҳ��
		public Cwtzgl queryCwtzglQTZCByID(String cwid) throws Exception{
			Cwtzgl cwtzgl;
			if(null!=cwid&&!"".equals(cwid)){ /**�޸� */
				cwtzgl = cwtzglDAOSer.queryCwtzglByID(cwid);
			}else{ /**�½� */
				Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
				 cwtzgl = new Cwtzgl();
				 cwtzgl.setFsdate(sdf.format(cal.getTime()));
				 cwtzgl.setSztype("1"); //��֧���� 0���� 1 ֧�� 
			}
			return cwtzgl;
		}
		
		//ִ�������޸� �������� 
		public void modifyCwtzglQTZC(Cwtzgl cwtzgl) throws Exception{
			if(null!=cwtzgl.getCwid()&&!"".equals(cwtzgl.getCwid())){
				cwtzglDAOSer.modifyCwtzglFroUpdate(cwtzgl);
			}else{
				cwtzglDAOSer.modifyCwtzglForSave(cwtzgl);
			}
		}

}
