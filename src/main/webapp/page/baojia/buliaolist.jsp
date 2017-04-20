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
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>报价管理 <span class="divider">/</span>查询补料/退料工单</li></ul>
				<div class="title_right">
					<strong>查询补料/退料工单</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/baoJiaAction!showBuLiaoSGDList" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">施工单号：</td>
							<td width="20%" ><input type="text" name="shiGongDan.danhao"  value="${shiGongDan.danhao}"  class="span4" /></td>
							<td width="10%" align="right" bgcolor="#f1f1f1">车牌号码：</td>
							<td width="20%" ><input type="text" name="shiGongDan.cphm"  value="${shiGongDan.cphm}"  class="span4" /></td>
						</tr>
						 
					</table>


					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
						</tr>
					</table>
					
					
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料状态</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工单登记日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>施工单号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车牌号码</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车辆品牌</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车辆型号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车架号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>生产日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>客户类型</strong></td>
							<td width="10%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						
						<s:iterator value="sgdList" var="list">
						<tr>
							<td align="center">&nbsp;
								<font color="red"  style="font-weight:bold">
								<c:if test="${list.wlzt eq 0}">未报料</c:if>
								<c:if test="${list.wlzt eq 1}">等待报价</c:if>
								<c:if test="${list.wlzt eq 2}">已报价</c:if>
								<c:if test="${list.wlzt eq 3}">请求备料</c:if>
								<c:if test="${list.wlzt eq 4}">备料到货</c:if>
								<c:if test="${list.wlzt eq 5}">领料出库</c:if>
								</font>
							</td>
							<td align="center">&nbsp;${list.gddjrq }</td>
							<td align="center">&nbsp;${list.danhao }</td>
							<td align="center">&nbsp;${list.cphm }</td>
							<td align="center">&nbsp;${list.clpp }</td>
							<td align="center">&nbsp;${list.clxh }</td>
							<td align="center">&nbsp;${list.cjh }</td>
							<td align="center">&nbsp;${list.scrq }</td>
							<td align="center">&nbsp;
								<font color="red">
									<c:if test="${list.khlx eq 1}">自主进店</c:if>
									<c:if test="${list.khlx eq 2}">快速理赔</c:if>
									<c:if test="${list.khlx eq 3}">自报保险</c:if>
									<c:if test="${list.khlx eq 4}">协议单位</c:if>
									<c:if test="${list.khlx eq 5}">返工免单</c:if>
									<c:if test="${list.khlx eq 6}">i保养客户</c:if>
								</font>
							</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/baoJiaAction!showBuLiaoList?gdid=${list.gdid }">补料</a>&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/baoJiaAction!showTuiLiaoList?gdid=${list.gdid }">退料</a>&nbsp;&nbsp;
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