<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/add.js"></script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理<span class="divider">/</span>修改入库记录</li></ul>
			<div class="title_right">
				<strong>修改入库记录</strong>
			</div>
			 
<form name="form" method="post" action="${pageContext.request.contextPath}/kuCunAction!modifyRkjlForModifyAsUpdate"   onsubmit="return validateForm(this)">
<s:token name="s_token"></s:token>
<div style="width: 95%; margin: auto">
	<table class="table table-bordered" >		  
		<tr>
			<td align="center" bgcolor="#f1f1f1">入库日期</td>
			<td align="center" bgcolor="#f1f1f1">本次进货数量</td>
			<td align="center" bgcolor="#f1f1f1">单价</td>
			<td align="center" bgcolor="#f1f1f1">供货商</td>
			<td align="center" bgcolor="#f1f1f1">物料质量</td>
			<td align="center" bgcolor="#f1f1f1">备注</td>
		</tr>
		<tr>
			<td align="center">&nbsp;${rkjl.rkrq}</td>
			<td align="center"><input type="text"  name="rkjl.bcsl"  id="bcsl" value="${rkjl.bcsl}"  class="span1"/></td>
			<td align="center"><input type="text"  name="rkjl.danjia"  id="danjia" value="${rkjl.danjia}"  class="span1"/></td>
			<td align="center">
				<select name="rkjl.ghs.ghsid"  id="ghsid"  class="span1">
					 	<option value="0" ${rkjl.ghs.ghsid==0?"selected":"" }>--请选择--</option>
					 	<s:iterator value="ghsglList" var="list">
   							<option value="${list.ghsid}"  ${rkjl.ghs.ghsid==list.ghsid?"selected":"" }>${list.name}</option>
						</s:iterator>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.wlzl"  id="wlzl"  class="span1">
					<option value="0" ${rkjl.wlzl==0?"selected":"" }>--请选择--</option>
					<option value="1" ${rkjl.wlzl==1?"selected":"" }>原车</option>
					<option value="2" ${rkjl.wlzl==2?"selected":"" }>其他</option>
				</select>
			</td>
			<td align="center">
				<input type="text"  name="rkjl.remark"  id="remark"  value="${rkjl.remark}"   class="span2"/>
				<input type="hidden"  name="rkjl.rkid"  id="rkid"  value="${rkjl.rkid}" />
				<input type="hidden"  name="rkjl.kuCun.kcid"  id="kcid"  value="${rkjl.kuCun.kcid}" />
				<input type="hidden"  name="kcid"  id=""  value="${rkjl.kuCun.kcid}" />
			</td>
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
	<div id="footer">版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp;</div>
</body>
</html>