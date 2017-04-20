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
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>高级管理<span class="divider">/</span>老板查询</li></ul>
				<div class="title_right">
					<strong>财务查询</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/cwtzglAction!showCwtzglListJYSR" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
				 
					
					<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">查询日期：</td>
							<td>
								<input type="text"  name="gddjrqb"  value="${gddjrqb}"  class="laydate-icon span2"  id="Calendar1"  />&nbsp; 至 
								<input type="text"  name="gddjrqe"  value="${gddjrqe}"  class="laydate-icon span2"  id="Calendar2"   />&nbsp; 止 
							</td>
						</tr>
						 
						</table>
						<table class="table table-bordered">
						<tr>
							<td  colspan="2"   align="center"  ><strong>一般客户：</strong></td>
							<td  colspan="2"   align="center"   ><strong>快赔客户：</strong></td>
							<td  colspan="2"   align="center"  ><strong>协议单位：</strong></td>
						</tr>
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">应收：</td>
							<td width="10%" >${tongji.ybzfy}</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">应收：</td>
							<td width="10%" >${tongji.kpzfy}</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">应收：</td>
							<td width="10%" >${tongji.xyzfy}</td>
						</tr>
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">实收：</td>
							<td width="10%" >${tongji.ybsjzfy}</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">实收：</td>
							<td width="10%" >${tongji.kpsjzfy}</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">实收：</td>
							<td width="10%" >${tongji.xysjzfy}</td>
						</tr>
					</table>
					
						
					<table class="table table-bordered">
						<tr>
							<td width="14%" align="right" bgcolor="#f1f1f1">其他收入：</td>
							<td>${tongji.qtsr}</td>						 		
						 </tr>
					</table>
					
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
						</tr>
					</table>
					
					 
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
		}();
	</script>





</body>
</html>