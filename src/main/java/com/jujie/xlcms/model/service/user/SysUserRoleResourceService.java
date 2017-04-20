package com.jujie.xlcms.model.service.user;

import java.util.ArrayList;
import java.util.List;

import com.jujie.xlcms.model.dao.user.SysResourceDAO;
import com.jujie.xlcms.model.dao.user.SysRoleDAO;
import com.jujie.xlcms.model.dao.user.SysUserDAO;
import com.jujie.xlcms.model.utils.DataUtil;
import com.jujie.xlcms.model.utils.Page;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.user.SysResource;
import com.jujie.xlcms.struts.bean.user.SysRole;
import com.jujie.xlcms.struts.bean.user.SysUser;

public class SysUserRoleResourceService {
	private SysResourceDAO resourceDAOSer;
	private SysRoleDAO roleDAOSer;
	private SysUserDAO userDAOSer;
	public void setResourceDAOSer(SysResourceDAO resourceDAOSer) {
		this.resourceDAOSer = resourceDAOSer;
	}

	public void setRoleDAOSer(SysRoleDAO roleDAOSer) {
		this.roleDAOSer = roleDAOSer;
	}

	public void setUserDAOSer(SysUserDAO userDAOSer) {
		this.userDAOSer = userDAOSer;
	}

	
	
/*******************************************************************************************************/
	//登录匹配用户名和密码 查询用户的角色和资源
	public SysUser queryUserByNameAndPwd(String username, String password) throws Exception{
		SysUser user = userDAOSer.getOneUser(username, password);
		if(user!=null){
			List<SysRole> roleList = roleDAOSer.getRolesByUser(user.getUserID());
			for (SysRole role : roleList) {
				role.setResourceList(resourceDAOSer.getResourceByRole(role.getRoleID()));
			}
			user.setRoleList(roleList);
		}
		return user;
	}
	//TODO 这个上面的方法user里已经去了ResourceList  可以直接拿来用了 下面这个方法又取一次ResourceList?? 下面这个貌似应该是取二级菜单然后放到 sysResource 里的 ResourceList 试试看
	
	
	//查询系统用户的资源
	public SysRole getTreeRoleToUser(int userID) throws Exception{
		SysRole role = new SysRole();
		List<SysResource> resourceList = resourceDAOSer.getAllResourceByUser(userID);
		
		//resourceList = this.standardizedResourceList(resourceList);
		role.setResourceList(resourceList);
		return role;
	}
	
	
//	public List<SysResource> standardizedResourceList(List<SysResource> resourceList){
//		int root = 0;
//		for (SysResource resource : resourceList) {
//			if(resource.getResourcePID()==null||resource.getResourcePID()==0){
//				root++;
//				continue;
//			}
//			for(int i = 0 ; i < resourceList.size() ; i++){
//				if(resource.getResourcePID()==resourceList.get(i).getResourceID()){
//					resourceList.get(i).getResourceList().add(resource);
//				}
//			}
//		}
//		while(resourceList.size()!=root){
//			int i = 0 ;
//			for(; i < resourceList.size() ; i++){
//				if(resourceList.get(i).getResourcePID()!=null&&resourceList.get(i).getResourcePID()!=0){
//					resourceList.remove(i);
//				}
//			}
//		}
//		return resourceList;
//	}
//	
	
	
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	
	
	
/*******************************************************************************************************/
	//查询所有用户list页面
	public List<SysUser> querySysUserList(Page page) throws Exception{
		return userDAOSer.querySysUserList(page);
	}

/*******************************************************************************************************/
	//根据userID查找一个系统用户和系统用户拥有的角色
	public SysUser querySysUserByUserID(String userIDStr) throws Exception{
		SysUser sysUser = new SysUser();
		List<SysRole> roleList = new ArrayList<SysRole>();
		if(null!=userIDStr&&!"".equals(userIDStr)){
			int  userID = Integer.valueOf(userIDStr);
			sysUser = userDAOSer.querySysUserByUserID(userID);
			roleList = userDAOSer.querySysUserRoleListByUserID(userID);
		}
		if(null!=roleList&&roleList.size()>=1){
			sysUser.setRoleList(roleList);
		}
		return sysUser;
	}
	
/*******************************************************************************************************/
	//新增或修改用户
	public void modifySysUser(SysUser user) throws Exception {
		if(null!=user.getUserID()&&!"".equals(user.getUserID())){
			userDAOSer.editUser(user);
		}else{
			userDAOSer.saveUser(user);
		}
	}
	
/*******************************************************************************************************/
	//给用户授角色
	public void modifySysUserRole(SysUser user , String[] roleIDs) throws Exception{
		List<SysRole> sysRoleList = new ArrayList<SysRole>();
		for (String roleID : roleIDs) {
			SysRole role = new SysRole();
			role.setRoleID(DataUtil.toInt(roleID));
			sysRoleList.add(role);
		}
		user.setRoleList(sysRoleList);
		userDAOSer.modifySysUserRole(user);
	}
	
/*******************************************************************************************************/
	//查询人员姓名自动补全
	public List<Rygl> queryRyglNameListAuto(String q) throws Exception {
		return userDAOSer.queryRyglNameListAuto(q);
	}
	
	
	
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	
	
	
/*******************************************************************************************************/
	//查询所有角色list页面
	public List<SysRole> querySysRoleList(Page page) throws Exception{
		return roleDAOSer.querySysRoleList(page);
	}
	
/*******************************************************************************************************/
	//根据roleID查找一个系统角色和这个角色拥有的权限
	public SysRole querySysRoleByRoleID(String roleIDStr) throws Exception{
		SysRole role = new SysRole();
		List<SysResource> resourceList = new ArrayList<SysResource>();
		if(null!=roleIDStr&&!"".equals(roleIDStr)){
			int roleID = Integer.valueOf(roleIDStr);
			 role = roleDAOSer.getOneRole(roleID);
			 resourceList = resourceDAOSer.getResourceByRole(roleID);
		} 
		if(null!=resourceList&&resourceList.size()>=1){
			role.setResourceList(resourceList);
		}
		return role;
	}
	
/*******************************************************************************************************/
	//新增或修改角色
	public void modifySysRole(SysRole role)throws Exception{
		if(null!=role.getRoleID()&&!"".equals(role.getRoleID())){
			roleDAOSer.editRole(role);
		}else{
			roleDAOSer.saveRole(role);
		}
	}
	
/*******************************************************************************************************/
	//给角色授资源
	public void modifySysRoleResource(SysRole role , String[] resourceIDs) throws Exception{
		List<SysResource> resourceList = new ArrayList<SysResource>();
		for (String resourceID : resourceIDs) {
			SysResource resource = new SysResource();
			resource.setResourceID(DataUtil.toInt(resourceID));
			resourceList.add(resource);
		}
		role.setResourceList(resourceList);
		roleDAOSer.modifySysRoleResource(role);
	}
	
	
	
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	/*******************************************************************************************************/
	
	
	
