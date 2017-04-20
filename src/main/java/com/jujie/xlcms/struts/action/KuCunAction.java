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
	// ��ѯͨ������б�
	public String showKuCunTYList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "1";
		kuCunList = kuCunService.queryKuCunTYList(kuCun, page , kclx);
		return "listty";
	}
	
	public String showKuCunTYListReturn() throws Exception {//��������ת��������
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "1";
		kuCun =null;
		kuCunList = kuCunService.queryKuCunTYList(kuCun, page , kclx);
		return "listty";
	}
	
	// ����ͨ����� ����
	public String showKuCunTYForModifyAsSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		ghsglList=kuCunService.queryGhsglList(); //��ѯ�������б�
		return "addty";
	}

	// ����ͨ�����
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
	// ��ѯ���Ḩ���б�
	public String showKuCunYFList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "2";
		kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
		return "listyf";
	}
	
	public String showKuCunYFListReturn() throws Exception {//��������ת��������
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "2";
		kuCun =null;
		kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
		return "listyf";
	}
	
	// �������Ḩ��
	public String showKuCunYFForModifyAsSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		ghsglList=kuCunService.queryGhsglList(); //��ѯ�������б�
		return "addyf";
	}
	
	
	// �������Ḩ��
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
	// ��ѯר������б�
	public String showKuCunZYList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "3";
		kuCunList = kuCunService.queryKuCunZYList(kuCun, page ,kclx);
		return "listzy";
	}
	
	public String queryKuCunZYListReturn() throws Exception {//��������ת��������
		if (page == null) {
			page = new Page(1);
		}
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kclx = "3";
		kuCun = null;
		kuCunList = kuCunService.queryKuCunZYList(kuCun, page, kclx);
		return "listzy";
	}
	
	// ����ר�����
	public String showKuCunZYForModifyAsSave() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		ghsglList=kuCunService.queryGhsglList(); //��ѯ�������б�
		return "addzy";
	}
	
	
	// ����ר�����
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
//			kuCun = kuCunService.queryKuCunByID(kcid); //�ĳɲ�����¼��Ϣ 
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

		//�����¼(���Ḩ�ϳ���)
	public String showCkglList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		if (page == null) {
			page = new Page(1);
		}
		String tag = request.getParameter("tag");
		ckglList = kuCunService.queryCkglList(ckgl, page , tag , null); //���Ḩ��
		return "listck";
		}
		
	
		public String showCkglForModifyAsSave() throws Exception {
			return "addck";
		}
		
		//(���Ḩ�ϳ���)
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
	
	//�������ϵǼ�
		public String showKuCunTQList() throws Exception {
			if (page == null) {
				page = new Page(1);
			}
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String kclx = "4";
			kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
			return "listtq";
		}
		
		public String showKuCunTQListReturn() throws Exception {//��������ת��������
			if (page == null) {
				page = new Page(1);
			}
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String kclx = "4";
			kuCun =null;
			kuCunList = kuCunService.queryKuCunYFList(kuCun, page, kclx);
			return "listtq";
		}
		
		// ������������
		public String showKuCunTQForModifyAsSave() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			ghsglList=kuCunService.queryGhsglList(); //��ѯ�������б�
			return "addtq";
		}
		
		
		// ��������
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
	// �鿴��¼---��ѯ�������˻���¼
	public String showJiluList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kcid = request.getParameter("kcid");
		String tag =  request.getParameter("tag");
		kuCun = kuCunService.queryKuCunByID(kcid); //�����Ϣ
		tongJi = kuCunService.queryTongJi(kcid , tag);
		return "jilu";
	}
	
	
	// �������ϸ (���� �˻� �޸����� �����޸ĺ�Ҫ���¿������)
	public String showRkjlList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kcid = request.getParameter("kcid");
		kuCun = kuCunService.queryKuCunByID(kcid); //�����Ϣ
		rkjlList = kuCunService.queryRkjlList(kcid);   
		return "jilurk";
	}
	
	
	// �������ϸ  
	public String showCkjlList() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String kcid = request.getParameter("kcid");
		String tag =  request.getParameter("tag");
		kuCun = kuCunService.queryKuCunByID(kcid); //�����Ϣ
		ckglList = kuCunService.queryCkglList(null, null, tag, kcid);
		return "jiluck";
	}
	
	
	
	//�����޸ļ�¼
	public String showRkjlForModifyAsUpdate() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		String rkid = request.getParameter("rkid");
		rkjl = kuCunService.queryRkjlByID(rkid);   
		ghsglList=kuCunService.queryGhsglList(); //��ѯ�������б�
		return "updaterk";
	}
	
	//�޸ļ�¼
	public String modifyRkjlForModifyAsUpdate() throws Exception {
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		kuCunService.modifyRkjlForUpdate(rkjl);
		return this.showRkjlList();
	}
	
	
/******************************************************************************************************************************************************/			
	//���˻���ϸ  
		public String showThjlList() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String kcid = request.getParameter("kcid");
			kuCun = kuCunService.queryKuCunByID(kcid); //�����Ϣ
			thglList =  kuCunService.queryThglList(kcid);
			return "jiluth";
		}
	
	//�����˻���Ϣ����ҳ�� 
		public String showThglForModifyAsUpdate() throws Exception {
			KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
			String rkid = request.getParameter("rkid");
			
			rkjl = kuCunService.queryRkjlByID(rkid);
			kuCun = kuCunService.queryKuCunByID(rkjl.getKuCun().getKcid().toString()); //�ҵ������еĵ�ǰ�������
			rkjl.getKuCun().setDqsl(kuCun.getDqsl());
			return"tuihuo";
	}
		
		
	// �ύ�˻���¼
	public String modifyThglForUpdate() throws Exception {
		String thsl = request.getParameter("thsl");
		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		kuCunService.modifyThglForUpdate(rkjl , thsl);
		return this.showRkjlList();
	}
		


		
		
/******************************************************************************************************************************************************/	
		
	
		

}
