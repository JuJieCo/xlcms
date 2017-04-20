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
	<%@include file="/page/plugin/autocomplete_kucun_zy.jsp"%>
	
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理<span class="divider">/</span>创建专用配件库存</li></ul>
			<div class="title_right">
				<strong>创建专用配件库存</strong>
			</div>
			 
<form name="form" method="post" action="${pageContext.request.contextPath}/kuCunAction!modifyKuCunZYForSave"  onkeydown="if(event.keyCode==13)return false;"   onsubmit="return validateForm(this)">
<s:token name="s_token"></s:token>
<div style="width: 95%; margin: auto">
	<table class="table table-bordered"   id="count" >		  
		<tr>
			<td align="center" bgcolor="#f1f1f1">序号</td>
			<td align="center" bgcolor="#f1f1f1">车辆品牌</td>
			<td align="center" bgcolor="#f1f1f1">车辆型号</td>
			<td align="center" bgcolor="#f1f1f1">物料名称</td>
			<td align="center" bgcolor="#f1f1f1">库存数量</td>
			<td align="center" bgcolor="#f1f1f1">进货数量</td>
			<td align="center" bgcolor="#f1f1f1">进货单价</td>
			<td align="center" bgcolor="#f1f1f1">供货商</td>
			<td align="center" bgcolor="#f1f1f1">物料类型</td>
			<td align="center" bgcolor="#f1f1f1">物料质量</td>
			<td align="center" bgcolor="#f1f1f1">货位</td>
			<td align="center" bgcolor="#f1f1f1">备注</td>
		</tr>
		<tr>
			<td align="center">1</td>  
			<td align="center"><input type="text"  name="rkjl.kuCun.clpp"  id="clpp" value="${rkjl.kuCun.clpp}"  class="span1"/></td>
			<td align="center"><input type="text"  name="rkjl.kuCun.clxh"  id="clxh" value="${rkjl.kuCun.clxh}"  class="span1"/></td>
			<td align="center"><input type="text"  name="rkjl.kuCun.wlmc"  id="wlmc" value="${rkjl.kuCun.wlmc}"  class="span1-1"/></td>
			<td align="center"><input type="text"  name="rkjl.kuCun.dqsl"  id="dqsl"  value="${rkjl.kuCun.dqsl}"  class="span1" readonly="readonly"/></td>
			<td align="center"><input type="text"  name="rkjl.bcsl"  id="bcsl"  value="${rkjl.bcsl}"  class="span1"/></td>
			<td align="center"><input type="text"  name="rkjl.danjia"  id="danjia"  value="${rkjl.danjia}"  class="span1" /></td>
			<td align="center">
				<select name="rkjl.ghs.ghsid"  id="ghsid"  class="span1">
					<option value="0">-请选择-</option>
					<s:iterator value="ghsglList" var="list">
						<option value="${list.ghsid}">${list.name}</option>
					</s:iterator>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.kuCun.wllx"  id="wllx"  class="span1">
					<option value="0">-请选择-</option>
					<option value="1">油水</option>
					<option value="2">滤芯</option>
					<option value="3">清洗剂</option>
					<option value="4">刹车片</option>
					<option value="5">火花塞</option>
					<option value="6">配件</option>
					<option value="7">辅料</option>
					<option value="8">油漆</option>
					<option value="9">玻璃</option>
					<option value="10">其它</option>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.wlzl"  id="wlzl"  class="span1">
					<option value="0">-请选择-</option>
					<option value="1">原车</option>
					<option value="2">其它</option>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.kuCun.huowei"  id="huowei"  class="span1">
					<option value="0">-请选择-</option>
					<option value="1">通道1</option>
					<option value="2">通道2</option>
					<option value="3">通道3</option>
					<option value="4">通道4</option>
					<option value="5">通道5</option>
					<option value="6">通道6</option>
					<option value="7">通道7</option>
					<option value="8">通道8</option>
				</select>
			</td>
			<td align="center">
				<input type="text"  name="rkjl.kuCun.remark"  id="remark"  value="${rkjl.kuCun.remark}"   class="span1-1"/>
				<input type="hidden"  name="rkjl.kuCun.kcid"  id="kcid"  value="${rkjl.kuCun.kcid}" />
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