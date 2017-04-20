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
	//��¼ƥ���û��������� ��ѯ�û��Ľ�ɫ����Դ
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
	//TODO �������ķ���user���Ѿ�ȥ��ResourceList  ����ֱ���������� �������������ȡһ��ResourceList?? �������ò��Ӧ����ȡ�����˵�Ȼ��ŵ� sysResource ��� ResourceList ���Կ�
	
	
	//��ѯϵͳ�û�����Դ
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
	//��ѯ�����û�listҳ��
	public List<SysUser> querySysUserList(Page page) throws Exception{
		return userDAOSer.querySysUserList(page);
	}

/*******************************************************************************************************/
	//����userID����һ��ϵͳ�û���ϵͳ�û�ӵ�еĽ�ɫ
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
	//�������޸��û�
	public void modifySysUser(SysUser user) throws Exception {
		if(null!=user.getUserID()&&!"".equals(user.getUserID())){
			userDAOSer.editUser(user);
		}else{
			userDAOSer.saveUser(user);
		}
	}
	
/*******************************************************************************************************/
	//���û��ڽ�ɫ
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
	//��ѯ��Ա�����Զ���ȫ
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
	//��ѯ���н�ɫlistҳ��
	public List<SysRole> querySysRoleList(Page page) throws Exception{
		return roleDAOSer.querySysRoleList(page);
	}
	
/*******************************************************************************************************/
	//����roleID����һ��ϵͳ��ɫ�������ɫӵ�е�Ȩ��
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
	//�������޸Ľ�ɫ
	public void modifySysRole(SysRole role)throws Exception{
		if(null!=role.getRoleID()&&!"".equals(role.getRoleID())){
			roleDAOSer.editRole(role);
		}else{
			roleDAOSer.saveRole(role);
		}
	}
	
/*******************************************************************************************************/
	//����ɫ����Դ
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
	//��ѯ������Դ
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
