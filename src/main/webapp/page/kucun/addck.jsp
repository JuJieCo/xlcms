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
	<%@include file="/page/plugin/autocomplete_kucun_ckgl.jsp"%>
	
	<div class="right" id="mainFrame"> 
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理<span class="divider">/</span>创建油漆辅料出库记录</li></ul>
			<div class="title_right">
				<strong>创建油漆辅料出库记录</strong>
			</div>
			 
<form name="form" method="post" action="${pageContext.request.contextPath}/kuCunAction!modifyCkglForSave"  onkeydown="if(event.keyCode==13)return false;"  onsubmit="return validateForm(this)">
<s:token name="s_token"></s:token>
<div style="width: 95%; margin: auto">
		<table class="table table-bordered"   id="count" >		  
		<tr>
			<td align="center" bgcolor="#f1f1f1">序号</td>
			<td align="center" bgcolor="#f1f1f1">物料名称</td>
			<td align="center" bgcolor="#f1f1f1">出库数量</td>
			<td align="center" bgcolor="#f1f1f1">物料类型</td>
			<td align="center" bgcolor="#f1f1f1">领用人</td>
		</tr>
		<tr>
			<td align="center">1</td>
		 	<td align="center"><input type="text"  name="ckgl.wlmc"  id="wlmc" value="${ckgl.wlmc}"  class="span1-1"/></td>
		 	<td align="center"><input type="text"  name="ckgl.cksl"  id="cksl" value="${ckgl.cksl}"  class="span1-1"/></td>
			<td align="center">
				<select name="ckgl.wllx"  id="wllx"  class="span1">
					<option value="0">-请选择-</option>
					<option value="7">辅料</option>
					<option value="8">油漆</option>
				</select>
			</td>
			<td align="center">
				<input type="text"  name="ckgl.remark"  id="remark"  value="${ckgl.remark}"   class="span1-1"/>
				<input type="hidden"  name="ckgl.rkjl.rkid"  id="rkid"  value="${ckgl.rkjl.rkid}" />
				<input type="hidden"  name="ckgl.rkjl.kuCun.kcid"  id="kcid"  value="${ckgl.rkjl.kuCun.kcid}" />
				<input type="hidden"  name="tag"  id="tag"  value="yfck" />
				
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



	<script>
	
		!function() {
			laydate.skin('molv');
			laydate({
				elem : '#Calendar1',
				format : 'YYYY-MM-DD'
			});
		}();
	</script>
	

</body>
</html>