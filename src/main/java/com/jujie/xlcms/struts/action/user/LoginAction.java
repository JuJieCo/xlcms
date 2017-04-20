package com.jujie.xlcms.struts.action.user;

import com.jujie.xlcms.model.service.RyglService;
import com.jujie.xlcms.model.service.user.SysUserRoleResourceService;
import com.jujie.xlcms.model.utils.BaseActionSupper;
import com.jujie.xlcms.struts.bean.Rygl;
import com.jujie.xlcms.struts.bean.user.SysUser;

public class LoginAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private SysUser user;
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	
	/*******************************************************************************************************/
	//用户登录
	public String login()  throws Exception{
		RyglService ryglService = (RyglService) this.getService("ryglService");
		SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
		response.setCharacterEncoding("UTF-8");
		try{
//			if(!DataUtil.toString(request.getParameter("code")).equals((String)request.getSession().getAttribute("sessionCode"))){
//				//this.getCxt().put("mesg", "验证码错误！");
//				request.setAttribute("mesg", "验证码错误！");
//				return "login";
//			}
			user = urrService.queryUserByNameAndPwd(user.getUsername(),user.getPassword());
			if(user!=null){
				Rygl rygl = ryglService.queryRyglByID(user.getRygl().getRyid().toString());
				user.setTreeRole(urrService.getTreeRoleToUser(user.getUserID()));
				if(rygl.getRyid()==null){
					this.getCxt().put("mesg", "用户不存在！");
					return "login";
				}else{
					request.getSession().setAttribute("sessionRygl", rygl);
				}
				request.getSession().setAttribute("sessionSysUser", user);
			}else{
				this.getCxt().put("mesg", "登录名或密码有误！");
				return "login";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "login";
		}
		return "index";
	}
	
/*******************************************************************************************************/	
	//用户登出
	public String logout()  throws Exception{
		request.getSession().removeAttribute("sessionLogin");
		request.getSession().removeAttribute("sessionUser");
		return "login";
	}
/*******************************************************************************************************/		
	
	
	//验证码
//	public String getVailteCode(){
//		try {
//			String code = ValidateCodeImageUtils.createImage(response.getOutputStream(), 4);
//			request.getSession().setAttribute("sessionCode", code);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}	
	
	
//	public String editPwd()  throws Exception{
//	String newPwd = request.getParameter("newpwd");
//	SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//	SysUser user = (SysUser)request.getSession().getAttribute("sessionLogin");
//	response.setCharacterEncoding("UTF-8");
//	if(urrService.editPwd(user.getUserID(), newPwd)){
//		try {
//			response.getWriter().write("密码修改成功！");
//			user.setPassword(newPwd);
//			request.getSession().setAttribute("sessionLogin", user);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}else{
//		try {
//			response.getWriter().write("密码修改失败！");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	return null;
//}
	
	
//	public String checkName() throws Exception{
//	String lname = request.getParameter("lname");
//	SysUserRoleResourceService urrService = (SysUserRoleResourceService)this.getService("sysUserRoleResourceService");
//	
//	response.setCharacterEncoding("UTF-8");
//	try {
//		if(urrService.checkUserName(lname)){
//			try {
//				response.getWriter().write(0);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}else{
//			try {
//				response.getWriter().write(1);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return null;
//}

}
