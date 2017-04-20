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
	
	
	//��ʼ������ʩ����
	public ShiGongDan queryBaojiaDanByID(String gdid) throws Exception {
		return baoJiaDAOSer.queryBaojiaDanByID(gdid);
	}
	
	//��ѯʩ������Ӧ�ı���,����,���ϵ�
	public List<BaoJia> queryBaoJiaList(String gdid) throws Exception {
		return baoJiaDAOSer.queryBaoJiaList( gdid );
	}

	
	//��ѯ���Ϲ�����Ӧ�����ϵ�
	//
	public List<BaoJia> queryBeiliaoList(String gdid) throws Exception {
		return baoJiaDAOSer.queryBeiliaoList( gdid );
	}
	
	//��ѯ���Ϲ�����Ӧ�����ϵ�
		public List<BaoJia> queryLingliaoList(String gdid) throws Exception {
			return baoJiaDAOSer.queryLingliaoList( gdid );
		}
		
		//��ѯ�������ϵ�  
		public List<BaoJia> queryTuiliaoList(String gdid) throws Exception{
			return baoJiaDAOSer.queryTuiliaoList(gdid);
		}
		
		
		
		
		
		
		
		
	//��ѯ���뱨��ʩ����
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
	
	//��ѯ���뱨��ʩ����
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
	
	//��ѯ���뱸��/����ʩ����
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
	
	
	//��ѯ����ʩ����
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
	
	//��ѯʩ��������
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
	
	
		
	//�ύ����
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
	public void modifyBeiliaoAndBaojia(BaoJia baoJia) throws Exception { 
		Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())) {
			baoJia.setBjzt("2");//2�ѱ���(���Ա���)(�����޸ı���״̬)
			baoJiaDAOSer.modifyBaojiaForUpdate(baoJia);
		} else {
			baoJia.setBjrq((sdf.format(cal.getTime())));//���󱨼�����
			baoJia.setBjzt("1");//1���뱨��(û��ID����==����)
			baoJiaDAOSer.modifyBaoliaoForSave(baoJia);
		}
	}
	
	
	
	//�ύ��������
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
	public void modifyBeiLiaoForUpdate(BaoJia baoJia) throws Exception {
		Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())) {
			if("1".equals(baoJia.getSfyh())){//�Ƿ�Ҫ��
				if("2".equals(baoJia.getBjzt())){
					baoJia.setBjzt("3");//3������(�����޸ı���״̬)
					baoJia.setFhrq((sdf.format(cal.getTime())));//���󷢻�����
					baoJiaDAOSer.modifyBeiLiaoForUpdate(baoJia);
				}
			}else{
				baoJia.setBjzt("2");//2û��Ҫ���ı�������״̬Ϊ�ѱ���
				baoJiaDAOSer.modifyBeiLiaoForUpdate(baoJia);
			}
			
		} 
	}
	

	//�ύ�������
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
	public void modifyBeiLiaoDoneForUpdate(BaoJia baoJia) throws Exception {
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())&&null!=baoJia.getRkjl().getRkid()&&0!=baoJia.getRkjl().getRkid()) {
				baoJia.setBjzt("4");//4���ϵ���(�����޸ı���״̬)
			baoJiaDAOSer.modifyBeiLiaoDoneForUpdate(baoJia);
		} 
	}
	
	
	//�ύ���ϳ���
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
	public void modifyLingliaoForUpdate(BaoJia baoJia) throws Exception {
		Calendar cal = Calendar.getInstance();// ȡ��ǰ���ڡ�
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		if (null != baoJia.getBjid()&& !"".equals(baoJia.getBjid())) {
			baoJia.setLlrq((sdf.format(cal.getTime())));
			baoJia.setBjzt("5");//5���ϳ��� 
			
			Ckgl ckgl = new Ckgl();
			ckgl.getRkjl().setRkid(baoJia.getRkjl().getRkid());
			ckgl.setCphm(baoJia.getSgd().getCphm());
			ckgl.setCkrq(baoJia.getLlrq());
			ckgl.setCksl(baoJia.getShuliang());
			ckgl.setWlmc(baoJia.getWlmc());
			ckgl.setWllx(baoJia.getRkjl().getKuCun().getWllx());
			ckgl.setKclx(baoJia.getRkjl().getKuCun().getKclx());
			
			int ckid = 0;
			ckid = baoJiaDAOSer.modifyCkglForSave(ckgl);//����������Ϣ
			if(!"".equals(ckid)&&ckid>0){
				baoJia.getCkgl().setCkid(ckid);
			}
			
			baoJiaDAOSer.modifyLingliaoForUpdate(baoJia);//�޸����ϳ���ʱ�� ����������¼ID
			baoJiaDAOSer.modifyShuliangForUpdateSubtract(baoJia);//�޸Ŀ������
			
			
		}
	}
	
	//�޸ı��۵���������
	public BaoJia queryWlmcByID(String bjid) throws Exception {
		return baoJiaDAOSer.queryWlmcByID(bjid);
	}
	public void modifyWlmcForUpdate(BaoJia baoJia) throws Exception {
		 baoJiaDAOSer.modifyWlmcForUpdate(baoJia);
	}
	
	//����ʱ����ɾ������(�������Ϻ��ٴα��۵�ʱ��Ҳ����ɾ��ĳ��) ɾ����һ��Ҫ���ܷ�������
	public void modifyBaoJiaForDelete(String bjid , String gdid)throws Exception{
		
		BaoJia baojia = baoJiaDAOSer.queryBaojiaByID(bjid);//�鱨�����ϵĵ���,����,��ʱ��
		ShiGongDan sgd = baoJiaDAOSer.queryBaojiaDanByID(gdid);//�鵱ǰʩ�������ܷ���
	
		String shuliangStr = baojia.getShuliang();
		String danjiaStr = baojia.getDanjia();
		String gsfStr = baojia.getGsf();
		String zfyStr = sgd.getZfy();
		
		Integer jiage=0;
		Integer zfy = 0;
		
		//���ɾ������һ���������е���(���й�ʱ�ѵ�)��Ҫ ����������ܷ��� , û�еĻ�ֱ��ɾ��
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
	
	
	
	//�ύ����(Ҫɾ������,���Ҹ���������ȥ������,��Ҫɾ�������¼)
	public void modifyTuiLiaoForSave(String gdid , String bjid , String shuliang , String kcid , String ckid)throws Exception{
		this.modifyBaoJiaForDelete(bjid, gdid);// �޸��ܷ��� ɾ������
		if(null!=shuliang&&!"".equals(shuliang)&&null!=kcid&&!"".equals(kcid)){
			baoJiaDAOSer.modifyShuliangForUpdateAdd(shuliang, kcid); //�޸Ŀ��
		}
		if(null!=ckid&&!"0".equals(ckid)){
			baoJiaDAOSer.modifyCkglForDelete(ckid);//ɾ�������¼
		}
	}
	
	
	
	//�޸�ʩ��������״̬
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���   5���ϳ���(ʩ�����������ǲ������ڷ���)
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


