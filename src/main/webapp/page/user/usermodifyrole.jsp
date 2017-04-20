<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>君益达管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>


  
</head>
 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>系统管理<span class="divider">/</span>系统用户管理</li></ul>
				<div class="title_right">
					<strong>授予系统用户角色</strong>
				</div>
				 <form name="form" method="post" action="${pageContext.request.contextPath}/userAction!modifySysUserRole" >
				<div style="width: 55%; margin: auto">
				<s:token name="s_token"></s:token>
				
				 	<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1" width="12%"><strong>姓名：</strong></td>
							<td>&nbsp; <strong>${user.rygl.name}</strong>
								<input type="hidden" name="user.userID"  value="${user.userID}"></input>
							</td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1" width="12%"><strong>选择</strong></td>
							<td align="left" nowrap="nowrap" bgcolor="#f1f1f1"><strong>角色名称</strong></td>
						</tr>
					 
						<s:iterator value="roleList" var="list">
						<tr>
							<td align="center">
							
							
							<s:set value="false" name="checkflag"></s:set>
							<s:iterator value="user.roleList" var="rList">
	            					<s:if test="#list.roleID==#rList.roleID">
	            						<s:set value="true" name="checkflag"></s:set>
	            					</s:if>
	            			</s:iterator>
	            			<s:if test="#checkflag==true">
								<input type="checkbox"  name="roleID"  value="${list.roleID}" checked="checked">
							</s:if>
							<s:else>
								<input type="checkbox"  name="roleID"  value="${list.roleID}" >
							</s:else>
								
								
							</td>
							
							<td >&nbsp;${list.roleName }</td>
						</tr>
						</s:iterator>
					</table>
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center">
							<input type="submit" value="提交"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" />
							<input type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>	
							</td>
						</tr>
					</table> 
				</div>
			</form>
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer">
		版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp; 
	</div>
</body>
</html>