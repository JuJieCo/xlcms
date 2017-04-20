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

	
	
	
	//��ѯ���Ϲ���
	public String showBaoliaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoliaoSGDList(shiGongDan, page);
		return "baoliaolist";
	}
	//��ѯ���Ϲ���(���ز�������)
	public String showBaoliaoSGDListReturn() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoliaoSGDList(shiGongDan, page);
		return "baoliaolist";
	}
	
	
	//��ѯ���۹���
	public String showBaoJiaSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoJiaSGDList(shiGongDan, page);
		return "baojialist";
	}
	
	
	//��ѯ���۹���(���ز�������)
	public String showBaoJiaSGDListReturn() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBaoJiaSGDList(shiGongDan, page);
		return "baojialist";
	}
	
	
	//��ѯ���Ϲ���
	public String showBeiLiaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBeiLiaoSGDList(shiGongDan, page);
		return "beiliaolist";
	}
	
	
	//��ѯ���Ϲ���(���ز�������)
	public String showBeiLiaoSGDListReturn() throws Exception { //��ת����������
		if (page == null) {
			page = new Page(1);
		}
		shiGongDan = null;
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBeiLiaoSGDList(shiGongDan, page);
		return "beiliaolist";
	}
	
	
	//��ѯ���Ϲ���
	public String showLingLiaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryLingLiaoSGDList(shiGongDan, page);
		return "lingliaolist";
	}
	
	
	//��ѯ���Ϲ���(���ز�������)
		public String showLingLiaoSGDListReturn() throws Exception {
			if (page == null) {
				page = new Page(1);
			}
			shiGongDan = null;
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			sgdList = baoJiaService.queryLingLiaoSGDList(shiGongDan, page);
			return "lingliaolist";
		}
	
		
	//��ѯ���Ϲ���
	public String showBuLiaoSGDList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		sgdList = baoJiaService.queryBuliaoSGDList(shiGongDan, page);
		return "buliaolist";
	}
	
/*****************************************************************************************************************/	
	
	// ��ѯ���������б�(������Ӧ�����뱨�ϵ����ϵ�)
	public String  showBaoliaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		return "baoliao";
	}
	
	
	// ��ѯ���������б�(������Ӧ�����뱨�۵����ϵ�)
	public String showBaoJiaList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return "baojia";
	}
	
	
	// ��ѯ���������б�(������Ӧ�����뱸�ϵ����ϵ�)
	public String showBeiliaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBeiliaoList(gdid);
		return "beiliao";
	}
	
	
	// ��ѯ���������б�(������Ӧ�ĵȴ����ϵ����ϵ�)
	public String showLingLiaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryLingliaoList(gdid);
		return "lingliao";
	}
	
	// ��ѯ���������б�(������Ӧ�����뱨�۵����ϵ�)
	public String showBuLiaoList() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return "buliao";
	}
	
	//  ��ѯ���������б�
	public String showTuiLiaoList() throws Exception{
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryTuiliaoList(gdid);
		return "tuiliao";
	}
	
	
	/*****************************************************************************************************************/	
	
	//�ύ����
	public String modifyBaoliaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
			baoJia.getSgd().setGdid(Integer.valueOf(gdid));
			baoJiaService.modifyBeiliaoAndBaojia(baoJia); //���뱨��
		}
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
				if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
						baoJia.getSgd().setGdid(Integer.valueOf(gdid));
						baoJiaService.modifyBeiliaoAndBaojia(baoJia); //���뱨��
				}
			}
			baoJiaService.modifySGDWlztForUpdate("1" , gdid);  
		}
		 
		return this.showBaoliaoSGDListReturn();  //���Ϻ���������LIST
	}
	
	
	//�ύ����
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
			baoJiaService.modifySGDZfyForUpdate(zfy, gdid);//���б�����Ʒ���ܷ���
		}
		//shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		//baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		request.setAttribute("zfy", zfy);
		return this.showBaoJiaSGDListReturn();
	}
	
	
	//�ύ����
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
	
	
	//���ϳ��� 1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
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
			baoJiaService.modifySGDWxztForUpdate("2", gdid);	//ֻҪ��һ�������޸Ĺ���ά��״̬
		}
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return this.showLingLiaoSGDListReturn();
	}
	
	
	
	//�ύ����
	public String modifyBuliaoForSave() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
			baoJia.getSgd().setGdid(Integer.valueOf(gdid));
			baoJiaService.modifyBeiliaoAndBaojia(baoJia); //�������뱨��
		}
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
				if (null != baoJia&&null!=baoJia.getWlmc()&&!"".equals(baoJia.getWlmc())) {
						baoJia.getSgd().setGdid(Integer.valueOf(gdid));
						baoJiaService.modifyBeiliaoAndBaojia(baoJia); //�������뱨��
				}
			}
			baoJiaService.modifySGDWlztForUpdate("1" , gdid);  
		}
		return this.showBaoJiaSGDListReturn();  //���Ϻ���������LIST
	}
	
	
	// �ύ����
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

	//����ʱ �����޸� ���ϱ��۱�Ϳ������������
		public String showWlmcByID() throws Exception {
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			String gdid = request.getParameter("gdid");
			String bjid = request.getParameter("bjid");
			shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
			baoJia = baoJiaService.queryWlmcByID(bjid);
			return "beiliaomodify";
		}
			
			
			
		//����ʱ�����޸���������
		public String modifyWlmcForUpdate() throws Exception {
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			String gdid = shiGongDan.getGdid().toString(); 
			baoJiaService.modifyWlmcForUpdate(baoJia);
			shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
			baoJiaList = baoJiaService.queryBeiliaoList(gdid);
			return "beiliao";
		}
		
		
		//����ʱ����ɾ������(�������Ϻ��ٴα��۵�ʱ��Ҳ����ɾ��ĳ��)
		public String modifyBaoJiaForDelete()throws Exception{
			BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
			String gdid = request.getParameter("gdid");
			String bjid = request.getParameter("bjid");
			String tag = request.getParameter("tag");
			baoJiaService.modifyBaoJiaForDelete(bjid, gdid);
			request.setAttribute("gdid", gdid);
			if(null!=tag&&"baojia".equals(tag)){  //����ɾ����ת
				return this.showBaoJiaList();
			}else if(null!=tag&&"beiliao".equals(tag)){ //����ɾ����ת
				return this.showBeiliaoList();
			}else if(null!=tag&&"lingliao".equals(tag)){ //����ɾ����ת
				return this.showLingLiaoList();
			}else{
				return "";
			}
		}
			
	
	
	
	
			
			

			
			
	

}
