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
	var Calendar5 = $("#Calendar5").val();
	var Calendar6 = $("#Calendar6").val();
	var Calendar7 = $("#Calendar7").val();
	var Calendar8 = $("#Calendar8").val();
	 
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
		 alert("预计完工日期最大日期为空");
		 $("#Calendar4").focus();
		 return false;
	}
	 if($.trim(Calendar4)!=""&&$.trim(Calendar3)==""){
		 alert("预计完工日期最小日期为空");
		 $("#Calendar3").focus();
		 return false;
	}
	 
	 if($.trim(Calendar5)!=""&&$.trim(Calendar6)==""){
		 alert("实际完工日期最大日期为空");
		 $("#Calendar6").focus();
		 return false;
	}
	 if($.trim(Calendar6)!=""&&$.trim(Calendar5)==""){
		 alert("实际完工日期最小日期为空");
		 $("#Calendar5").focus();
		 return false;
	}
	 
	 if($.trim(Calendar7)!=""&&$.trim(Calendar8)==""){
		 alert("保险到期日期最大日期为空");
		 $("#Calendar8").focus();
		 return false;
	}
	 if($.trim(Calendar8)!=""&&$.trim(Calendar7)==""){
		 alert("保险到期日期最小日期为空");
		 $("#Calendar7").focus();
		 return false;
	}
	 
}

</script>

</head>
 


