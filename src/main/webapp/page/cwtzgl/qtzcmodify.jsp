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
			 var kmname = $("#kmname").val();
			 var jine = $("#jine").val();
			 
			 if($.trim(kmname)==""){
				 alert("科目名称为空!");
				 $("#kmname").focus();
				 return false;
			}
			 
				if(temp.test(jine)==false){
					 alert("金额不正确!");
					 $("#jine").focus();
					 return false;
				}
			 
		}
 
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>财务台账管理<span class="divider">/</span>其他支出台账管理</li></ul>
			<div class="title_right">
				<strong>创建其他支出台账信息</strong>
			</div>
			 
			<form name="form" method="post" action="${pageContext.request.contextPath}/cwtzglAction!modifyCwtzglQTZC"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">发生日期：</td>
							<td>
								<input type="text" name="cwtzgl.fsdate"  id="fsdate"  value="${cwtzgl.fsdate}"  class="laydate-icon span2" />
								<input type="hidden" name="cwtzgl.cwid" id="cwid"  value="${cwtzgl.cwid}" />
								<input type="hidden" name="cwtzgl.sztype" id="sztype"  value="${cwtzgl.sztype}" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">科目名称：</td>
							<td>
								<input type="text" name="cwtzgl.kmname"  id="kmname"  class="span2" value="${cwtzgl.kmname}" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">金额：</td>
							<td>
								<input type="text" name="cwtzgl.jine"  id="jine"  class="span2" value="${cwtzgl.jine}" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">摘要：</td>
							<td>
								<input type="text" name="cwtzgl.zhaiyao"  id="zhaiyao"  class="span7" value="${cwtzgl.zhaiyao}" />
							</td>
						</tr>
						<tr>
							<td width="15%" align="right" bgcolor="#f1f1f1">备注：</td>
							<td colspan="3"><textarea name="cwtzgl.remark"  rows="3" cols="50" class="span11">${cwtzgl.remark}</textarea></td>
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
				elem : '#fsdate',
				format : 'YYYY-MM-DD'
			});
		}();
	</script>
</body>
</html>