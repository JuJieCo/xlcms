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
	private List<Rkjl> rkjlList; // 库存
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

	//报料,补料,修改物料名称用 (查的是库存中的专用和通用物料,只要名称)
	public String showKuCunWlmcListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunWlmcListAuto(q);
		return "success";
	}
	
	//备料(查的是库存不为0 的专用和通用物料)
	public String showKuCunListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunListAuto(q);
		return "success";
	}
	
	//通用库存用
	public String showKuCunTYListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunTYListAuto(q);
		return "success";
	}
	
	//油辅库存用
	public String showKuCunYFListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunYFListAuto(q);
		return "success";
	}
	
	//专用库存用
	public String showKuCunZYListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryKuCunZYListAuto(q);
		return "success";
	}
	
 
	
	//出库管理用(查的是库存不为0的 油漆辅料)
	public String showCkglListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		KuCunService kuCunService = (KuCunService) this.getService("kuCunService");
		rkjlList = kuCunService.queryCkglListAuto(q);
		return "success";
	}
	
	
	//车辆信息用
	public String showCheLiangListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		ShiGongDanService shiGongDanService = (ShiGongDanService) this .getService("shiGongDanService");
		shiGongDanList = shiGongDanService.queryCheLiangListAuto(q);
		return "success";
	}
	
	
	//人员名称信息用
	public String showRyglNameListAuto() throws Exception {
		String q = request.getParameter("q");// q 是 JQueryAutoComplete 自带的参数
		q = new String(q.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("================" + q);

		SysUserRoleResourceService urrService = (SysUserRoleResourceService) this .getService("sysUserRoleResourceService");
		ryglList = urrService.queryRyglNameListAuto(q);
		return "success";
	}

}