	/*******************************************************************************************************/
	//查询所有资源
	public List<SysResource> querySysResourceList() throws Exception{
		return resourceDAOSer.querySysResourceList();
	}
	

	

	
	
	
	
	

	

	

	


	
	
	
	

	

	
	
	
	
	
	
	
	

	

	

	
//	public SysUser getOneUseyByYrid(int ryid) throws Exception{
//	SysUser user = userDAOSer.getOneUserByRyid(ryid);
//	if(user!=null){
//		user.setRoleList(roleDAOSer.getRolesByUser(user.getUserID()));
//	}
//	return user;
//}	
	
//	public void deleteUserByRyid(int ryid) throws Exception{
//	userDAOSer.deleteUserByRyid(ryid);
//}
	
//	public void deleteUser(int userID) throws Exception{
//		userDAOSer.deleteUser(userID);
//	} 
	
//	public boolean editPwd(int userID,String password){
//		return userDAOSer.editPwd(userID, password);
//	}
	
//	public boolean checkUserName(String username) throws Exception {
//		return userDAOSer.checkUserName(username);
//	}
	
//	public void deleteRole(int roleID) throws Exception{
//	roleDAOSer.deleteRole(roleID);
//}
	
	
//	public SysResource queryOneResource(int uuid) throws Exception{
//	return resourceDAOSer.getOneResource(uuid);
//}
	
//	public int saveResource(SysResource resource) throws Exception{
//		return resourceDAOSer.saveResource(resource);
//	}
	
//	public void editResource(SysResource resource) throws Exception{
//		resourceDAOSer.editResource(resource);
//	}
	
//	public void deleteResource(int resourceID) throws Exception{
//		resourceDAOSer.deleteResource(resourceID);
//	}

	
}
