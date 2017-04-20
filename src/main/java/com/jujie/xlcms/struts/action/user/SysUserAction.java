package com.jujie.xlcms.struts.action.user;

import java.util.List;

import com.jujie.xlcms.model.service.user.SysUserRoleResourceService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.user.SysRole;
import com.jujie.xlcms.struts.bean.user.SysUser;

public class SysUserAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private SysUser user;
	private List<SysUser> userList;
	private List<SysRole> roleList;
	private Page page;
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

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public List<SysUser> getUserList() {
		return userList;
	}

	public void setUserList(List<SysUser> userList) {
		this.userList = userList;
	}
	
	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

/*******************************************************************************************************/
	//查看所有系统用户
	public String showSysUserList() throws Exception{
		if(page==null){
			page = new Page(1);
		}
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		userList = urrService.querySysUserList(page);
		return "userlist";
	}
	
/*******************************************************************************************************/	
	//转到新建或修改用户
	public String showSysUserForModify() throws Exception {
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		String userIDStr = request.getParameter("userID");
		user = urrService.querySysUserByUserID(userIDStr);
		return "usermodify";
	}
	
	//新建或修改用户
	public String modifySysUser() throws Exception {
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		urrService.modifySysUser(user);
		return this.showSysUserList();
	}
	
	
	/*******************************************************************************************************/	
	/*******************************************************************************************************/	
	/*******************************************************************************************************/	
	/*******************************************************************************************************/	
	/*******************************************************************************************************/	
	/*******************************************************************************************************/	
	
	
/*******************************************************************************************************/	
	//转到可选系统角色页面
	public String showSysRoleList() throws Exception{
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		String userIDStr = request.getParameter("userID");
		user = urrService.querySysUserByUserID(userIDStr);
		roleList = urrService.querySysRoleList(null);
		return "usermodifyrole";
	}

	//编辑用户的角色 把原先的删除再把提交的新增
	public String modifySysUserRole()throws Exception{
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		String roleIDs[] = request.getParameterValues("roleID");	
		urrService.modifySysUserRole(user ,roleIDs);
		return this.showSysUserList();
	}

	 


		 
 
		 
		 


}
