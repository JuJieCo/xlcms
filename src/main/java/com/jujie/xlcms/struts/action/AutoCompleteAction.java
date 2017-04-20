package com.jujie.xlcms.struts.action;

import java.util.List;

import com.jujie.xlcms.model.service.KuCunService;
import com.jujie.xlcms.model.service.ShiGongDanService;
import com.jujie.xlcms.model.service.user.SysUserRoleResourceService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.struts.bean.Rkjl;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.ShiGongDan;

public class AutoCompleteAction extends BaseActionSupper  {
	private static final long serialVersionUID = 1L;
	private String s_token;
	private List<Rkjl> rkjlList; // ���
	private List<ShiGongDan> shiGongDanList;  
	private List<Rygl> ryglList;
	
	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	public List<Rkjl> getRkjlList() {
		return rkjlList;
	}

	public void setRkjlList(List<Rkjl> rkjlList) {
		this.rkjlList = rkjlList;
	}

	public List<ShiGongDan> getShiGongDanList() {
		return shiGongDanList;
	}

	public void setShiGongDanList(List<ShiGongDan> shiGongDanList) {
		this.shiGongDanList = shiGongDanList;
	}

	public List<Rygl> getRyglList() {
		return ryglList;
	}

	public void setRyglList(List<Rygl> ryglList) {
		this.ryglList = ryglList;
	}

	//����,����,�޸����������� (����ǿ���е�ר�ú�ͨ������,ֻҪ����)
	public String showKuCunWlmcListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunWlmcListAuto(q);
		return "success";
	}
	
	//����(����ǿ�治Ϊ0 ��ר�ú�ͨ������)
	public String showKuCunListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunListAuto(q);
		return "success";
	}
	
	//ͨ�ÿ����
	public String showKuCunTYListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunTYListAuto(q);
		return "success";
	}
	
	//�͸������
	public String showKuCunYFListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunYFListAuto(q);
		return "success";
	}
	
	//ר�ÿ����
	public String showKuCunZYListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunZYListAuto(q);
		return "success";
	}
	
 
	
	//���������(����ǿ�治Ϊ0�� ���Ḩ��)
	public String showCkglListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryCkglListAuto(q);
		return "success";
	}
	
	
	//������Ϣ��
	public String showCheLiangListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryCheLiangListAuto(q);
		return "success";
	}
	
	
	//��Ա������Ϣ��
	public String showRyglNameListAuto() throws Exception {
		String q = request.getParameter("q");// q �� JQueryAutoComplete �Դ��Ĳ���
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		SysUserRoleResourceService urrService = (SysUserRoleResourceService) this .getService("sysUserRoleResourceService");
		ryglList = urrService.queryRyglNameListAuto(q);
		return "success";
	}

}
