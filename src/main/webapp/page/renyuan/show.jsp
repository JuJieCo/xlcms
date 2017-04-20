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
			<ul class="breadcrumb"> <li>当前位置：首页<span class="divider">/</span>人员管理<span class="divider">/</span>查看人员信息</li></ul>
			<div class="title_right">
				<strong>查看人员信息</strong>
			</div>
			 
				<div style="width: 95%; margin: auto">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">姓名：</td>
							<td>&nbsp;${rygl.name}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">性别：</td>
							<td>&nbsp;
								<c:if test="${rygl.sex eq 1 }">男</c:if>
						 		<c:if test="${rygl.sex eq 2 }">女</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">出生年月：</td>
							<td>&nbsp;${rygl.birthday}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">身份证号：</td>
							<td>&nbsp;${rygl.idcard}</td>
						</tr>
						<tr>
						<td width="10%" align="right" bgcolor="#f1f1f1">家庭住址：</td>
							<td colspan="8">&nbsp;${rygl.address}</td>
						</tr>
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">部门：</td> 
							<td >&nbsp;
								<c:if test="${rygl.dept eq 1 }">前台</c:if>
								<c:if test="${rygl.dept eq 2 }">快速理赔</c:if>
								<c:if test="${rygl.dept eq 3 }">机修车间</c:if>
								<c:if test="${rygl.dept eq 4 }">钣喷车间</c:if>
								<c:if test="${rygl.dept eq 5 }">美容装潢车间</c:if>
								<c:if test="${rygl.dept eq 6 }">洗车房</c:if>
								<c:if test="${rygl.dept eq 7 }">行政/财务部门</c:if>
								<c:if test="${rygl.dept eq 8 }">库房</c:if>
								<c:if test="${rygl.dept eq 9 }">后勤部门</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">职务：</td>
							<td>&nbsp;${rygl.duty}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">级别：</td> 
							<td>&nbsp;
								<c:if test="${rygl.level eq 1 }">大工</c:if>
								<c:if test="${rygl.level eq 2 }">中工</c:if>
								<c:if test="${rygl.level eq 3 }">小工</c:if>
								<c:if test="${rygl.level eq 4 }">学徒</c:if>
								<c:if test="${rygl.level eq 5 }">其他</c:if>
							</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">工种：</td>
							<td>&nbsp;
									<c:if test="${rygl.workType eq 1 }">接待服务</c:if>
									<c:if test="${rygl.workType eq 2 }">机电工</c:if>
									<c:if test="${rygl.workType eq 3 }">钣金工</c:if>
									<c:if test="${rygl.workType eq 4 }">喷漆工</c:if>
									<c:if test="${rygl.workType eq 5 }">美容工</c:if>
									<c:if test="${rygl.workType eq 6 }">洗车工</c:if>
									<c:if test="${rygl.workType eq 7 }">行政/财务</c:if>
									<c:if test="${rygl.workType eq 8 }">库管员</c:if>
									<c:if test="${rygl.workType eq 9 }">后勤人员</c:if>
							</td>
						</tr>
						
						<tr>
							<td width="10%" align="right" bgcolor="#f1f1f1">最高学历：</td>
							<td>&nbsp;${rygl.education}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">入职时间：</td>
							<td>&nbsp;${rygl.entryDate}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">离职时间：</td>
							<td>${rygl.leaveDate}</td>
							<td width="10%" align="right" bgcolor="#f1f1f1">状态：</td>
							<td>&nbsp;
									<c:if test="${rygl.status eq 1 }">在职</c:if>
									<c:if test="${rygl.status eq 2 }">离职</c:if>
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
							<input type="button" value="返回"  id="modal-9735581" class="btn btn-info btn-small" style="width: 80px;" onclick="history.go(-1)"/>	
							</td>
						</tr>
					</table>
				</div>

		</div>
	</div>
	</div>

	<!-- 底部 -->
	<div id="footer">版权所有：jujie &copy; 2016&nbsp;&nbsp;&nbsp;&nbsp;</div>
</body>
</html>