<body>
		<%@include file="/page/frame/top.jsp" %>
		<div class="right" id="mainFrame">
			<div class="right_cont">
				<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>施工单管理<span class="divider">/</span>查询待备料施工单</li></ul>
				<div class="title_right">
					<strong>查询待备料施工单</strong>
				</div>
				
				<div style="width: 95%; margin: auto">
				<form action="${pageContext.request.contextPath}/shiGongDanAction!showBeiliaoShiGongDanList" name="form1"  method="post"  onsubmit="return validateForm(this)" >
				<s:token name="s_token"></s:token>
				
					<table class="table table-bordered">
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">施工单号：</td>
							<td width="10%"  colspan="7"><input type="text" name="shiGongDan.danhao"  value="${shiGongDan.danhao}"  class="span3" /></td>
						</tr>
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">车牌号码：</td>
							<td width="10%" ><input type="text" name="shiGongDan.cphm"  value="${shiGongDan.cphm}"  class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">车辆品牌：</td>
							<td width="10%" ><input type="text" name="shiGongDan.clpp"   value="${shiGongDan.clpp}"   class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">车辆型号：</td>
							<td width="10%" ><input type="text" name="shiGongDan.clxh"   value="${shiGongDan.clxh}"   class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">投保公司：</td>
							<td  width="10%" >
								<select name="shiGongDan.tbgs"  id="tbgs"  class="span1-1">
							 		<option value="0">--请选择--</option>
							 			<option value="1" ${shiGongDan.tbgs==1?"selected":"" }>人保保险</option>
										<option value="2" ${shiGongDan.tbgs==2?"selected":"" }>平安保险</option>
										<option value="3" ${shiGongDan.tbgs==3?"selected":"" }>永安保险</option>
										<option value="4" ${shiGongDan.tbgs==4?"selected":"" }>阳光保险</option>
										<option value="5" ${shiGongDan.tbgs==5?"selected":"" }>太平洋保险</option>
										<option value="6" ${shiGongDan.tbgs==6?"selected":"" }>大地保险</option>
										<option value="7" ${shiGongDan.tbgs==7?"selected":"" }>中华联合保险</option>
										<option value="8" ${shiGongDan.tbgs==8?"selected":"" }>国寿财保险</option>
										<option value="9" ${shiGongDan.tbgs==9?"selected":"" }>天安保险</option>
										<option value="10" ${shiGongDan.tbgs==10?"selected":"" }>安邦保险</option>
										<option value="11" ${shiGongDan.tbgs==11?"selected":"" }>太平保险</option>
										<option value="12" ${shiGongDan.tbgs==12?"selected":"" }>华泰保险</option>
										<option value="13" ${shiGongDan.tbgs==13?"selected":"" }>出口信用保险</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">客户名称：</td>
							<td width="10%" ><input type="text" name="shiGongDan.khmc"   value="${shiGongDan.khmc}"   class="span1-1" /></td>
							<td width="7%" align="right" bgcolor="#f1f1f1">客户电话：</td>
							<td width="10%" ><input type="text" name="shiGongDan.khdh"   value="${shiGongDan.khdh}"   class="span1-1" /></td>
					 		<td width="7%" align="right" bgcolor="#f1f1f1">维修顾问：</td>
							<td width="10%" >
								<select name="shiGongDan.wxgw"   class="span1-1">
							 		<option value="0">--请选择--</option>
									<s:iterator value="jdList" var="list">
										<option value="${list.ryid}"  ${shiGongDan.wxgw==list.ryid?"selected":"" }>${list.name}</option>
									</s:iterator>									 
								</select>
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">协议单位名称：</td>
							<td width="10%" >
								<select name="shiGongDan.dwmc"   class="span1-1">
							 		<option value="15">--请选择--</option>
							 		<option value="1" ${shiGongDan.dwmc==1?"selected":"" }>老村长酒业</option>
							 		<option value="2" ${shiGongDan.dwmc==2?"selected":"" }>四十七军部队</option>
							 		<option value="3" ${shiGongDan.dwmc==3?"selected":"" }>火箭军工程大学</option>
							 		<option value="4" ${shiGongDan.dwmc==4?"selected":"" }>洪庆城管</option>
							 		<option value="5" ${shiGongDan.dwmc==5?"selected":"" }>新市社区</option>
							 		<option value="6" ${shiGongDan.dwmc==6?"selected":"" }>向阳公司</option>
							 		<option value="7" ${shiGongDan.dwmc==7?"selected":"" }>志风工贸</option>
							 		<option value="8" ${shiGongDan.dwmc==8?"selected":"" }>天风建筑</option>
							 		<option value="9" ${shiGongDan.dwmc==9?"selected":"" }>诚惠金属</option>
							 		<option value="10" ${shiGongDan.dwmc==10?"selected":"" }>福宝铸造</option>
							 		<option value="11" ${shiGongDan.dwmc==11?"selected":"" }>中谷中实</option>
							 		<option value="12" ${shiGongDan.dwmc==12?"selected":"" }>瑞莱科技</option>
							 		<option value="13" ${shiGongDan.dwmc==13?"selected":"" }>个人协议车辆</option>
							 		<option value="14" ${shiGongDan.dwmc==14?"selected":"" }>秦农银行</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">客户类型：</td>
							<td width="10%" >
								<select name="shiGongDan.khlx"  class="span1-1" >
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.khlx==1?"selected":"" }>自主进店</option>
							 		<option value="2" ${shiGongDan.khlx==2?"selected":"" }>快速理赔</option>
							 		<option value="3" ${shiGongDan.khlx==3?"selected":"" }>自报保险</option>
							 		<option value="4" ${shiGongDan.khlx==4?"selected":"" }>协议单位</option>
							 		<option value="5" ${shiGongDan.khlx==5?"selected":"" }>返工免单</option>
							 		<option value="6" ${shiGongDan.khlx==6?"selected":"" }>i保养客户</option>
								</select>
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">收费类型：</td>
							<td width="10%" >
								<select name="shiGongDan.sflx"   class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.sflx==1?"selected":"" }>付现/刷卡</option>
							 		<option value="2" ${shiGongDan.sflx==2?"selected":"" }>会员消费</option>
							 		<option value="3" ${shiGongDan.sflx==3?"selected":"" }>保险赔付</option>
							 		<option value="4" ${shiGongDan.sflx==4?"selected":"" }>单位挂账</option>
							 		<option value="5" ${shiGongDan.sflx==5?"selected":"" }>免收费用</option>
							 		<option value="6" ${shiGongDan.sflx==6?"selected":"" }>i保养客户</option>
								</select>
							</td>
					 		<td width="7%" align="right" bgcolor="#f1f1f1">维修类型：</td>
							<td width="10%" >
								<select name="shiGongDan.wxlx"   class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.wxlx==1?"selected":"" }>保养维修</option>
							 		<option value="2" ${shiGongDan.wxlx==2?"selected":"" }>钣金喷漆</option>
							 		<option value="3" ${shiGongDan.wxlx==3?"selected":"" }>机电钣喷</option>
							 		<option value="4" ${shiGongDan.wxlx==4?"selected":"" }>洗车美容</option>
							 		<option value="5" ${shiGongDan.wxlx==5?"selected":"" }>商品零售</option>
								</select>
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">维修状态：</td>
							<td width="10%" >
								<select name="shiGongDan.wxzt"   class="span1-1">
							 		<option value="0">--请选择--</option>
							 		<option value="1" ${shiGongDan.wxzt==1?"selected":"" }>报价/备料</option>
							 		<option value="2" ${shiGongDan.wxzt==2?"selected":"" }>维修施工</option>
								</select>
							</td>
						</tr>
						 
						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">工单登记日期：</td>
							<td width="10%" >
								<input type="text"  name="shiGongDan.gddjrqb"  value="${shiGongDan.gddjrqb}"  class="laydate-icon span1-1"  id="Calendar1"  />&nbsp; 至 &nbsp; 
								<input type="text"  name="shiGongDan.gddjrqe"  value="${shiGongDan.gddjrqe}"  class="laydate-icon span1-1"  id="Calendar2"   />&nbsp; 止 &nbsp; 
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">预计完工日期：</td>
							<td width="10%" >
								<input type="text"  name="shiGongDan.btimey"  value="${shiGongDan.btimey}"  class="laydate-icon span1-1"  id="Calendar3"  />&nbsp; 至 &nbsp; 
								<input type="text"  name="shiGongDan.etimey"  value="${shiGongDan.etimey}"  class="laydate-icon span1-1"  id="Calendar4"   />&nbsp; 止 &nbsp; 
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">实际完工日期：</td>
							<td width="10%" >
								<input type="text"  name="shiGongDan.btimew"  value="${shiGongDan.btimew}"  class="laydate-icon span1-1"  id="Calendar5"  />&nbsp; 至 &nbsp; 
								<input type="text"  name="shiGongDan.etimew"  value="${shiGongDan.etimew}"  class="laydate-icon span1-1"  id="Calendar6"   />&nbsp; 止 &nbsp; 
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">保险到期日期：</td>
							<td width="10%" >
								<input type="text"  name="shiGongDan.btimebx"  value="${shiGongDan.btimebx}"  class="laydate-icon span1-1"  id="Calendar7"  />&nbsp; 至 &nbsp; 
								<input type="text"  name="shiGongDan.etimebx"  value="${shiGongDan.etimebx}"  class="laydate-icon span1-1"  id="Calendar8"   />&nbsp; 止 &nbsp; 
							</td>
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
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车辆品牌</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>车辆型号</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>客户类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>收费类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>维修类型</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>维修状态</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料状态</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工单登记日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>预计完工日期</strong></td>
							<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>实际完工日期</strong></td>
							<td width="9%" align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>操作</strong></td>
						</tr>
						
						<s:iterator value="shiGongDanList" var="list">
						<tr>
							<td align="center">&nbsp;${list.danhao }</td>
							<td align="center">&nbsp;${list.cphm }</td>
							<td align="center">&nbsp;${list.clpp }</td>
							<td align="center">&nbsp;${list.clxh }</td>
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
								<font color="red"  style="font-weight:bold">
								<c:if test="${list.wlzt eq 0}">未报料</c:if>
								<c:if test="${list.wlzt eq 1}">等待报价</c:if>
								<c:if test="${list.wlzt eq 2}">已报价</c:if>
								<c:if test="${list.wlzt eq 3}">申请备料</c:if>
								<c:if test="${list.wlzt eq 4}">备料到货</c:if>
								<c:if test="${list.wlzt eq 5}">领料出库</c:if>
								</font>
							</td>
							<td align="center">&nbsp;${list.gddjrq }</td>
							<td align="center">&nbsp;${list.yjwgrq }</td>  
							<td align="center">&nbsp;${list.sjwgrq }</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/shiGongDanAction!showShiGongDanByID?gdid=${list.gdid }">查看</a>&nbsp;&nbsp;
								<c:if test="${list.wlzt eq 2}">
								<a href="${pageContext.request.contextPath}/shiGongDanAction!showBeiLiaoShiGongDan?gdid=${list.gdid }">备料</a>&nbsp;&nbsp;
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
			laydate.skin('molv');
			laydate({
				elem : '#Calendar7',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
			laydate.skin('molv');
			laydate({
				elem : '#Calendar8',
					//istime : 'true',
					format : 'YYYY-MM-DD'
			});
		}();
	</script>





</body>
</html>