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
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理 <span class="divider">/</span>调漆用料登记</li></ul>
				<div class="title_right">
					<strong>调漆用料登记</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/kuCunAction!showKuCunTQList" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">物料名称：</td>
							<td width="10%" ><input type="text" name="kuCun.wlmc"  value="${kuCun.wlmc}"  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">物料类型：</td>
							<td width="10%" >
								<select name="kuCun.wllx"  class="span1-1">
									<option value="0" ${kuCun.wllx==0?"selected":"" }>--请选择--</option>
									<option value="7" ${kuCun.wllx==7?"selected":"" }>辅料</option>
									<option value="8" ${kuCun.wllx==8?"selected":"" }>油漆</option>
									<option value="10" ${kuCun.wllx==10?"selected":"" }>其它</option>
								</select>
							</td>
						</tr>
					</table>

					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="新建"  onclick="location.href='${pageContext.request.contextPath}/kuCunAction!showKuCunTQForModifyAsSave'"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" /></td>
						</tr>
					</table>
					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>调漆克数</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>货位</strong></td>
							<td width="15%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						
						<s:iterator value="kuCunList" var="list">
						<tr>
							<td align="center">&nbsp;${list.wlmc }</td>
						 	<td align="center">&nbsp;
								<c:if test="${list.wllx eq 7 }">辅料</c:if>
								<c:if test="${list.wllx eq 8 }">油漆</c:if>
								<c:if test="${list.wllx eq 10 }">其它</c:if>
							</td>
						 	<td align="center">&nbsp;${list.dqsl }</td>
						 	<td align="center">&nbsp;
						 		<c:if test="${list.huowei eq 1 }">通道1</c:if>
						 		<c:if test="${list.huowei eq 2 }">通道2</c:if>
						 		<c:if test="${list.huowei eq 3 }">通道3</c:if>
						 		<c:if test="${list.huowei eq 4 }">通道4</c:if>
						 		<c:if test="${list.huowei eq 5 }">通道5</c:if>
						 		<c:if test="${list.huowei eq 6 }">通道6</c:if>
						 		<c:if test="${list.huowei eq 7 }">通道7</c:if>
						 		<c:if test="${list.huowei eq 8 }">通道8</c:if>
						 	</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/kuCunAction!showJiluList?kcid=${list.kcid}&tag=yfck">查看记录</a>&nbsp;&nbsp;
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