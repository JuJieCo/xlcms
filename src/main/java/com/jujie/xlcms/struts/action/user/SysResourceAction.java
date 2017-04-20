package com.jujie.xlcms.struts.action.user;

import com.jujie.xlcms.model.utils.BaseActionSupper;

public class SysResourceAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private SysResource resource ;
//	private List<SysResource> resourceList;
//	public SysResource getResource() {
//		return resource;
//	}
//	public void setResource(SysResource resource) {
//		this.resource = resource;
//	}
//	public List<SysResource> getResourceList() {
//		return resourceList;
//	}
//	public void setResourceList(List<SysResource> resourceList) {
//		this.resourceList = resourceList;
//	}
	
	
//	public String queryAllResource(){
//		SysUserRoleResourceService srrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//		try{
//			resourceList = srrService.queryAllResource();
//			resourceList = srrService.standardizedResourceList(resourceList);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return "resourceList";
//	}
	
//	public String saveResource(){
//		SysUserRoleResourceService srrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//		try{
//			srrService.saveResource(resource);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return queryAllResource();
//	}
	
//	public String editResource(){
//		SysUserRoleResourceService srrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//		try{
//			srrService.editResource(resource);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return queryAllResource();
//	}
	
//	public String showResource(){
//		SysUserRoleResourceService srrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//		try{
//			if(resource!=null&&resource.getResourceID()!=null){
//				resource = srrService.queryOneResource(resource.getResourceID());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		this.getCxt().put("type", DataUtil.toString(request.getParameter("type")));
//		return "resourceaddmod";
//	}
	
//	public String deleteResource(){
//		SysUserRoleResourceService srrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//		try{
//			srrService.deleteResource(resource.getResourceID());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return queryAllResource();
//	}
}
