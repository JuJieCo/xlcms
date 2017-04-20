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
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>财务台账管理<span class="divider">/</span>其他支出台账管理</li></ul>
				<div class="title_right">
					<strong>查询其他支出台账信息</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/cwtzglAction!showCwtzglListQTZC" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">科目名称：</td>
							<td>
							 	<input type="text" name="cwtzgl.kmname"  value="${cwtzgl.kmname}"  class="span1-1" />
							</td>
							<td width="15%" align="right" bgcolor="#f1f1f1">发生日期：</td>
							<td>
							<input type="text" name="bfsdate"  id="bfsdate"  value="${bfsdate}"  class="laydate-icon span2" />&nbsp;至
							<input type="text" name="efsdate"  id="efsdate"  value="${efsdate}"  class="laydate-icon span2" />&nbsp;止
							</td>
						</tr>
						</table>
						
						<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">合计金额：</td>
							<td>${tongji.qtzc}</td>						 		
						 </tr>
					</table>
					
				 
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/cwtzglAction!showCwtzglQTZCForModify'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>发生日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>科目名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>金额</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>摘要</strong></td>
							<td width="15%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="cwtzglList" var="list">
						<tr>
							<td align="center">${list.fsdate}</td>
							<td align="center">${list.kmname}</td>
						   	<td align="center">${list.jine}</td>
						   	<td align="center">${list.zhaiyao}</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/cwtzglAction!showCwtzglQTZC?cwid=${list.cwid}">查看</a>&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/cwtzglAction!showCwtzglQTZCForModify?cwid=${list.cwid}">修改</a>&nbsp;&nbsp;
							</td>
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



	<script>
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#bfsdate',
				//istime : 'true',
				//format : 'YYYY-MM-DD hh-mm-ss',
				format : 'YYYY-MM-DD'
			});
			laydate({
				elem : '#efsdate',
				//istime : 'true',
				//format : 'YYYY-MM-DD hh-mm-ss',
				format : 'YYYY-MM-DD'
			});
		}();
	</script>





</body>
</html>