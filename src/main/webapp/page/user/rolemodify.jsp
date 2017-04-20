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
			 var rolename = $("#rolename").val();
			 
			 if($.trim(rolename)==""){
				 alert("角色名称为空!");
				 $("#rolename").focus();
				 return false;
			}
			
			 
		}
 
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>系统管理<span class="divider">/</span>系统角色管理</li></ul>
			<div class="title_right">
				<strong>创建系统角色信息</strong>
			</div>
			<form name="form" method="post"   action="${pageContext.request.contextPath}/roleAction!modifySysRole"  onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 45%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="25%" align="right"  bgcolor="#f1f1f1">角色名称：</td>
							<td>
								<input type="text" name="role.roleName"  id="rolename"  class="span4" value="${role.roleName}" />
								<input type="hidden" name="role.roleID" id="roleid"  value="${role.roleID}" />
							</td>
						</tr>
						<tr>
							<td width="25%" align="right"  bgcolor="#f1f1f1">备注：</td>
							<td>
								<textarea rows="4" cols="50"  name="role.remark"  class="span4"  >${role.remark}</textarea>
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