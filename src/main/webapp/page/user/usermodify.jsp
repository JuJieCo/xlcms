<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/add.js"></script>
	
	
	<script type="text/javascript">
		function validateForm(formname){
			 var username = $("#username").val();
			 var password = $("#password").val();
			 var ryid = $("#ryid").val();
			
			 
			 if($.trim(username)==""){
				 alert("用户名称为空!");
				 $("#username").focus();
				 return false;
			}
			 if($.trim(password)==""){
				 alert("登录密码为空!");
				 $("#password").focus();
				 return false;
			 }
	 
			 if($.trim(ryid)==""){
				 alert("人员姓名不正确!");
				 $("#rymc").focus();
				 return false;
			 }
		}
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<%@include file="/page/plugin/autocomplete_rymc.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>系统管理<span class="divider">/</span>系统用户管理</li></ul>
			<div class="title_right">
				<strong>创建系统用户信息</strong>
			</div>
			 
			<form name="form" method="post" action="${pageContext.request.contextPath}/userAction!modifySysUser"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 45%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="25%" align="right" bgcolor="#f1f1f1">用户名称：</td>
							<td>
								<input type="text" name="user.username"  id="username"  class="span4" value="${user.username}" />
								<input type="hidden" name="user.userID" id="userID"  value="${user.userID}" />
							</td>
						</tr>
						<tr>
						 	<td width="25%" align="right" bgcolor="#f1f1f1">登录密码：</td>
							<td>
								<input type="text" name="user.password"  id="password"  class="span4" value="${user.password}" />
							</td>
						</tr>
						
						<tr>
						 	<td width="25%" align="right" bgcolor="#f1f1f1">人员姓名：</td>
							<td>
								<input type="hidden" name="user.rygl.ryid"  id="ryid"  class="span4" value="${user.rygl.ryid}" />
								<c:if test="${user.rygl.ryid eq null}">
								<input type="text" name="user.rygl.name"  id="rymc"  class="span4" value="${user.rygl.name}" />
								</c:if>
								<c:if test="${user.rygl.ryid ne null}">
									&nbsp;${user.rygl.name}
								</c:if>
							</td>
						</tr>
						
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
	<div id="footer">版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp;</div>
 
</body>
</html>