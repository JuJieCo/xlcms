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

<script type='text/javascript'>
$(document).ready(function() {
		var oTable = $("#count"), iNum = 1, eEle = '';
		oTable.on('click', function(e) {
			
			var target = e.target, oTr = $(target).closest('tr');
			if (oTr.index() == oTable.find('tr').last().index()) {
				iNum++;
				
				eEle = oTr.clone();
				eEle.find('td').eq(0).text(iNum);
			}
			var num = iNum-2;
			eEle.find('input').eq(0).attr("name","rkjlList["+num+"].kuCun.wlmc");
			eEle.find('input').eq(0).attr("id","wlmc"+num);
		 
			eEle.find('input').eq(1).attr("name","rkjlList["+num+"].bcsl");
			eEle.find('input').eq(2).attr("name","rkjlList["+num+"].danjia");
			
			eEle.find('select').eq(0).attr("name","rkjlList["+num+"].ghs.ghsid");
			eEle.find('select').eq(0).attr("id","ghsid"+num);
			
			eEle.find('select').eq(1).attr("name","rkjlList["+num+"].kuCun.wllx");
			eEle.find('select').eq(1).attr("id","wllx"+num);
			
		 
			eEle.find('select').eq(2).attr("name","rkjlList["+num+"].kuCun.huowei");
			eEle.find('select').eq(2).attr("id","huowei"+num);
			
			eEle.find('select').eq(3).attr("name","rkjlList["+num+"].wlzl");
			eEle.find('select').eq(3).attr("id","wlzl"+num);
			
			eEle.find('input').eq(3).attr("name","rkjlList["+num+"].kuCun.remark");
			eEle.find('input').eq(4).attr("name","rkjlList["+num+"].kuCun.kcid");
			eEle.find('input').eq(4).attr("id","kcid"+num);
			//alert(eEle.find('input').eq(0).attr("id"));
			oTable.append(eEle);
	});
});
</script>


</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
 
	
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理<span class="divider">/</span>创建调漆用料登记</li></ul>
			<div class="title_right">
				<strong>创建调漆用料登记</strong>
			</div>
			 
<form name="form" method="post" action="${pageContext.request.contextPath}/kuCunAction!modifyKuCunTQForSave"   onkeydown="if(event.keyCode==13)return false;"  onsubmit="return validateForm(this)">
<s:token name="s_token"></s:token>
<div style="width: 95%; margin: auto">
		<table class="table table-bordered"   id="count" >		  
		<tr>
			<td align="center" bgcolor="#f1f1f1">序号</td>
			<td align="center" bgcolor="#f1f1f1">物料名称</td>
			<td align="center" bgcolor="#f1f1f1">调漆克数</td>
			<td align="center" bgcolor="#f1f1f1">进货单价</td>
			<td align="center" bgcolor="#f1f1f1">供货商</td>
			<td align="center" bgcolor="#f1f1f1">物料类型</td>
			<td align="center" bgcolor="#f1f1f1">货位</td>
			<td align="center" bgcolor="#f1f1f1">物料质量</td>
			<td align="center" bgcolor="#f1f1f1">领用人</td>
		</tr>
		<tr>
			<td align="center">1</td>
			<td align="center"><input type="text"  name="rkjl.kuCun.wlmc"  id="wlmc" value="${rkjl.kuCun.wlmc}"  class="span1-1"/></td>
			<td align="center"><input type="text"  name="rkjl.bcsl"  id="bcsl"  value="${rkjl.bcsl}"  class="span1"/></td>
			<td align="center"><input type="text"  name="rkjl.danjia"  id="danjia"  value="0"  class="span1"  readonly="readonly"/></td>
			<td align="center">
				<select name="rkjl.ghs.ghsid"  id="ghsid"  class="span1">
					<option value="13">五一油漆</option>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.kuCun.wllx"  id="wllx"  class="span1">
					<option value="8">油漆</option>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.kuCun.huowei"  id="huowei"  class="span1">
					<option value="1">通道1</option>
				</select>
			</td>
			<td align="center">
				<select name="rkjl.wlzl"  id="wlzl"  class="span1">
					<option value="2">其它</option>
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