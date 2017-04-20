package com.jujie.xlcms.model.utils;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class EncodeInterceptor extends AbstractInterceptor {

	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(StrutsStatics.HTTP_REQUEST);

		/**
		 * 此方法体对GET �? POST方法均可
		 */
		if (request.getMethod().compareToIgnoreCase("post") >= 0) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {

			Iterator iter = request.getParameterMap().values().iterator();
			while (iter.hasNext()) {
				String[] parames = (String[]) iter.next();
				for (int i = 0; i < parames.length; i++) {
					try {
						parames[i] = new String(parames[i].getBytes("iso8859-1"), "UTF-8");// 
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if (request.getMethod().compareToIgnoreCase("GET") >= 0) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {

			Iterator iter = request.getParameterMap().values().iterator();
			while (iter.hasNext()) {
				String[] parames = (String[]) iter.next();
				for (int i = 0; i < parames.length; i++) {
					try {
						parames[i] = new String(
								parames[i].getBytes("iso8859-1"), "UTF-8");// 此处GBK与页面编码一�?
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return invocation.invoke();
	}

}
