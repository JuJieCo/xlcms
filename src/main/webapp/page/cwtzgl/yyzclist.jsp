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
 
	

	function yifu(sfzf,rkid){
		var form = document.forms.form1;
		form.action="${pageContext.request.contextPath}/cwtzglAction!modifyRkjlforZHIFU?sfzf="+sfzf+"&rkid="+rkid;
		//alert(form.action);
		form.submit();
	}
	
	
	
</script>


</head>
 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>财务台账管理<span class="divider">/</span>经营支出台账管理</li></ul>
				<div class="title_right">
					<strong>查询经营支出台账信息</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/cwtzglAction!showCwtzglListJYZC" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">入库日期：</td>
							<td>
								<input type="text"  name="rkrqb"  value="${rkrqb}"  class="laydate-icon span2"  id="Calendar1"  />&nbsp; 至 
								<input type="text"  name="rkrqe"  value="${rkrqe}"  class="laydate-icon span2"  id="Calendar2"   />&nbsp; 止 
							</td>
							<td width="15%" align="right" bgcolor="#f1f1f1">供货商：</td>
							<td>
								<select name="rkjl.ghs.ghsid"  id="ghsid"  class="span1">
									<option value="0">-请选择-</option>
									<s:iterator value="ghsList" var="list">
										<option value="${list.ghsid}" ${list.ghsid==rkjl.ghs.ghsid?"selected":""}>${list.name}</option>
									</s:iterator>
								</select>
							</td>
							<td width="15%" align="right" bgcolor="#f1f1f1">是否结算：</td>
							<td>
								<select name="rkjl.sfzf"   class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${rkjl.sfzf==1?"selected":"" }>未付货款</option>
							 		<option value="2" ${rkjl.sfzf==2?"selected":"" }>已付货款</option>
								</select>
							</td>
						</tr>
						</table>
					
					<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">退款金额：</td>
							<td>${tongji.zcth}</td>	
						 </tr>
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">应付金额：</td>
							<td>${tongji.yyzcyf}</td>	
						 </tr>
						 <tr>
						 	<td width="15%" align="right" bgcolor="#f1f1f1">实付金额：</td>
							<td>${tongji.yyzcsf}</td>		
						 </tr>
					</table>
					
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info" style="width: 80px;" /></td>
							<td class="text-center"><input type="button" value="退货单"  onclick="location.href='${pageContext.request.contextPath}/cwtzglAction!showCwtzglListJYTK'"  class="btn btn-info"  style="width: 80px;" /></td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"  width="11%"><strong>入库日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>供货商</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>进货单价</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>进货数量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>退货单价</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>退货数量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>应付金额</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>是否结算</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1" width="12%"><strong>操作</strong></td>
						</tr>
						<s:iterator value="rkjlList" var="list">
						<tr>
							<td align="center">&nbsp;${list.rkrq}</td>
							<td align="center">&nbsp;${list.kuCun.wlmc}</td>
							<td align="center">&nbsp;${list.ghs.name}</td>
							<td align="center">&nbsp;<font color="#4b0091" style="font-weight:bold">${list.danjia}</font></td>
							<td align="center">&nbsp;<font color="#4b0091" style="font-weight:bold">${list.bcsl}</font></td>
							<td align="center">&nbsp;<font color="#00bb00" style="font-weight:bold">${list.thdj}</font></td>
							<td align="center">&nbsp;<font color="#00bb00" style="font-weight:bold">${list.thsl}</font></td>
							 <td align="center">&nbsp;<font color="red" style="font-weight:bold;font-style:italic;">${list.danjia * list.bcsl - list.thdj * list.thsl}</font></td>
							<td align="center">&nbsp;
								<c:if test="${list.sfzf eq 1 }"><font color="red">未付货款</font></c:if>
								<c:if test="${list.sfzf eq 2 }">已付货款</c:if>
							</td>
							<td align="center" >&nbsp;
								<c:if test="${list.sfzf eq 1 }">
									<input type="button" value="已支付"  onclick="yifu(2,${list.rkid});">&nbsp;
								</c:if>
								<c:if test="${list.sfzf eq 2 }">
									<input type="button" value="未支付"  onclick="yifu(1,${list.rkid});" style="color:red">&nbsp;
								</c:if>
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
		}();
	</script>





</body>
</html>