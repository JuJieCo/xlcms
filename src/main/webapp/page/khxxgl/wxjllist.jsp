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



<script type="text/javascript">

	function selectPage(currentPage){
		var form = document.forms.form1;
		form.action = form.action+"?page.currentPage="+currentPage;
		//alert(form.action);
		form.submit();
	}
	
</script>

<script type="text/javascript">
 
function validateForm(formname){
	var Calendar1 = $("#Calendar1").val();
	var Calendar2 = $("#Calendar2").val();
	var Calendar3 = $("#Calendar3").val();
	var Calendar4 = $("#Calendar4").val();
;
	 
	 if($.trim(Calendar1)!=""&&$.trim(Calendar2)==""){
		 alert("工单登记日期最大日期为空");
		 $("#Calendar2").focus();
		 return false;
	}
	 if($.trim(Calendar2)!=""&&$.trim(Calendar1)==""){
		 alert("工单登记日期最小日期为空");
		 $("#Calendar1").focus();
		 return false;
	}
	 if($.trim(Calendar3)!=""&&$.trim(Calendar4)==""){
		 alert("保险到期日期最大日期为空");
		 $("#Calendar4").focus();
		 return false;
	}
	 if($.trim(Calendar4)!=""&&$.trim(Calendar3)==""){
		 alert("保险到期日期最小日期为空");
		 $("#Calendar3").focus();
		 return false;
	}
	 
}

</script>

</head>
 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>客户信息管理<span class="divider">/</span>查询维修记录</li></ul>
				<div class="title_right">
					<strong>查询维修记录</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<s:token name="s_token"></s:token>
					<table class="table table-bordered">
						<tr>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>施工单号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工单登记日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>实际完工日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>客户名称</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>客户电话</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车牌号码</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车辆品牌</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车辆型号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>收费类型</strong></td>
						 	<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>维修类型</strong></td>
						 	<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>维修状态</strong></td>
						 	<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>投保公司</strong></td>
						 	<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>保险到期日期</strong></td>
						</tr>
						         
						<s:iterator value="wxjlList" var="list">
						<tr>
							<td align="center">&nbsp;${list.danhao }</td>
							<td align="center">&nbsp;${list.gddjrq }</td>
							<td align="center">&nbsp;${list.sjwgrq }</td>
							<td align="center">&nbsp;${list.khmc }</td>
							<td align="center">&nbsp;${list.khdh }</td>
							<td align="center">&nbsp;${list.cphm }</td>
							<td align="center">&nbsp;${list.clpp }</td>
							<td align="center">&nbsp;${list.clxh }</td>
							<td align="center">&nbsp;
								<font color="red"  style="font-weight:bold">
								<c:if test="${list.sflx eq 1}">付现/刷卡</c:if>
								<c:if test="${list.sflx eq 2}">会员消费</c:if>	
								<c:if test="${list.sflx eq 3}">保险赔付</c:if>	
								<c:if test="${list.sflx eq 4}">单位挂账</c:if>	
								<c:if test="${list.sflx eq 5}">免收费用</c:if>
								<c:if test="${list.sflx eq 6}">i保养客户</c:if>
								</font>
							</td>
							<td align="center">&nbsp;
								<font color="red"  style="font-weight:bold">
								<c:if test="${list.wxlx eq 1}">保养维修</c:if>
								<c:if test="${list.wxlx eq 2}">钣金喷漆</c:if>
								<c:if test="${list.wxlx eq 3}">机电钣喷</c:if>
								<c:if test="${list.wxlx eq 4}">洗车美容</c:if>
								<c:if test="${list.wxlx eq 5}">商品零售</c:if>
								</font>
							</td>
							<td align="center">&nbsp;
								<font color="red"  style="font-weight:bold">
								<c:if test="${list.wxzt eq 1}">报价/备料</c:if>
								<c:if test="${list.wxzt eq 2}">维修施工</c:if>
								<c:if test="${list.wxzt eq 3}">等待结账</c:if>
								<c:if test="${list.wxzt eq 4}">结账离店</c:if>
								<c:if test="${list.wxzt eq 5}">检查未修/无费用</c:if>
								<c:if test="${list.wxzt eq 6}">挂账离店</c:if>
								<c:if test="${list.wxzt eq 7}">临时工单</c:if>
								</font>
							</td>
							 <td align="center">&nbsp;
							 		<c:if test="${list.tbgs eq 1}">人保保险</c:if>
									<c:if test="${list.tbgs eq 2}">平安保险</c:if>
									<c:if test="${list.tbgs eq 3}">永安保险</c:if>
									<c:if test="${list.tbgs eq 4}">阳光保险</c:if>
									<c:if test="${list.tbgs eq 5}">太平洋保险</c:if>
									<c:if test="${list.tbgs eq 6}">大地保险</c:if>
									<c:if test="${list.tbgs eq 7}">中华联合保险</c:if>
									<c:if test="${list.tbgs eq 8}">国寿财保险</c:if>
									<c:if test="${list.tbgs eq 9}">天安保险</c:if>
									<c:if test="${list.tbgs eq 10}">安邦保险</c:if>
									<c:if test="${list.tbgs eq 11}">太平保险</c:if>
									<c:if test="${list.tbgs eq 12}">华泰保险</c:if>
									<c:if test="${list.tbgs eq 13}">出口信用保险</c:if>
							 </td>
							 <td align="center">&nbsp;${list.bxdqrq }</td>
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
		}();
	</script>





</body>
</html>