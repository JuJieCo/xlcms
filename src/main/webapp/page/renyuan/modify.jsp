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
			 var name = $("#name").val();
			 var birthday = $("#birthday").val();
			 var idcard = $("#idcard").val();
			 var dept = $("#dept").val();
			 var duty = $("#duty").val();
			 var level = $("#level").val();
			 var workType = $("#workType").val();
			 var entryDate = $("#entryDate").val();
			 var leaveDate = $("#leaveDate").val();
			 var status = $("#status").val();
			 
			 if($.trim(name)==""){
				 alert("姓名为空!");
				 $("#name").focus();
				 return false;
			}
			 if($.trim(birthday)==""){
				 alert("出生年月为空!");
				 $("#birthday").focus();
				 return false;
			}
			 if($.trim(idcard)==""){
				 alert("身份证号为空!");
				 $("#idcard").focus();
				 return false;
			}
			 if(dept==0){
				 alert("部门未设置!");
				 $("#dept").focus();
				 return false;
			}
			 if($.trim(duty)==""){
				 alert("职务为空!");
				 $("#duty").focus();
				 return false;
			}
			 if(level==0){
				 alert("级别未设置!");
				 $("#level").focus();
				 return false;
			}
			 if(workType==0){
				 alert("工种未设置!");
				 $("#workType").focus();
				 return false;
			}
			 if($.trim(entryDate)==""){
				 alert("入职时间为空!");
				 $("#entryDate").focus();
				 return false;
			}
			 if(status==2){
				 if($.trim(leaveDate)==""){
					 alert("离职时间为空!");
					 $("#leaveDate").focus();
					 return false;
				}
			 }
			 if(leaveDate!=""){
				if(status==1){
					alert("人员状态有误!!");
					$("#status").focus();
					return false;
				}
			 }
			 
		}
 
	</script>
</head>
<body>
	<%@include file="/page/frame/top.jsp"%>
	<div class="right" id="mainFrame">
		<div class="right_cont">
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>人员管理<span class="divider">/</span>创建人员信息</li></ul>
			<div class="title_right">
				<strong>创建人员信息</strong>
			</div>
			 
			<form name="form" method="post" action="${pageContext.request.contextPath}/ryglAction!modifyRygl"   onsubmit="return validateForm(this)">
				<s:token name="s_token"></s:token>
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">姓名：</td>
							<td>
								<input type="text" name="rygl.name"  id="name"  class="span1-1" value="${rygl.name}" />
								<input type="hidden" name="rygl.ryid" id="ryid"  value="${rygl.ryid}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">性别：</td>
							<td>
								<select name="rygl.sex"  id="sex"  class="span1-1"  >
									<option value="1" ${rygl.sex ==1 ?"selected":""}>男</option>
									<option value="2" ${rygl.sex ==2 ?"selected":""}>女</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">出生年月：</td>
							<td>
								<input type="text"  name="rygl.birthday"  id="birthday" class="laydate-icon span1-1"  value="${rygl.birthday}"  readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">身份证号：</td>
							<td>
								<input type="text" name="rygl.idcard" id="idcard"  class="span2" value="${rygl.idcard}" />
							</td>
						</tr>
						<tr>
						<td width="10%" align="right" bgcolor="#f1f1f1">家庭住址：</td>
							<td colspan="8">
								<input type="text" name="rygl.address"  id="address"  class="span7" value="${rygl.address}" />
							</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">部门：</td> 
							<td >
								<select name="rygl.dept"  id="dept"  class="span1-1">
									<option value="0" ${rygl.dept==0?"selected":"" }>--请选择--</option>
									<option value="1" ${rygl.dept==1?"selected":"" }>前台</option>
									<option value="2" ${rygl.dept==2?"selected":"" }>快速理赔</option>
									<option value="3" ${rygl.dept==3?"selected":"" }>机修车间</option>
									<option value="4" ${rygl.dept==4?"selected":"" }>钣喷车间</option>
									<option value="5" ${rygl.dept==5?"selected":"" }>美容装潢车间</option>
									<option value="6" ${rygl.dept==6?"selected":"" }>洗车房</option>
									<option value="7" ${rygl.dept==7?"selected":"" }>行政/财务部门</option>
									<option value="8" ${rygl.dept==8?"selected":"" }>库房</option>
									<option value="9" ${rygl.dept==9?"selected":"" }>后勤部门</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">职务：</td>
							<td>
								<input type="text" name="rygl.duty"  id="duty"  class="span1-1" value="${rygl.duty}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">级别：</td> 
							<td>
								<select name="rygl.level"  id="level"  class="span1-1">
									<option value="0" ${rygl.level==0?"selected":"" }>--请选择--</option>
									<option value="1" ${rygl.level==1?"selected":"" }>大工</option>
									<option value="2" ${rygl.level==2?"selected":"" }>中工</option>
									<option value="3" ${rygl.level==3?"selected":"" }>小工</option>
									<option value="4" ${rygl.level==4?"selected":"" }>学徒</option>
									<option value="5" ${rygl.level==5?"selected":"" }>其他</option>
								</select>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">工种：</td>
							<td>
								<select name="rygl.workType"  id="workType"  class="span1-1">
									<option value="0" ${rygl.workType==0?"selected":"" }>--请选择--</option>
									<option value="1" ${rygl.workType==1?"selected":"" }>接待服务</option>
									<option value="2" ${rygl.workType==2?"selected":"" }>机电工</option>
									<option value="3" ${rygl.workType==3?"selected":"" }>钣金工</option>
									<option value="4" ${rygl.workType==4?"selected":"" }>喷漆工</option>
									<option value="5" ${rygl.workType==5?"selected":"" }>美容工</option>
									<option value="6" ${rygl.workType==6?"selected":"" }>洗车工</option>
									<option value="7" ${rygl.workType==7?"selected":"" }>行政/财务</option>
									<option value="8" ${rygl.workType==8?"selected":"" }>库管员</option>
									<option value="9" ${rygl.workType==9?"selected":"" }>后勤人员</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">最高学历：</td>
							<td>
								<input type="text" name="rygl.education"  id="education" class="span1-1" value="${rygl.education}" />
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">入职时间：</td>
							<td >
								<input type="text" name="rygl.entryDate"  id="entryDate"  class="laydate-icon span1-1"  value="${rygl.entryDate}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">离职时间：</td>
							<td >
								 <input type="text" name="rygl.leaveDate"  id="leaveDate"  class="laydate-icon span1-1"  value="${rygl.leaveDate}" readonly="readonly"/>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">状态：</td>
							<td >
								  <select name="rygl.status"  id="status"  class="span1-1"  >
									<option value="1" ${rygl.status ==1 ?"selected":""}>在职</option>
									<option value="2" ${rygl.status ==2 ?"selected":""}>离职</option>
								</select>
							</td>
						</tr>

						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">备注：</td>
							<td colspan="8"><textarea name="rygl.remark"  rows="3" cols="50" class="span11">${rygl.remark}</textarea></td>
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