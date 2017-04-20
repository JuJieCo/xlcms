<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>君益达管理系统</title>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resource/css/bootstrap.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resource/css/css.css" />
<script type="text/javascript"	src="${pageContext.request.contextPath}/resource/js/jquery1.9.0.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/resource/js/sdmenu.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/resource/js/laydate/laydate.js"></script>

 


<script type="text/javascript">
function validateForm(formname){
	for(var i=0 ; i<'${baoJiaList.size()}'; i++){  
		if($("#sfyh"+i).val()==1){
			if($("#duiliao"+i).val()!=""&&$("#rkrq"+i).val()==""){
					alert("库存对料有误!");
					 $("#duiliao"+i).focus();
					 return false;
			}
		}
	}
}
</script>



</head>
<body>
 <%@include file="/page/frame/top.jsp" %>
 <%@include file="/page/plugin/autocomplete_wlmc.jsp"%>
	<div class="right" id="mainFrame">
	<div class="right_cont">
		<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>报价管理 <span class="divider">/</span>修改备料单</li></ul>
			<div class="title_right">
				<strong>修改备料单</strong>
			</div>
				
<form name="form" method="post" action="${pageContext.request.contextPath}/baoJiaAction!modifyWlmcForUpdate"   onsubmit="return validateForm(this)">
	<s:token name="s_token"></s:token>
	<div style="width: 95%; margin: auto">
		<table class="table table-bordered">
			<tr>
				<td width="10%" align="right" bgcolor="#f1f1f1">施工单号：</td>
					<td>
						<input type="text" name="shiGongDan.danhao"  id="danhao"  class="span2" value="${shiGongDan.danhao}"  readonly="readonly"/>
						<input type="hidden" name="shiGongDan.gdid"   value="${shiGongDan.gdid}" />
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">车牌号码：</td>
					<td>
						<input type="text" name="shiGongDan.cphm"  id="cphm"  class="span1-1" value="${shiGongDan.cphm}" readonly="readonly"/>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">车辆品牌：</td>
					<td>
						<input type="text" name="shiGongDan.clpp"  id="clpp"  class="span1-1" value="${shiGongDan.clpp}" readonly="readonly"/>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">车辆型号：</td>
					<td>
						<input type="text" name="shiGongDan.clxh" id="clxh"  class="span1-1" value="${shiGongDan.clxh}"  readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td width="10%" align="right" bgcolor="#f1f1f1">车架号：</td>
					<td>
						<input type="text" name="shiGongDan.cjh"  id="cjh"  class="span2" value="${shiGongDan.cjh}" readonly="readonly"/>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">发动机号：</td>
					<td>
						<input type="text" name="shiGongDan.fdjh" class="span1-1" value="${shiGongDan.fdjh}" readonly="readonly"/>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">发动机排量：</td>
					<td >
						<input type="text" name="shiGongDan.fdjpx" class="span1-1" value="${shiGongDan.fdjpx}" readonly="readonly"/>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">生产日期：</td>
					<td>
						<input type="text" name="shiGongDan.danhao"  id="danhao"  class="span1-1" value="${shiGongDan.scrq}"  readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td width="10%" align="right" bgcolor="#f1f1f1">客户类型：</td>
					<td>
						<c:if test="${shiGongDan.khlx eq 1}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="自主进店" readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.khlx eq 2}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="快速理赔" readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.khlx eq 3}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="自报保险" readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.khlx eq 4}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="协议单位" readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.khlx eq 5}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="返工免单" readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.khlx eq 6}"><input type="text" name="shiGongDan.cllc" class="span1-1" value="i保养客户" readonly="readonly"/></c:if>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">收费类型：</td>
					<td>
						<c:if test="${shiGongDan.sflx eq 1}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1" value="付现/刷卡"  readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.sflx eq 2}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="会员消费"  readonly="readonly"/></c:if>	
						<c:if test="${shiGongDan.sflx eq 3}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="保险赔付"  readonly="readonly"/></c:if>	
						<c:if test="${shiGongDan.sflx eq 4}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="单位挂账"  readonly="readonly"/></c:if>	
						<c:if test="${shiGongDan.sflx eq 5}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="免收费用"  readonly="readonly"/></c:if>
						<c:if test="${shiGongDan.sflx eq 6}"><input type="text" name="shiGongDan.sflx"  id="sflx"  class="span1-1"  value="i保养客户"  readonly="readonly"/></c:if>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">保险预计赔付：</td>
					<td>
						<input type="text" name="shiGongDan.cphm"  id="yjpf"  class="span1-1" value="${shiGongDan.yjpf}" readonly="readonly"/>
					</td>
					<td width="10%" align="right" bgcolor="#f1f1f1">协议单位名称：</td>
					<td>
						<input type="text" name="shiGongDan.clxh" id="dwmc"  class="span1-1" value="${shiGongDan.dwmc}"  readonly="readonly"/>
					</td>
				</tr>
			</table>
			 
			<table class="table table-bordered" id="count">
				<tr>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>备料状态</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>是否要货</strong></td>
					<td  align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料名称</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料质量</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>数量</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>申请报价日期</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>申请备料日期</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>物料费(单价)</strong></td>
					<td align="center" nowrap="nowrap" bgcolor="#f1f1f1"><strong>工时费</strong></td>
				</tr>
				
				<tr>
					<td align="center">&nbsp;
						<font color="red">
						<c:if test="${baoJia.bjzt eq 1}">等待报价</c:if> 
						<c:if test="${baoJia.bjzt eq 2}">已报价</c:if> 
						<c:if test="${baoJia.bjzt eq 3}">申请备料</c:if>
						<c:if test="${baoJia.bjzt eq 4}">备料到货</c:if> 
						<c:if test="${baoJia.bjzt eq 5}">领料出库</c:if>
						</font>
					</td>
					<td align="center">&nbsp;
						 <c:if test="${baoJia.sfyh eq 0}">否</c:if>
						 <font color="red">
						 <c:if test="${baoJia.sfyh eq 1}">是</c:if>
						 </font>
					</td>
					<td align="center">&nbsp;
						<input type="text" name="baoJia.wlmc"  id="wlmc"  class="span5" value="${baoJia.wlmc}" />
						<input type="hidden" name="baoJia.bjid"   value="${baoJia.bjid}" />
					</td>  
					<td align="center">&nbsp;
						<c:if test="${baoJia.wlzl eq 1}">原车</c:if> 
						<c:if test="${baoJia.wlzl eq 2}">其它</c:if> 
					</td>
					<td align="center">&nbsp;${baoJia.shuliang}</td>
					<td align="center">&nbsp;${baoJia.bjrq }</td>
					<td align="center">&nbsp;${baoJia.fhrq }</td>
					<td align="center">&nbsp;${baoJia.danjia }</td>
					<td align="center">&nbsp;${baoJia.gsf}</td>
				</tr>
				
			</table>
			<table class="margin-bottom-20 table  no-border">
				<tr>
					<td class="text-center">
						<input type="submit" value="提交"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" />
						<input type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>	
					</td>
				</tr>
			</table>
			</div>
</form>
	</div>
	</div>
</div>


	<!-- 底部 -->
	<div id="footer">
		版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp; 
	</div>
</body>
</html>