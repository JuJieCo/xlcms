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
	
	
	<script type="text/javascript">
	
	 
		function validateForm(formname){
			 var temp=/^\d+(\.\d+)?$/;
			 var thsl = $("#thsl").val();
			 var dqsl = $("#dqsl").val();
			 if(temp.test(thsl)==false){
				 alert("退货数量为空或不是纯数字!");
				 $("#thsl").focus();
				 return false;
			}
	
			 if(parseInt(thsl)>parseInt(dqsl)){
				 alert("当前库存数量为:"+dqsl+" , 退货数量大于库存数量!");
				 $("#thsl").focus();
				 return false;
			 }
		 			 
		}
 
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>库存管理<span class="divider">/</span>新增退货记录</li></ul>
			<div class="title_right">
				<strong>新增退货记录</strong>
			</div>
			 
			<form name="form" method="post" action="${pageContext.request.contextPath}/kuCunAction!modifyThglForUpdate"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
						
							<td width="7%" align="right" bgcolor="#f1f1f1">供货商：</td>
							<td width="10%">&nbsp;
								 ${rkjl.ghs.name} 
								 <input type="hidden" name="rkjl.rkid" id="rkid"  value="${rkjl.rkid}" />
								 <input type="hidden" name="rkjl.kuCun.kcid" id="kcid"  value="${rkjl.kuCun.kcid}" />
								 <input type="hidden" name="rkjl.ghs.ghsid" id="ghsid" value="${rkjl.ghs.ghsid}" />
								 <input type="hidden"  name="rkjl.danjia"  id="danjia"  value="${rkjl.danjia}" />
								 <input type="hidden"  name="rkjl.wlzl"  id="wlzl"  value="${rkjl.wlzl}" />
								 
								 <input type="hidden"  name="kcid"  id=""  value="${rkjl.kuCun.kcid}" />
								 <input type="hidden" name=""  id="dqsl" value=" ${rkjl.kuCun.dqsl}">
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">入库日期：</td>
							<td width="10%">&nbsp;
								${rkjl.rkrq}
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">单价：</td>
							<td width="10%">&nbsp;
								${rkjl.danjia}
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">物料质量：</td>
							<td width="10%">&nbsp;
								 <c:if test="${rkjl.wlzl eq 1 }">原车</c:if>
								 <c:if test="${rkjl.wlzl eq 2 }">其它</c:if>
							</td>
						</tr>
						 
						 <tr>
						 <td width="7%" align="right" bgcolor="#f1f1f1">进货数量：</td>
							<td>&nbsp;
								 ${rkjl.bcsl}
							</td>
							<td width="7%" align="right" bgcolor="#f1f1f1">退货数量：</td>
							<td colspan="5">
								<input type="text" name="thsl" id="thsl"  value="${thsl}" />
							</td>
						</tr>

						<tr>
							<td width="7%" align="right" bgcolor="#f1f1f1">退货原因：</td>
							<td colspan="7"><textarea name="rkjl.remark"  rows="3" cols="50" class="span11">${rkjl.remark}</textarea></td>
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
				elem : '#birthday',
				format : 'YYYY-MM-DD'
			});
			
			laydate.skin('molv'); 
			laydate({
				elem : '#entryDate',
				format : 'YYYY-MM-DD'
			});
			
			laydate.skin('molv');
			laydate({
				elem : '#leaveDate',
				format : 'YYYY-MM-DD'
			});
		}();
	</script>
</body>
</html>