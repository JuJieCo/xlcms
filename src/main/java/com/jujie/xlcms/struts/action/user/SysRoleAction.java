package com.jujie.xlcms.struts.action.user;

import java.util.List;

import com.jujie.xlcms.model.service.user.SysUserRoleResourceService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.user.SysResource;
import com.jujie.xlcms.struts.bean.user.SysRole;

public class SysRoleAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysRole role ;
	private List<SysRole> roleList;
	private List<SysResource> resourceList;
	private Page page;
	private String s_token;
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public List<SysRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	public List<SysResource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<SysResource> resourceList) {
		this.resourceList = resourceList;
	}
	
	
	
/*******************************************************************************************************/	
	//查询所有角色(除了管理员)
	public String showSysRoleList() throws Exception{
			if(page==null){
				page = new Page(1);
			}
			SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
			roleList = urrService.querySysRoleList(page);
		return "rolelist";
	}

/*******************************************************************************************************/	
	//转到新建或修改角色
	public String showSysRoleForModify() throws Exception {
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		String roleIDStr = request.getParameter("roleID");
		role = urrService.querySysRoleByRoleID(roleIDStr);
		return "rolemodify";
	}
	
	//新建或修改角色
	public String modifySysRole() throws Exception{
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		urrService.modifySysRole(role);
		return this.showSysRoleList();
	}

/*******************************************************************************************************/	
	//转到可选系统资源页面
	public String showSysResourceList() throws Exception{
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		String roleIDStr = request.getParameter("roleID");
		role = urrService.querySysRoleByRoleID(roleIDStr);
		resourceList = urrService.querySysResourceList();
		return "rolemodifyresource";
	}
	

	//编辑角色的资源 把原先的删除再把提交的新增
	public String modifySysRoleResource()throws Exception{
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		String[] resourceIDs = request.getParameterValues("resourceID");
		urrService.modifySysRoleResource(role , resourceIDs);
		return this.showSysRoleList();
	}
	
	
 
	
	
//	public String deleteRole() throws Exception{
//		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//		try{
//			urrService.deleteRole(role.getRoleID());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return showSysRoleList();
//	}

}
