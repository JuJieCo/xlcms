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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>
</head>
 


 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理 <span class="divider">/</span>查询库存记录</li></ul>
				<div class="title_right">
					<strong>查询入库记录明细</strong>
				</div>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">物料名称：</td>
							<td>
								<input type="text" name="shiGongDan.danhao"  id="danhao"  class="span2" value="${kuCun.wlmc}"  readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">物料类型：</td>
							<td>
								<input type="text" name="shiGongDan.cphm"  id="cphm"  class="span1-1" value="${kuCun.wllx}" readonly="readonly"/>
							</td>
							
							<td width="10%" align="right" bgcolor="#f1f1f1">当前数量：</td>
							<td>
								<input type="text" name="shiGongDan.clpp"  id="clpp"  class="span1-1" value="${kuCun.dqsl}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">货位：</td>
							<td>
								<input type="text" name="shiGongDan.clxh" id="clxh"  class="span1-1" value="${kuCun.huowei}"  readonly="readonly"/>
							</td>
						</tr>
						
					</table>
		 
		 
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>入库日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>本次入库数量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>进货单价</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>供货商</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料质量</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						
						<s:iterator value="rkjlList" var="list" status="st">
						<tr>
							<td align="center">&nbsp;${list.rkrq }</td>
							<td align="center">&nbsp;${list.bcsl }</td>  
							<td align="center">&nbsp;${list.danjia }</td>
							<td align="center">&nbsp;${list.ghs.name }</td>
						 	<td align="center">&nbsp;
								<c:if test="${list.wlzl eq 1 }">原车</c:if>
								<c:if test="${list.wlzl eq 2 }">其它</c:if>
							</td>
						 	<td align="center">																 
								<a href="${pageContext.request.contextPath}/kuCunAction!showThglForModifyAsUpdate?rkid=${list.rkid}">退货</a>&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/kuCunAction!showRkjlForModifyAsUpdate?rkid=${list.rkid}">修改</a>&nbsp;&nbsp;
							</td>
						</tr>
						</s:iterator>
					</table>
					
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center">
								<input type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>	
							</td>
						</tr>
					</table>
					
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