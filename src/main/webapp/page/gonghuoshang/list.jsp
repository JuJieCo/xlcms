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
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>供货商管理<span class="divider">/</span>查询供货商信息</li></ul>
				<div class="title_right">
					<strong>查询供货商信息</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/ghsglAction!showGhsglList" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">名称：</td>
							<td width="10%" ><input type="text" name="ghsgl.name"  value="${ghsgl.name}"  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">状态：</td>
							<td width="10%" >
								<select name="ghsgl.status"  id="dept"  class="span1-1">
									<option value="0" ${ghsgl.status==0?"selected":"" }>--请选择--</option>
									<option value="1" ${ghsgl.status==1?"selected":"" }>正常</option>
									<option value="2" ${ghsgl.status==2?"selected":"" }>停用</option>
								</select>
							</td>
						</tr>
					</table>


					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/ghsglAction!showGhsglForModify'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>联系电话1</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>联系电话2</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>状态</strong></td>
							<td width="15%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="ghsglList" var="list">
						<tr>
							<td align="center">&nbsp;${list.name }</td>
							<td align="center">&nbsp;${list.lxdh1 }</td>
						  	<td align="center">&nbsp;${list.lxdh2 }</td>
						 	<td align="center">&nbsp;
						 		<c:if test="${list.status eq 1 }">正常</c:if>
						 		<c:if test="${list.status eq 2 }">停用</c:if>
						 	</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/ghsglAction!showGhsglByID?ghsid=${list.ghsid}">查看</a>&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/ghsglAction!showGhsglForModify?ghsid=${list.ghsid}">修改</a>&nbsp;&nbsp;
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
				elem : '#Calendar1',
				//istime : 'true',
				//format : 'YYYY-MM-DD hh-mm-ss',
				format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar2',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar3',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar4',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar5',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar6',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
		}();
	</script>





</body>
</html>