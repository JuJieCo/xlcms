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
			 var name = $("#name").val();
			 
			 
			 if($.trim(name)==""){
				 alert("名称为空!");
				 $("#name").focus();
				 return false;
			}
			 
		}
 
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>供货商管理<span class="divider">/</span>创建供货商信息</li></ul>
			<div class="title_right">
				<strong>创建供货商信息</strong>
			</div>
			 
			<form name="form" method="post" action="${pageContext.request.contextPath}/ghsglAction!modifyGhsgl"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">名称：</td>
							<td>
								<input type="text" name="ghsgl.name"  id="name"  class="span2" value="${ghsgl.name}" />
								<input type="hidden" name="ghsgl.ghsid" id="ghsid"  value="${ghsgl.ghsid}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">状态：</td>
							<td >
								  <select name="ghsgl.status"  id="status"  class="span1-1"  >
									<option value="1" ${ghsgl.status ==1 ?"selected":""}>正常</option>
									<option value="2" ${ghsgl.status ==2 ?"selected":""}>停用</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">联系电话1：</td>
							<td>
								<input type="text" name="ghsgl.lxdh1"  id=lxdh1  class="span2" value="${ghsgl.lxdh1}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">联系电话2：</td>
							<td >
								  <input type="text" name="ghsgl.lxdh2"  id="lxdh2"  class="span2" value="${ghsgl.lxdh2}" />
							</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">地址：</td>
							<td colspan="3">
								<input type="text" name="ghsgl.address"  id="address"  class="span7" value="${ghsgl.address}" />
							</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">备注：</td>
							<td colspan="3"><textarea name="ghsgl.remark"  rows="3" cols="50" class="span11">${ghsgl.remark}</textarea></td>
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