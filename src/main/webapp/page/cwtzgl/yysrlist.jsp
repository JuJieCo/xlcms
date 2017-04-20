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
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>财务台账管理<span class="divider">/</span>经营收入台账管理</li></ul>
				<div class="title_right">
					<strong>查询经营收入台账信息</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/cwtzglAction!showCwtzglListJYSR" name="form1"  method="post" >
				<s:token name="s_token"></s:token>
				
				 
					
					<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">工单登记日期：</td>
							<td>
								<input type="text"  name="gddjrqb"  value="${gddjrqb}"  class="laydate-icon span2"  id="Calendar1"  />&nbsp; 至 
								<input type="text"  name="gddjrqe"  value="${gddjrqe}"  class="laydate-icon span2"  id="Calendar2"   />&nbsp; 止 
							</td>
							<td width="15%" align="right" bgcolor="#f1f1f1">维修状态：</td>
							<td>
								<select name="sgd.wxzt"   class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="2" ${sgd.wxzt==2?"selected":"" }>维修施工</option>
							 		<option value="3" ${sgd.wxzt==3?"selected":"" }>等待结账</option>
							 		<option value="4" ${sgd.wxzt==4?"selected":"" }>结账离店</option>
							 		<option value="5" ${sgd.wxzt==5?"selected":"" }>检查未修/无费用</option>
							 		<option value="6" ${sgd.wxzt==6?"selected":"" }>挂账离店</option>
								</select>
							</td>
							<td width="15%" align="right" bgcolor="#f1f1f1">维修类型：</td>
							<td>
								<select name="sgd.wxlx"   class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${sgd.wxlx==1?"selected":"" }>保养维修</option>
							 		<option value="2" ${sgd.wxlx==2?"selected":"" }>钣金喷漆</option>
							 		<option value="3" ${sgd.wxlx==3?"selected":"" }>机电钣喷</option>
							 		<option value="4" ${sgd.wxlx==4?"selected":"" }>洗车美容</option>
							 		<option value="5" ${sgd.wxlx==5?"selected":"" }>商品零售</option>
								</select>
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
					<table class="margin-bottom-20 table  no-border">
						<tr>
							<td class="text-center"><input type="submit" value="查询" class="btn btn-info " style="width: 80px;" /></td>
						</tr>
					</table>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>施工单号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车牌号码</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>应收金额</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>实收金额</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>客户类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>收费类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>维修类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>维修状态<!-- 4结账离店 5检查未修/无费用 6欠账离店 --></strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工单登记日期</strong></td>
							<td width="10%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						<s:iterator value="sgdList" var="list">
						<tr>
							<td align="center">&nbsp;${list.danhao}</td>
							<td align="center">&nbsp;${list.cphm}</td>
							<td align="center">&nbsp;${list.zfy}</td>
							<td align="center">&nbsp;${list.sjzfy}</td>
							<td align="center">&nbsp;
								<c:if test="${list.khlx eq 1}">自主进店</c:if>
								<c:if test="${list.khlx eq 2}">快速理赔</c:if>
								<c:if test="${list.khlx eq 3}">自报保险</c:if>
								<c:if test="${list.khlx eq 4}">协议单位</c:if>
								<c:if test="${list.khlx eq 5}">返工免单</c:if>
								<c:if test="${list.khlx eq 6}">i保养客户</c:if>
							</td>
							<td align="center">&nbsp;
								<c:if test="${list.sflx eq 1}">付现/刷卡</c:if>
								<c:if test="${list.sflx eq 2}">会员消费</c:if>	
								<c:if test="${list.sflx eq 3}">保险赔付</c:if>	
								<c:if test="${list.sflx eq 4}">单位挂账</c:if>	
								<c:if test="${list.sflx eq 5}">免收费用</c:if>
								<c:if test="${list.sflx eq 6}">i保养客户</c:if>
							</td>
							<td align="center">&nbsp;
								<c:if test="${list.wxlx eq 1}">保养维修</c:if>
								<c:if test="${list.wxlx eq 2}">钣金喷漆</c:if>
								<c:if test="${list.wxlx eq 3}">机电钣喷</c:if>
								<c:if test="${list.wxlx eq 4}">洗车美容</c:if>
								<c:if test="${list.wxlx eq 5}">商品零售</c:if>
							</td>
						   	<td align="center">&nbsp;
						   		<c:if test="${list.wxzt eq 1}">报价/备料</c:if>
								<c:if test="${list.wxzt eq 2}">维修施工</c:if>
								<c:if test="${list.wxzt eq 3}">等待结账</c:if>
								<c:if test="${list.wxzt eq 4}">结账离店</c:if>
								<c:if test="${list.wxzt eq 5}">检查未修/无费用</c:if>
								<c:if test="${list.wxzt eq 6}">挂账离店</c:if>
								<c:if test="${list.wxzt eq 7}">临时工单</c:if>
						   	</td>
						   	<td align="center">&nbsp;
						   		${list.gddjrq}
						   	</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanByID?gdid=${list.gdid}">查看</a>&nbsp;&nbsp;
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