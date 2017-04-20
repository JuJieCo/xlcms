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
		form.action = form.action+"&page.currentPage="+currentPage;
		//alert(form.action);
		form.submit();
	}
	
</script>
</head>

<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理 <span class="divider">/</span>查询油漆辅料出库记录</li></ul>
				<div class="title_right">
					<strong>查询油漆辅料出库记录</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/kuCunAction!showCkglList?tag=yfck" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">物料名称：</td>
							<td width="10%" ><input type="text" name="ckgl.wlmc"  value="${ckgl.wlmc}"  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">领用人：</td>
							<td width="10%" ><input type="text" name="ckgl.remark"  value="${ckgl.remark}"  class="span1-1" /></td>
						</tr>
					</table>

					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/kuCunAction!showCkglForModifyAsSave'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
							
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>出库数量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>出库日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物流类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>领用人</strong></td>
						</tr>
						<s:iterator value="ckglList" var="list">
						<tr>
							<td align="center">&nbsp;${list.wlmc }</td>
							<td align="center">&nbsp;${list.cksl }</td>
						 	<td align="center">&nbsp;${list.ckrq }</td>
							<td align="center">&nbsp;
								${list.wllx eq 1? "辅料":"油漆" }
							</td>
							<td align="center">&nbsp;${list.remark }</td>
						</tr>
						</s:iterator>
					</table>
					 <%@include file="/page/plugin/page.jsp" %>
					</form>
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