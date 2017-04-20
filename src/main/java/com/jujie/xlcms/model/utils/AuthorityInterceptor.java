package com.jujie.xlcms.model.utils;

import java.util.Map;

import com.jujie.xlcms.struts.action.user.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		ActionContext ctx = actionInvocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		
		Action action = (Action) actionInvocation.getAction(); 
		 //��¼�û�session����
			if(session.get("sessionRygl")!=null&&session.get("sessionSysUser")!=null){
				return actionInvocation.invoke();
			}
		
			//����LoginAction��ʵ�� 
		if (action instanceof LoginAction) {  
			 return actionInvocation.invoke();  
		 } else{
				ctx.put("mesg", "��¼ʱ���Գ�ʱ�������µ�¼��");
			return Action.LOGIN;
		}
 

	} 

}
