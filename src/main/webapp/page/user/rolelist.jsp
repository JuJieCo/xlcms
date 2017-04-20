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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>



<script type="text/javascript">

	function selectPage(currentPage){
		var form = document.forms.form1;
		form.action = form.action+"?page.currentPage="+currentPage;
		//alert(form.action);
		form.submit();
	}
	
</script>
</head>
 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>系统管理<span class="divider">/</span>系统角色管理</li></ul>
				<div class="title_right">
					<strong>查询系统角色信息</strong>
				</div>
				
				<div style="width: 85%; margin: auto">
		 
				<s:token name="s_token"></s:token>

					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-left"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/roleAction!showSysRoleForModify'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
						</tr>
					</table>
					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>角色名称</strong></td>
						 
							<td width="20%"  align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="roleList" var="list">
						<tr>
							<td align="center">&nbsp;${list.roleName }</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/roleAction!showSysRoleForModify?roleID=${list.roleID}" >修改</a>&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/roleAction!showSysResourceList?roleID=${list.roleID}">授予资源</a>&nbsp;&nbsp;
							</td>
						</tr>
						</s:iterator>
					</table>
					 <%@include file="/page/plugin/page.jsp" %>
				 
				</div>

				
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<div id="footer">
		版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp; 
	</div>
</body>
</html>