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

	/*******��������*****************************************************************************************************************************/
	// ��ѯʩ�����б�
	public String showShiGongDanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "list";
	}
	
	// ��ѯʩ�����б�(���ز�������)
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
	
	
	//��ת����ʩ����ҳ��
	public String showShiGongDanForModifyAsSave() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			shiGongDan = shiGongDanService.getShiGongDanForModifyAsSave();
		return "add";
	}
	//��������
	public String modifyShiGongDanForSave() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDan(shiGongDan);
		}
		return this.showShiGongDanListRetuen();
	}
	
	/**********��ʱ����**************************************************************************************************************************/
	// ��ѯ��ʱʩ�����б�
	public String showShiGongDanTempList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanTempList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "templist";
	}
		
	// ��ѯ��ʱʩ�����б�(���ز�������)
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
				
	
	//��ת����/�޸���ʱʩ����ҳ��
	public String showShiGongDanTempForModify() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			String gdid = request.getParameter("gdid");
			shiGongDan = shiGongDanService.getShiGongDanTempForModify(gdid);   
		return "tempmodify";
		}
	
	//�����޸���ʱ����
	public String modifyShiGongDanTemp() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDanTemp(shiGongDan);
		}
		return this.showShiGongDanTempListReturn(); 
	}
		
	//��ת��ʱ��������������
	public String showShiGongDanTempTijiaoForModifyAsUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			String gdid = request.getParameter("gdid");
			shiGongDan = shiGongDanService.queryShiGongDanByID(gdid); 
		return "temptijiao";
	}
		
	//�ύ��ʱ��������������
	public String modifyShiGongDanTempTijiaoForUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDanTempForUpdate(shiGongDan);
		}
		return this.showShiGongDanListRetuen();
	}
		
		
	/*********���˹���***************************************************************************************************************************/
	// ��ѯ������ʩ�����б�
	public String showShiGongDanJiesuanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		 
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanJiesuanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "jiesuanlist";
	}
	
	//�������ҳ��(�޸�)
	public String showShiGongDanJiesuanForModifyAsUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			//�����޸�ҳ��
		String id = request.getParameter("gdid");
		shiGongDan = shiGongDanService.queryShiGongDanByID(id);
		baoJiaList = shiGongDanService.queryBaoJiaList(id);
		return "jiesuanupdate";
	}
	//�޸Ĳ���(����)
	public String modifyShiGongDanJiesuanForUpdate() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		if (null != shiGongDan) {
			shiGongDanService.modifyShiGongDan(shiGongDan);
		}
		return this.showShiGongDanJiesuanList();
	}
	
	
	/*********�鿴*******************************************************************************************************/
	//�鿴ʩ�������Ӧ���ϵ�
	public String showShiGongDanByID() throws Exception {
		ShiGongDanService shiGongDanService = (ShiGongDanService) this.getService("shiGongDanService");
		String id = request.getParameter("gdid");
		shiGongDan = shiGongDanService.queryShiGongDanByID(id);
		baoJiaList = shiGongDanService.queryBaoJiaList(id);
		ryList = shiGongDanService.queryRYList();
		return "show";
	}
	
	/*********�ϵ�*******************************************************************************************************/
//	//�������뱸��ҳ��
//	public String showBeiLiaoDan() throws Exception {
//		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
//		String gdid = request.getParameter("gdid");
//		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
//		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
//		return "beiliaoq";
//	}
	
	//���뱸��
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
//	public String modifyBeiLiao() throws Exception {
//		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
//		String gdid = request.getParameter("gdid");
//		String zfy = request.getParameter("zfy");
//		if(null!=baoJiaList){
//			for (BaoJia baoJia : baoJiaList) {
//				if (null != baoJia) {
//					if(null!=gdid&&!"".equals(gdid)){
//						baoJiaService.modifyBeiLiaoForUpdate(baoJia); //���뱸��
//					}
//				}
//			}
//			baoJiaService.modifySGDZfyForUpdate(zfy, gdid);//���¼�����Ҫ���������ܷ���
//			baoJiaService.modifySGDWlztForUpdate("3" , gdid);  
//		}
//		return this.showShiGongDanListRetuen();
//	}
//	
	/*********���۹��� �鿴�����Ϲ���*******************************************************************************************************/	
	public String showBeiliaoShiGongDanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		 
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryBeiliaoShiGongDanList(shiGongDan, page);
		jdList = shiGongDanService.queryJDList();
		return "beiliaolist"; 
	}
	
	//�������뱸��ҳ��
	public String showBeiLiaoShiGongDan() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		shiGongDan = baoJiaService.queryBaojiaDanByID(gdid);
		baoJiaList = baoJiaService.queryBaoJiaList(gdid);
		return "beiliaoqq";
	}
	
	//���뱸��
	//1���뱨�� 2�ѱ���(���Ա���) 3������  4���ϵ���  5���ϳ���
	public String modifyBeiLiaoShiGongDan() throws Exception {
		BaoJiaService baoJiaService = (BaoJiaService) this .getService("baoJiaService");
		String gdid = request.getParameter("gdid");
		String zfy = request.getParameter("zfy");
		if(null!=baoJiaList){
			for (BaoJia baoJia : baoJiaList) {
				if (null != baoJia) {
					if(null!=gdid&&!"".equals(gdid)){
						baoJiaService.modifyBeiLiaoForUpdate(baoJia); //���뱸��
					}
				}
			}
			baoJiaService.modifySGDZfyForUpdate(zfy, gdid);//���¼�����Ҫ���������ܷ���
			baoJiaService.modifySGDWlztForUpdate("3" , gdid);  
		}
		return this.showBeiliaoShiGongDanList();
	}
	
	/*********ʩ������Ϣ �߼������ѯ*******************************************************************************************************/	
	public String showShiGongDanInfoList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryShiGongDanInfoList(shiGongDan, page);
		jdList = shiGongDanService.queryAllJDList();
		return "infolist";
	}
	
	
	//��ת�޸�ʩ������Ϣҳ��
		public String showShiGongDanInfoForModify() throws Exception {
			ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
				String gdid = request.getParameter("gdid");
				shiGongDan = shiGongDanService.queryShiGongDanInfoForModify(gdid);   
				jdList = shiGongDanService.queryAllJDList();
			return "infomodify";
			}
	
		// �޸Ĺ�����Ϣ
		public String modifyShiGongDanInfo() throws Exception {
			ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
			if (null != shiGongDan) {
				shiGongDanService.modifyShiGongDanInfo(shiGongDan);
			}
			return this.showShiGongDanInfoList(); 
		}
	
	
	 
}
